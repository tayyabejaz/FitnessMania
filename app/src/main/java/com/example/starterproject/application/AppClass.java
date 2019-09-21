package com.example.starterproject.application;

import android.app.Application;
import android.content.Context;

public class AppClass extends Application {

    public static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    public static Context getContext(){
        return mContext;
    }


}
