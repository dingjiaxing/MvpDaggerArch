package com.jackting.mvpdaggerarch.data;

import com.jackting.mvpdaggerarch.bean.entity.User;

public interface LocalDataSource {

    void saveUser(User user);

    User getUser();
}
