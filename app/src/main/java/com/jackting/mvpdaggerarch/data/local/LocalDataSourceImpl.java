package com.jackting.mvpdaggerarch.data.local;

import com.jackting.core.data.config.ConfigDataEngine;
import com.jackting.mvpdaggerarch.AndroidApplication;
import com.jackting.mvpdaggerarch.bean.entity.Article;
import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.data.HttpDataSource;
import com.jackting.mvpdaggerarch.data.LocalDataSource;

import java.util.List;

public class LocalDataSourceImpl implements LocalDataSource{


    @Override
    public void saveUser(User user) {
        ConfigDataEngine.putObject(ConfigDataKeyEnum.USER_INFO.getKey(),user);
    }

    @Override
    public User getUser() {
        return ConfigDataEngine.getObject(ConfigDataKeyEnum.USER_INFO.getKey(),User.class);
    }

    public void saveArticleList(List<Article> articleList){
        //delete all
        AndroidApplication.getDaoSession().getArticleDao().deleteAll();
        //save all
        AndroidApplication.getDaoSession().getArticleDao().insertInTx(articleList);
    }

    @Override
    public List<Article> getArticleListFromLocal() {
        return AndroidApplication.getDaoSession().getArticleDao().loadAll();
    }


}
