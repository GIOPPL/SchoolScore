package com.gioppl.myscore

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.gioppl.scorelibrary.view.activity.MyScoreActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
    public fun myScore(view: View){
        startActivity(Intent(this, MyScoreActivity::class.java))
    }
}
