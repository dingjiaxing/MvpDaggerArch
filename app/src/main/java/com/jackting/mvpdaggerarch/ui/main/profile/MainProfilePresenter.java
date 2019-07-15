package com.jackting.mvpdaggerarch.ui.main.profile;

import com.jackting.mvpdaggerarch.base.AbsPresenter;
import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.jackting.mvpdaggerarch.ui.main.home.MainHomeContract;

import javax.inject.Inject;

@ActivityScoped
public class MainProfilePresenter extends AbsPresenter<MainProfileContract.View> implements MainProfileContract.Presenter {

    @Inject
    public MainProfilePresenter() {
    }

    @Override
    public void init() {

    }
}
