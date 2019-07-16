package com.jackting.mvpdaggerarch.ui.web;

import com.jackting.mvpdaggerarch.base.BasePresenter;
import com.jackting.mvpdaggerarch.base.BaseView;
import com.jackting.mvpdaggerarch.ui.login.LoginContract;

public interface WebContract {
    interface View extends BaseView<Presenter> {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
