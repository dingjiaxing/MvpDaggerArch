package com.jackting.mvpdaggerarch.data;

import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.bean.vo.ArticleListVO;
import com.lib.http.result.HttpRespResult;

import io.reactivex.Observable;
import retrofit2.http.Path;

public interface HttpDataSource {

    Observable<HttpRespResult<User>> login(String username, String pwd);

    Observable<HttpRespResult<ArticleListVO>> getArticleList(int pageNo);
}
