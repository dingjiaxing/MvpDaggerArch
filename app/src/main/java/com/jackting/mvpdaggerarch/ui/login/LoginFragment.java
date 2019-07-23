package com.jackting.mvpdaggerarch.ui.login;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


import com.jackting.mvpdaggerarch.R;
import com.jackting.core.base.BaseView;
import com.jackting.mvpdaggerarch.ui.main.MainActivity;
import com.jackting.mvpdaggerarch.base.BaseFragment;
import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.jakewharton.rxbinding2.view.RxView;
import com.jakewharton.rxbinding2.widget.RxTextView;


import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

@ActivityScoped
public class LoginFragment extends BaseFragment<LoginContract.Presenter> implements LoginContract.View{

    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.cb_remember)
    CheckBox cbRememberPassword;
    @BindView(R.id.bt_login)
    Button btnLogin;

    @Inject
    public LoginFragment() {
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_login;
    }

//    @OnClick({R.id.bt_login})
//    public void doClick(View view){
//        switch (view.getId()){
//            case R.id.bt_login:
//                presenter.login(etUsername.getText().toString(), etPassword.getText().toString());
//                break;
//        }
//    }

    @Override
    protected void init() {
        Observable<CharSequence> observableName = RxTextView.textChanges(etUsername);
        Observable<CharSequence> observablePwd = RxTextView.textChanges(etPassword);

        //name和pwd都满足要求时才允许点击
        Observable.combineLatest(observableName,observablePwd
            ,(name,pwd) -> isValid(name.toString(),pwd.toString()))
                .subscribe(btnLogin::setEnabled);

        //防抖，防止连续点击
        RxView.clicks(btnLogin)
                .throttleFirst(1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe( v -> {
                    String username = etUsername.getText().toString();
                    String pwd= etPassword.getText().toString();
                    presenter.login(username,pwd);
                        });
    }

    boolean isValid(String name,String pwd){
        if(name.length()>3 && pwd.length()>0){
            return true;
        }
        return false;
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
