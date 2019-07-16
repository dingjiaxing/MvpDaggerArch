package com.jackting.core;

import android.app.Application;
import android.content.Context;

import com.jackting.core.data.config.ConfigDataEngine;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.mmkv.MMKV;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public abstract class CoreApplication extends DaggerApplication {
    private static CoreApplication app = null;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return applicationInnerInjector();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        init();
    }

    private void init() {
        //初始化配置数据引擎
        ConfigDataEngine.init(this);
        //初始化日志
        Logger.addLogAdapter(new AndroidLogAdapter());

        //允许输出日志信息
//        LogUtil.enableDebug();

    }

    public static Context getContext() {
        return app.getApplicationContext();
    }

    protected abstract AndroidInjector<? extends DaggerApplication> applicationInnerInjector();
}
