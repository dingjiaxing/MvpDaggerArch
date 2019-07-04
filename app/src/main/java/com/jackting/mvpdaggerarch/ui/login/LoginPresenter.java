package com.jackting.mvpdaggerarch.ui.login;

import android.text.TextUtils;


import com.jackting.core.util.ToastUtils;
import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.AbsPresenter;
import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.lib.http.result.HttpRespException;
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
        if(!checkLogin(username,pwd)){
            return;
        }
        model.login(username,pwd)
                .compose(SchedulerTransformer.<User>transformer())
                .compose(new DialogTransformer(mActivity).<User>transformer())
                .subscribe(new CommonObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        view.loginSuccess();
                    }
                    @Override
                    public void onFailed(HttpRespException responseException) {
                        super.onFailed(responseException);
                        ToastUtils.toastNetworkError();
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

        ToastUtils.showToast(""+(view==null));
    }

    /**
     * 检查用户输入信息是否合法
     * @return
     */
    private boolean checkLogin(String username,String password) {
        if (TextUtils.isEmpty(username)) {
            ToastUtils.showToast(R.string.username_cannot_be_empty);
            return false;
        }
        if (TextUtils.isEmpty(password)) {
            ToastUtils.showToast(R.string.password_cannot_be_empty);
            return false;
        }
        return true;
    }
}
