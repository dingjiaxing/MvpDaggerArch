package com.jackting.mvpdaggerarch.ui.main.home;

import com.jackting.mvpdaggerarch.base.AbsPresenter;
import com.jackting.mvpdaggerarch.bean.entity.Article;
import com.jackting.mvpdaggerarch.bean.vo.ArticleListVO;
import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.lib.http.result.HttpRespResult;
import com.lib.http.rxjava.observable.DialogTransformer;
import com.lib.http.rxjava.observable.SchedulerTransformer;
import com.lib.http.rxjava.observer.CommonObserver;

import java.util.List;

import javax.inject.Inject;

@ActivityScoped
public class MainHomePresenter  extends AbsPresenter<MainHomeContract.View> implements MainHomeContract.Presenter {

    @Inject
    public MainHomePresenter() {
    }

    @Override
    public void init() {
        getArticleList();
    }
    void getArticleList(){
        List<Article> articleList=model.getArticleListFromLocal();
        if(articleList==null || articleList.size()==0){
            view.showArticleList(articleList);
        }else {
            model.getArticleList(0)
                    .compose(SchedulerTransformer.transformer())
                    .compose(new DialogTransformer(mActivity).transformer())
                    .subscribe(new CommonObserver<HttpRespResult<ArticleListVO>>() {
                        @Override
                        public void onSuccess(HttpRespResult<ArticleListVO> articleListVOHttpRespResult) {
                            model.saveArticleList(articleListVOHttpRespResult.getData().datas);
                            view.showArticleList(articleListVOHttpRespResult.getData().datas);
                        }
                    });
        }
    }
}
