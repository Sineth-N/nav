package com.d2s2.sinethn.nav;

import android.app.Application;
import android.content.Context;

/**
 * Created by Sineth N on 8/15/2015.
 */
public class MyApplication extends Application {

    public final static  String API_KEY="54wzfswsa4qmjg8hjwa64d4c";
    private static MyApplication myApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication=this;
    }
    public MyApplication getInstance(){
        return myApplication;
    }
    public static Context getAppContext(){
         return myApplication.getApplicationContext();
    }
}
