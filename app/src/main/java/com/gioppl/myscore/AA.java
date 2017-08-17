package com.gioppl.myscore;

/**
 * Created by GIOPPL on 2017/8/17.
 */

public class AA {
    static int o=1;
    AA(){

    }
    AA(int i){
        this.o=i;
    }

    static XX xx=new XX(){

        @Override
        public void a() {
            o=100;
        }
    };

    interface XX{
        void a();
    }
}
