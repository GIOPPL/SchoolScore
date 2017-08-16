package com.gioppl.scorelibrary.present

import android.util.Log
import com.gioppl.scorelibrary.manage.DataManage
import com.gioppl.scorelibrary.view.ScoreView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by GIOPPL on 2017/8/16.
 */
class ScorePresent :Present{
    private var dataManage:DataManage?=null
    private var mObserver: Observer<String>? = null
    private var mScoreView:ScoreView?=null
    override fun onCreate() {
        dataManage= DataManage()

    }

    override fun onStop() {

    }

    private val  TAG="observer"

    override fun attachView(view:ScoreView) {
        mScoreView=view
    }

    fun getScore(){
        mObserver = object : Observer<String>{
            override fun onNext(t: String) {

            }

            override fun onSubscribe(d: Disposable) {
                Log.d(TAG, "subscribe")
            }

            override fun onError(e: Throwable) {
                Log.d(TAG, "error")
            }

            override fun onComplete() {
                Log.d(TAG, "complete")
            }
        }
    }

}