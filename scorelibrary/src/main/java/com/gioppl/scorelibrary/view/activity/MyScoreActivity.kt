package com.gioppl.scorelibrary.view.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.gioppl.scorelibrary.R
import com.gioppl.scorelibrary.model.entity.ScoreEntity
import com.gioppl.scorelibrary.present.ScorePresent
import com.gioppl.scorelibrary.view.ScoreView
import com.gioppl.scorelibrary.view.adapt.ScoreAdapt

/**
 * Created by GIOPPL on 2017/8/16.
 */

class MyScoreActivity : AppCompatActivity(),ScoreView{
    private var StudentAccount :String?=null
    private var StudentPassword :String?=null

    var mPresent:ScorePresent?=null
    var rv_score:RecyclerView?=null
    var mAdapt:ScoreAdapt?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.score)
        receiveStuInfo()
        initView()
        mPresent= ScorePresent(scoreView = this);
        mPresent!!.getScore(StudentAccount!!,StudentPassword!!)

    }

    private var mList= ArrayList<ScoreEntity>()

    private fun initView() {
        rv_score= findViewById(R.id.rv_score) as RecyclerView?
        mAdapt= ScoreAdapt(mList)
        var manager=LinearLayoutManager(this)
        rv_score!!.layoutManager=manager
        rv_score!!.adapter=mAdapt
        rv_score!!.setHasFixedSize(true)
    }

    private fun receiveStuInfo() {
        var intent=this.intent
        StudentAccount=intent.getStringExtra("account")
        StudentPassword=intent.getStringExtra("pwd")
    }

    override fun onSuccess(xList: ArrayList<ScoreEntity>) {
        mList.clear()
        for (entity in xList)
            mList.add(entity)
        mAdapt!!.notifyItemInserted(0)
    }

    override fun onError(result: String) {

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
