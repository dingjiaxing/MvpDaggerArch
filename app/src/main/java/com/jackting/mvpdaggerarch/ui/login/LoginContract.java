package com.jackting.mvpdaggerarch.ui.login;


import com.jackting.core.base.BasePresenter;
import com.jackting.core.base.BaseView;

public abstract class LoginContract {
    interface View extends BaseView<Presenter> {
        /**
         * 进入首页
         */
        void loginSuccess();
    }

    interface Presenter extends BasePresenter<View> {
        /**
         *
         * @param username
         * @param pwd
         */
        void login(String username, String pwd);

        void saveUsernameRemeCheckStatus(boolean checked,String username);
    }
}
