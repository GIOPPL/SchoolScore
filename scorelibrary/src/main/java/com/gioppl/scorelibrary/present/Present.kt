package com.gioppl.scorelibrary.present

import com.gioppl.scorelibrary.view.ScoreView

/**
 * Created by GIOPPL on 2017/8/16.
 */
interface Present {
    fun onCreate()
    fun onStop()
    fun attachView(view: ScoreView)
}