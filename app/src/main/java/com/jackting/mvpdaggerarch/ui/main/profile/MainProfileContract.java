package com.jackting.mvpdaggerarch.ui.main.profile;

import com.jackting.mvpdaggerarch.base.BasePresenter;
import com.jackting.mvpdaggerarch.base.BaseView;

public interface MainProfileContract {

    interface View extends BaseView<Presenter> {

    }

    interface Presenter extends BasePresenter<View> {

    }

}
