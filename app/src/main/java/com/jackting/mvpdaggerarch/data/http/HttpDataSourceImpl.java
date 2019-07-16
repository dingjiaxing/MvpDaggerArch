package com.jackting.mvpdaggerarch.data.http;

import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.bean.vo.ArticleListVO;
import com.jackting.mvpdaggerarch.data.HttpDataSource;
import com.lib.http.result.HttpRespResult;
import com.lib.http.retrofit.RetrofitHelper;

import io.reactivex.Observable;

public class HttpDataSourceImpl implements HttpDataSource{
    private ApiService apiService;

    public HttpDataSourceImpl() {
        apiService = RetrofitHelper.getRetrofit().create(ApiService.class);
    }

    public Observable<HttpRespResult<User>> login(String username, String pwd){
        return apiService.login(username,pwd);
    }

    @Override
    public Observable<HttpRespResult<ArticleListVO>> getArticleList(int pageNo) {
        return apiService.getArticleList(pageNo);
    }
}
