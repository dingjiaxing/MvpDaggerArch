package com.jackting.mvpdaggerarch.data;

import com.jackting.core.base.BaseModel;
import com.jackting.mvpdaggerarch.bean.entity.Article;
import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.bean.vo.ArticleListVO;
import com.jackting.mvpdaggerarch.data.http.HttpDataSourceImpl;
import com.jackting.mvpdaggerarch.data.local.LocalDataSourceImpl;
import com.lib.http.result.HttpRespResult;

import java.util.List;

import io.reactivex.Observable;

public class DataRepository extends BaseModel implements HttpDataSource,LocalDataSource{
    private volatile static DataRepository INSTANCE=null;

    private final HttpDataSource httpDataSource;
    private final LocalDataSource localDataSource;

    private DataRepository(HttpDataSource httpDataSource, LocalDataSource localDataSource) {
        this.httpDataSource = httpDataSource;
        this.localDataSource = localDataSource;
    }

    public static DataRepository getInstance() {
        if (INSTANCE == null) {
            synchronized (DataRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DataRepository(new HttpDataSourceImpl(), new LocalDataSourceImpl());
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public Observable<HttpRespResult<User>> login(String username, String pwd) {
        return httpDataSource.login(username,pwd);
    }

    @Override
    public Observable<HttpRespResult<ArticleListVO>> getArticleList(int pageNo) {
        return httpDataSource.getArticleList(pageNo);
    }

    @Override
    public void saveUser(User user) {
        localDataSource.saveUser(user);
    }

    @Override
    public User getUser() {
        return localDataSource.getUser();
    }

    @Override
    public void saveArticleList(List<Article> articleList) {
        localDataSource.saveArticleList(articleList);
    }

    @Override
    public List<Article> getArticleListFromLocal() {
        return localDataSource.getArticleListFromLocal();
    }
}
