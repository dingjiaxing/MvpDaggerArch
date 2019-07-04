package com.jackting.mvpdaggerarch.data;

import com.jackting.mvpdaggerarch.bean.entity.User;

import io.reactivex.Observable;

public interface HttpDataSource {

    Observable<User> login(String username, String pwd);


}
