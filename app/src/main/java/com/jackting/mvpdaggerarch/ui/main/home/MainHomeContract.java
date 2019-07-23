package com.jackting.mvpdaggerarch.ui.main.home;

import com.jackting.core.base.BasePresenter;
import com.jackting.core.base.BaseView;
import com.jackting.mvpdaggerarch.bean.entity.Article;

import java.util.List;

public interface MainHomeContract {

    interface View extends BaseView<Presenter> {
        void showArticleList(List<Article> articleList);
    }

    interface Presenter extends BasePresenter<View> {

    }

}
