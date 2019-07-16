package com.jackting.mvpdaggerarch.data;

import com.jackting.mvpdaggerarch.bean.entity.Article;
import com.jackting.mvpdaggerarch.bean.entity.User;

import java.util.List;

public interface LocalDataSource {

    void saveUser(User user);

    User getUser();

    void saveArticleList(List<Article> articleList);

    List<Article> getArticleListFromLocal();
}
