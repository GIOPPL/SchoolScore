package com.gioppl.scorelibrary.view

import com.gioppl.scorelibrary.model.entity.ScoreEntity

/**
 * Created by GIOPPL on 2017/8/16.
 */
interface ScoreView {
        fun onSuccess(xml: ArrayList<ScoreEntity>)
        fun onError(result:String)
}