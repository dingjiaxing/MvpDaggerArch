package com.jackting.mvpdaggerarch;

import android.content.Context;
import android.support.multidex.MultiDex;

import com.jackting.core.CoreApplication;
import com.jackting.mvpdaggerarch.di.DaggerAppComponent;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class AndroidApplication extends CoreApplication{

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInnerInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }


}
