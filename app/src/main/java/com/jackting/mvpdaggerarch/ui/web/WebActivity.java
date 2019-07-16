package com.jackting.mvpdaggerarch.ui.web;

import com.jackting.mvpdaggerarch.base.BaseActivity;
import com.jackting.mvpdaggerarch.base.ContainerActivity;

import javax.inject.Inject;

public class WebActivity extends ContainerActivity {

    @Inject
    WebFragment webFragment;
    @Inject
    WebContract.Presenter webPresenter;

    public static String URL_KEY="url_key";

    @Override
    protected void init() {
        initOne(webFragment,webPresenter);
    }
}
