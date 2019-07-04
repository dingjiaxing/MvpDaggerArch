package com.jackting.mvpdaggerarch.data.http;

import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.data.HttpDataSource;
import com.lib.http.retrofit.RetrofitHelper;

import io.reactivex.Observable;

public class HttpDataSourceImpl implements HttpDataSource{
    private ApiService apiService;

    public HttpDataSourceImpl() {
        apiService = RetrofitHelper.getRetrofit().create(ApiService.class);
    }

    Observable<User> login(String username,String pwd){
        return apiService.login(username,pwd);
    }
}
