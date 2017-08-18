package com.gioppl.scorelibrary.model.server

import android.util.Log
import com.gioppl.scorelibrary.model.entity.ScoreEntity
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.jsoup.Connection
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.reactivestreams.Subscriber
import java.io.IOException

/**
 * Created by GIOPPL on 2017/8/16.
 */
class DownScoreMolder() : ReportServerModel {
    var mList: ArrayList<ScoreEntity>? = null
    var subscriber: Subscriber<ArrayList<ScoreEntity>>? = null
    override fun onCheck(account: String, pwd: String, subscriber: Subscriber<ArrayList<ScoreEntity>>) {
        this.subscriber = subscriber
        Thread(Runnable {
            mList = ArrayList()
            getScore1(account, pwd)
        }).start()
    }

    override fun onError() {
        //
    }


    private var StudentAccount: String? = null
    private var StudentPassword: String? = null

    fun getScore1(account: String, psw: String) {
        StudentAccount = account
        StudentPassword = psw

        val xml = getDocument()
//        log(xml.toString())

        Flowable.just(dataManage(xml!!))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
        log("大小是"+mList!!.size)
    }

    //xml文件处理成类
    private fun dataManage(xml: Document):ArrayList<ScoreEntity> {
        val element = xml.getElementById("user")
        val trElements = element.select("tr")
        for (i in trElements.indices) {
            val tdElements = trElements[i].select("td")
            var flag=0;
            var id: String? = null
            var number: String? = null
            var courseName: String? = null//课程名
            var EnglishName: String? = null//英语名
            var credit: String? = null//学分
            var nature: String? = null//课程属性
            var score: String? = null//成绩
            var reasonOfNoPass: String? = null//未通过原因
            for (j in tdElements.indices) {
                var text = tdElements[j].text()
                when (j) {
                    0 -> id = text
                    1 -> number = text
                    2 -> courseName = text
                    3 -> EnglishName = text
                    4 -> credit = text
                    5 -> nature = text
                    6 -> score = text
                    7 -> {
                        reasonOfNoPass = text
                        mList!!.add(ScoreEntity(id, number, courseName, EnglishName, credit, nature, score, reasonOfNoPass))
                        flag=-1
                    }
                }
                flag++
            }
        }
        return mList!!;
    }


//get the html cookies
fun getCookies(): String {
    try {
        val con = Jsoup.connect("http://202.113.244.44:9013/loginAction.do")
                .data("zjh", StudentAccount)
                .data("mm", StudentPassword)
                .timeout(10000)
                .method(Connection.Method.POST)
        con.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:52.0) Gecko/20100101 Firefox/52.0")
        Log.i("StudentAP_StuInFor", StudentAccount + "," + StudentPassword)
        val response: Connection.Response
        response = con.execute()

        val doc = response.parse()
        if (doc.title() == "学分制综合教务") {
            val ite = response.cookies().entries.iterator()
            while (ite.hasNext()) {
                val entry = ite.next()
                val key = entry.key
                val value = entry.value
                if (key == "JSESSIONID")
                    return value
            }
            return "100"    // TODO 错误代码100：未获取到SESSION
        }
        val prompt = doc.getElementsByAttributeValue("class", "errorTop").first()
        val strong: java.lang.String = prompt.select("strong>font").text() as java.lang.String

        if (strong.contains("不存在")) {
            return "101"    // TODO 错误代码101：学号不存在
        } else if (strong.contains("密码不正确")) {
            return "102"    // TODO 错误代码102：密码不正确
        } else {
            return "103"    // TODO 错误代码103：网页格式错误
        }
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return "No COOKIES"
}

//get student score information
fun getDocument(): Document? {
    val cookies = getCookies()
    try {
        val doc = Jsoup.connect("http://202.113.244.44:9013/gradeLnAllAction.do?type=ln&oper=fainfo&fajhh=3057")
                .cookie("JSESSIONID", cookies)
                .timeout(10000)
                .get()

        return doc
    } catch (e: IOException) {
        e.printStackTrace()
    }

    return null
}

fun log(text: String = "没有东西") = Log.i("**", text)
}