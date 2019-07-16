package com.jackting.mvpdaggerarch.data.http;

import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.bean.vo.ArticleListVO;
import com.lib.http.result.HttpRespResult;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * 测试api文档: https://www.wanandroid.com/blog/show/2
 */
public interface ApiService {

    String BASE_URL="https://www.wanandroid.com/";

    @POST(BASE_URL+"user/login")
    @FormUrlEncoded
    Observable<HttpRespResult<User>> login(@Field("username")String username, @Field("password")String password);

    @POST(BASE_URL+"user/register")
    @FormUrlEncoded
    Observable<User> register(@Field("username")String username,@Field("password")String password,@Field("repassword")String repassword);

    @GET(BASE_URL+"article/list/{pageNo}/json")
    Observable<HttpRespResult<ArticleListVO>> getArticleList(@Path("pageNo")int pageNo);

}
