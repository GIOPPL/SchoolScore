package com.gioppl.scorelibrary.model.server

import android.util.Log
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
class DownScoreMolder() :ReportServerModel  {
    var subscriber: Subscriber<String>?=null
    override fun onCheck(account: String, pwd: String,subscriber: Subscriber<String>) {
        this.subscriber=subscriber
        Thread(Runnable {
            getScore1(account,pwd)
        }).start()
    }
    override fun onError() {
        //
    }


    private var StudentAccount :String?=null
    private var StudentPassword :String?=null

    fun getScore1(account:String,psw:String){
        StudentAccount=account
        StudentPassword=psw

        val xml=getDocument().toString()
        Flowable.just(xml)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber)
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