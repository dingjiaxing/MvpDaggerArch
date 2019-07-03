package com.jackting.mvpdaggerarch.ui.login;


import com.jackting.mvpdaggerarch.base.BasePresenter;
import com.jackting.mvpdaggerarch.base.BaseView;

public abstract class LoginContract {
    interface View extends BaseView<Presenter> {
        void initPage(String versionName, String username, String pwd, boolean rememberPassword);
        /**
         * 进入首页
         */
        void gotoMainActivity();
    }

    interface Presenter extends BasePresenter<View> {
        /**
         *
         * @param username
         * @param pwd
         */
        void login(String username, String pwd);

        void saveRememChecked(boolean checked);
    }
}
