package com.jackting.mvpdaggerarch.data;

import com.jackting.mvpdaggerarch.bean.entity.User;
import com.lib.http.result.HttpRespResult;

import io.reactivex.Observable;

public interface HttpDataSource {

    Observable<HttpRespResult<User>> login(String username, String pwd);


}
