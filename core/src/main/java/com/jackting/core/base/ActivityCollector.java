package com.jackting.core.base;



import java.util.ArrayList;
import java.util.List;

/**
 * <p>Description:所有activity的管理类
 * <p>Company:863 software
 * <p>Email:itdjx@qq.com
 * @author:Created by Jack Ting on 2018/8/1
 */
public class ActivityCollector {
    /**
     * 存储activity的列表
     */
    private static List<CoreBaseActivity> activityList = new ArrayList<>();

    /**
     * 添加某个activity
     *
     * @param activity
     */
    public static void addActivity(CoreBaseActivity activity) {
        activityList.add(activity);
    }

    /**
     * 移除某个activity
     *
     * @param activity
     */
    public static void removeActivity(CoreBaseActivity activity) {
        activityList.remove(activity);
    }

    /**
     * 获取栈顶的activity
     *
     * @return
     */
    public static CoreBaseActivity getTopActivity() {
        if (activityList.isEmpty()) {
            return null;
        } else {
            return activityList.get(activityList.size() - 1);
        }
    }
}
