package com.jackting.mvpdaggerarch.ui.main.home;

import com.jackting.mvpdaggerarch.base.BasePresenter;
import com.jackting.mvpdaggerarch.base.BaseView;

import java.util.List;

public interface MainHomeContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }

}
