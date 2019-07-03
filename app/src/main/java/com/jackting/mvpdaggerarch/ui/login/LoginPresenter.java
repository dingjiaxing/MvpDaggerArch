package com.jackting.mvpdaggerarch.ui.login;

import android.text.TextUtils;


import com.jackting.core.util.ToastUtils;
import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.AbsPresenter;
import com.jackting.mvpdaggerarch.di.ActivityScoped;

import javax.inject.Inject;

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
//        ApiClient.getInstance().login(username, pwd, "111", new ResponseSubscriber<LoginResponse>() {
//            @Override
//            protected void onRealSuccess(LoginResponse loginResponse) {
//                String authorization = loginResponse.getData().getAuthorization();
//                //解析数据，获取token和登录用户信息
////                authorization = "XIB3mYRoZeUt8XKIFjym+mj3LEctMwEy2QoSoKxtVlMmSqpEE6w0nbP3I699BGRdsMaDyTQPpwegrQ1uRlgt+EFjvq1u5ssg5IbTR18sxWFGZsI3eooZ+GZf71TpW9I/YS6lGqI90RPvFVBoBzOpoZHpinD062hCd+A/b/iONQg=";
//                IomsRSAUtils.decodeAuthorization(authorization);
//                //缓存必要的数据
//                Prefs.putString(SpEnum.USER_NAME.getType(), username);
//                Prefs.putString(SpEnum.USER_PWD.getType(), pwd);
//                Prefs.putString(SpEnum.USER_LOGIN_TIME.getType(), DateTimeUtil.DateText());
//
//                view.gotoMainActivity();
//            }
//            @Override
//            protected void onOtherError(LoginResponse loginResponse) {
//
//            }
//        });
    }

    @Override
    public void saveRememChecked(boolean checked) {
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
