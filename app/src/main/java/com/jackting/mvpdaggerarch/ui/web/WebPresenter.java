package com.jackting.mvpdaggerarch.ui.web;

import com.jackting.mvpdaggerarch.base.AbsPresenter;
import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.jackting.mvpdaggerarch.ui.login.LoginContract;
import com.jackting.mvpdaggerarch.ui.login.LoginFragment;

import javax.inject.Inject;

@ActivityScoped
public class WebPresenter extends AbsPresenter<WebContract.View> implements WebContract.Presenter {

    @Inject
    public WebPresenter() {
    }

    @Override
    public void init() {

    }
}
