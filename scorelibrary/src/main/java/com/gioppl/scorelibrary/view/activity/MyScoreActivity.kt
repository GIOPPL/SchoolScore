package com.gioppl.scorelibrary.view.activity

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
    var mPresent:ScorePresent?=null
    var tv_score:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)
        tv_score= findViewById(R.id.tv_score) as TextView?
        mPresent= ScorePresent(scoreView = this);
        mPresent!!.getScore("账户","密码")
    }

    override fun onSuccess(xml: String) {
        Log.i("Main",xml)
        tv_score!!.text=xml
    }

    override fun onError(result: String) {
        tv_score!!.text=result
    }
}
