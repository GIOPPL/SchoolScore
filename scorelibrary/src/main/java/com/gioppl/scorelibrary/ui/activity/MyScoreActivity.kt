package com.gioppl.scorelibrary.ui.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.gioppl.scorelibrary.R
import com.gioppl.scorelibrary.present.ScorePresent
import com.gioppl.scorelibrary.view.ScoreView

/**
 * Created by GIOPPL on 2017/8/16.
 */

class MyScoreActivity : AppCompatActivity() {
    var tv_score:TextView?=null
    val mPresent= ScorePresent()
    val scoreView=object :ScoreView{
        override fun onSuccess(xml: String) {

        }

        override fun onError(result: String) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)
        tv_score= findViewById(R.id.tv_score) as TextView?
        mPresent.onCreate()
        mPresent.attachView(scoreView)
        mPresent.getScore()
    }
}
