package com.jackting.mvpdaggerarch.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.BaseView;
import com.jackting.mvpdaggerarch.ui.main.MainActivity;
import com.jackting.mvpdaggerarch.base.BaseFragment;
import com.jackting.mvpdaggerarch.di.ActivityScoped;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;

@ActivityScoped
public class LoginFragment extends BaseFragment<LoginContract.Presenter> implements LoginContract.View{

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.cb_remember)
    CheckBox cbRememberPassword;

    @Inject
    public LoginFragment() {
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_login;
    }

    @OnClick({R.id.bt_login})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.bt_login:
                presenter.login(etUsername.getText().toString(), etPassword.getText().toString());
                break;
        }
    }

    @Override
    protected void init() {

    }


    @Override
    protected BaseView getBaseView() {
        return this;
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(mActivity, MainActivity.class);
        mActivity.startActivity(intent);
        mActivity.finish();
    }
}
