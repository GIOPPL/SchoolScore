package com.gioppl.myscore

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.TextView
import com.gioppl.scorelibrary.model.entity.ScoreEntity
import com.gioppl.scorelibrary.present.ScorePresent
import com.gioppl.scorelibrary.view.ScoreView
import com.gioppl.scorelibrary.view.activity.MyScoreActivity

class MainActivity : AppCompatActivity(), ScoreView {// step 1,实现ScoreView接口
    var mPresent: ScorePresent?=null
    var tv_main:TextView?=null

    //成功的情况返回一个ArrayList，下面是ScoreEntity的属性
    /**
        var id:String?=null
        var number:String?=null
        var courseName: String? = null//课程名
        var EnglishName:String?=null//英语名
        var credit: String? = null//学分
        var nature:String?=null//课程属性
        var score: String? = null//成绩
        var reasonOfNoPass:String?=null//未通过原因
     */
    override fun onSuccess(xml: ArrayList<ScoreEntity>) {
        var text=""
        for (x in xml){
            text+=x.courseName
        }
        tv_main!!.text=text
    }

    override fun onError(result: String) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv_main=findViewById(R.id.tv_main) as TextView
        mPresent= ScorePresent(scoreView = this);
    }

    public fun myScore(view: View) {
        var intent= Intent(this, MyScoreActivity::class.java)
        startActivity(MyScoreActivity.toScoreActivity(this,"学号","密码"))
        finish()
    }
    public fun getScore(view: View){
        mPresent!!.getScore("学号","密码")// step 2,填写学号密码
    }
}
