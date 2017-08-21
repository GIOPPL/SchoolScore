package com.gioppl.scorelibrary.present

import android.util.Log
import com.gioppl.scorelibrary.model.entity.ScoreEntity
import com.gioppl.scorelibrary.model.server.DownScoreMolder
import com.gioppl.scorelibrary.view.ScoreView
import org.reactivestreams.Subscriber
import org.reactivestreams.Subscription



/**
 * Created by GIOPPL on 2017/8/16.
 */
class ScorePresent{
    var scoreView:ScoreView?=null


    constructor(scoreView:ScoreView){
            mModel= DownScoreMolder()
            this.scoreView=scoreView;
    }

    private var mModel:DownScoreMolder?=null  //model


    fun getScore(account:String,pwd:String){
        mModel!!.onCheck(account,pwd,subscriber)
    }

    //创建订阅者
    var subscriber: Subscriber<ArrayList<ScoreEntity>> = object : Subscriber<ArrayList<ScoreEntity>> {
        override fun onSubscribe(s: Subscription) {
            //这一步是必须，我们通常可以在这里做一些初始化操作，调用request()方法表示初始化工作已经完成
            //调用request()方法，会立即触发onNext()方法
            //在onComplete()方法完成，才会再执行request()后边的代码
            s.request(java.lang.Long.MAX_VALUE)
        }

        override fun onNext(mList: ArrayList<ScoreEntity>) {
            if (mList==null||mList.size==0) return;
            if (mList.size==1){
                onError(Throwable(mList[0]!!.errorReason))
            }else{
                scoreView!!.onSuccess(mList)
            }
        }

        override fun onError(t: Throwable) {
            Log.e("onError", t.message)
            scoreView!!.onError(t.toString())
        }

        override fun onComplete() {
            //由于Reactive-Streams的兼容性，方法onCompleted被重命名为onComplete
            Log.e("onComplete", "complete")
        }
    }
    fun log(text: String = "没有东西") = Log.i("**", text)

}

