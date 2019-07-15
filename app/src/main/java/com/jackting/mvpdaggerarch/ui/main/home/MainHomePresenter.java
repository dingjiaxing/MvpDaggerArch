package com.jackting.mvpdaggerarch.ui.main.home;

import com.jackting.mvpdaggerarch.base.AbsPresenter;
import com.jackting.mvpdaggerarch.di.ActivityScoped;

import javax.inject.Inject;

@ActivityScoped
public class MainHomePresenter  extends AbsPresenter<MainHomeContract.View> implements MainHomeContract.Presenter {

    @Inject
    public MainHomePresenter() {
    }

    @Override
    public void init() {

    }
}
