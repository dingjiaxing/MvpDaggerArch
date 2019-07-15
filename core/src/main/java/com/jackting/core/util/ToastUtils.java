package com.jackting.core.util;

import android.app.Activity;
import android.widget.Toast;

import androidx.annotation.StringRes;

import com.jackting.core.CoreApplication;
import com.jackting.core.base.ActivityCollector;


/**
 * <p>Description:
 * <p>Company:863 software
 * <p>Email:itdjx@qq.com
 * @author:Created by Jack Ting on 2018/8/1
 */
public class ToastUtils {

    /**
     * 弹出短暂的toast
     *
     * @param msg
     */
    public static void showToast(String msg) {
        Toast.makeText(CoreApplication.getContext(), msg, Toast.LENGTH_SHORT)
                .show();
    }

    /**
     * 弹出短暂的toast
     *
     * @param stringId 要发出的信息的 stringId
     */
    public static void showToast(@StringRes final int stringId) {
        Activity activity= ActivityCollector.getTopActivity();
        if(activity!=null){
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(CoreApplication.getContext(), stringId, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    /**
     * 弹出长时间的toast
     *
     * @param msg
     */
    public static void showLongToast(String msg) {
        Toast.makeText(CoreApplication.getContext(), msg, Toast.LENGTH_LONG)
                .show();
    }

    public static void toastNetworkError() {
        showToast("网络错误，请稍后重试");
    }
}
