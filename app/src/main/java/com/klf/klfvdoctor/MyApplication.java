package com.klf.klfvdoctor;

import android.app.Application;
import android.content.Context;

import androidx.multidex.MultiDex;

import com.klf.videodoctor.KlfVDoctor;
import com.klf.videodoctor.config.KlfSDKOptions;

/**
 * Created by Cy on 2019/11/19.
 * File description：
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KlfSDKOptions options = new KlfSDKOptions("10071"); //productId是视频医生提供方分配的产品Id
        options.isDebug = true;
        options.dev = true;
        KlfVDoctor.init(getApplicationContext(), options);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
