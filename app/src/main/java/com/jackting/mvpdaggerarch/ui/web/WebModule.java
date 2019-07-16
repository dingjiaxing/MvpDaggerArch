package com.jackting.mvpdaggerarch.ui.web;

import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.jackting.mvpdaggerarch.di.FragmentScoped;
import com.jackting.mvpdaggerarch.ui.login.LoginContract;
import com.jackting.mvpdaggerarch.ui.login.LoginFragment;
import com.jackting.mvpdaggerarch.ui.login.LoginPresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class WebModule {


    @FragmentScoped
    @ContributesAndroidInjector
    abstract WebFragment webFragment();


    @ActivityScoped
    @Binds
    abstract WebContract.Presenter webPresenter(WebPresenter presenter);



}
