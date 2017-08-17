package com.gioppl.scorelibrary.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.gioppl.scorelibrary.R
import com.gioppl.scorelibrary.present.ScorePresent
import com.gioppl.scorelibrary.view.ScoreView

/**
 * Created by GIOPPL on 2017/8/16.
 */

class MyScoreActivity : AppCompatActivity(),ScoreView{
    private var StudentAccount :String?=null
    private var StudentPassword :String?=null
    var mPresent:ScorePresent?=null
    var tv_score:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)
        receiveStuInfo()
        tv_score= findViewById(R.id.tv_score) as TextView?
        mPresent= ScorePresent(scoreView = this);
        mPresent!!.getScore(StudentAccount!!,StudentPassword!!)

    }

    private fun receiveStuInfo() {
        var intent=this.intent
        StudentAccount=intent.getStringExtra("account")
        StudentPassword=intent.getStringExtra("pwd")
    }

    override fun onSuccess(xml: String) {
        Log.i("Main",xml)
        tv_score!!.text=xml
    }

    override fun onError(result: String) {
        tv_score!!.text=result
    }

    companion object {
        fun toScoreActivity(activity:Activity,account:String,pwd:String):Intent{
            val myIntent=Intent(activity,MyScoreActivity::class.java)
            myIntent.putExtra("account",account)
            myIntent.putExtra("pwd",pwd)
            return myIntent
        }
    }

}
