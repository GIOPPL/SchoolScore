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

    public fun myScore(view: View) {
        var intent=Intent(this, MyScoreActivity::class.java)
//        intent.putExtra("account","02210150204")
//        intent.putExtra("pwd","ESUPMT")
//        startActivity(intent)
        startActivity(MyScoreActivity.toScoreActivity(this,"账户","密码"))
    }
}
