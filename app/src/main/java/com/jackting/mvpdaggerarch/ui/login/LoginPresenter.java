package com.jackting.mvpdaggerarch.ui.login;

import android.text.TextUtils;


import com.jackting.core.util.ToastUtils;
import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.AbsPresenter;
import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.lib.http.result.HttpRespException;
import com.lib.http.result.HttpRespResult;
import com.lib.http.rxjava.observable.DialogTransformer;
import com.lib.http.rxjava.observable.SchedulerTransformer;
import com.lib.http.rxjava.observer.CommonObserver;

import javax.inject.Inject;

import io.reactivex.functions.Consumer;

@ActivityScoped
public class LoginPresenter extends AbsPresenter<LoginContract.View> implements LoginContract.Presenter{
    @Inject
    public LoginPresenter() {
    }

    @Override
    public void login(final String username, final String pwd) {
        model.login(username,pwd)
                .compose(SchedulerTransformer.transformer())
                .compose(new DialogTransformer(mActivity).transformer())
                .subscribe(new CommonObserver<HttpRespResult<User>>() {
                    @Override
                    public void onSuccess(HttpRespResult<User> userHttpRespResult) {
                        if(userHttpRespResult.isSuccess()){
                            model.saveUser(userHttpRespResult.getData());
                            view.loginSuccess();
                        }else {
                            ToastUtils.showToast(userHttpRespResult.getMessage());
                        }
                    }
                });
    }

    @Override
    public void saveUsernameRemeCheckStatus(boolean checked,String username) {
        //记录是否勾选自动登录
//        Prefs.putBoolean(SpEnum.REMEMBER_FLAG.getType(), checked);
    }

    /**
     * 初始化逻辑
     */
    public void init(){
        //从sp中获取数据
//        String username=Prefs.getString(SpEnum.USER_NAME.getType(), "");
//        String pwd=Prefs.getString(SpEnum.USER_PWD.getType(), "");
//        boolean rememberPassword = Prefs.getBoolean(SpEnum.REMEMBER_FLAG.getType(), false);

        //调用view层进行初始化页面
//        view.initPage(versionName,username,pwd,rememberPassword);

    }

}
