package com.jackting.mvpdaggerarch;

import android.content.Context;


import androidx.multidex.MultiDex;

import com.jackting.core.CoreApplication;
import com.jackting.mvpdaggerarch.data.http.ApiService;
import com.jackting.mvpdaggerarch.di.DaggerAppComponent;
import com.lib.http.manager.HttpManager;

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
        HttpManager.setConfigProvider(this, new HttpManager.ConfigProvider() {
            @Override
            public String getUserToken() {
                return null;
            }

            @Override
            public boolean isDebug() {
                return true;
            }

            @Override
            public String getBaseUrl() {
                return ApiService.BASE_URL;
            }
        });
    }


}
