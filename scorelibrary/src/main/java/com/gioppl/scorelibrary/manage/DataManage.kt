package com.gioppl.scorelibrary.manage

import com.gioppl.scorelibrary.server.DownScore

/**
 * Created by GIOPPL on 2017/8/16.
 */
class DataManage {
    private var mDownScore:DownScore?=null
    fun getServer()=DownScore().observable
}