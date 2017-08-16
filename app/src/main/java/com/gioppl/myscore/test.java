package com.gioppl.myscore;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.gioppl.scorelibrary.server.DownScore;

/**
 * Created by GIOPPL on 2017/8/16.
 */

public class test extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);




    }

    public void testClick(View view) {
        new DownScore().getScore();
    }
}
