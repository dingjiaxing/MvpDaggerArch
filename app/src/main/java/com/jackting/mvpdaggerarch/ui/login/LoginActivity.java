package com.jackting.mvpdaggerarch.ui.login;



import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.BaseActivity;
import com.jackting.mvpdaggerarch.base.ContainerActivity;
import com.jackting.mvpdaggerarch.util.ActivityUtils;

import javax.inject.Inject;

public class LoginActivity extends ContainerActivity {

    @Inject
    LoginFragment loginFragment;
    @Inject
    LoginContract.Presenter loginPresenter;


    @Override
    protected void init() {
        initOne(loginFragment,loginPresenter);
    }

}
