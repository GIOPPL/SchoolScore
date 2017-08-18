package com.gioppl.scorelibrary.model.server

import com.gioppl.scorelibrary.model.entity.ScoreEntity
import org.reactivestreams.Subscriber


/**
 * Created by GIOPPL on 2017/8/16.
 */
interface ReportServerModel {
    fun onCheck(account:String,pwd:String,subscriber: Subscriber<ArrayList<ScoreEntity>>) //成功获取成绩单
    fun onError()//获取成绩单失败
}


////创建一个上游 Observable：
//var observable = Observable.create(object : ObservableOnSubscribe<Int> {
//    override fun subscribe(emitter: ObservableEmitter<Int>) {
//        emitter.onNext(1)
//        emitter.onNext(2)
//        emitter.onNext(3)
//        emitter.onComplete()
//    }
//})



////创建一个下游 Observer
//var observer: Observer<Int> = object : Observer<Int> {
//
//    override fun onSubscribe(d: Disposable) {
//        Log.d(TAG, "subscribe")
//    }
//
//    override fun onNext(value: Int) {
//        Log.d(TAG, "" + value!!)
//    }
//
//    override fun onError(e: Throwable) {
//        Log.d(TAG, "error")
//    }
//
//    override fun onComplete() {
//        Log.d(TAG, "complete")
//    }
//}
////建立连接
//observable.subscribe(observer);