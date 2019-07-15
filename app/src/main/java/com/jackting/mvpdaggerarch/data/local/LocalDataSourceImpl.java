package com.jackting.mvpdaggerarch.data.local;

import com.jackting.core.data.config.ConfigDataEngine;
import com.jackting.mvpdaggerarch.bean.entity.User;
import com.jackting.mvpdaggerarch.data.HttpDataSource;
import com.jackting.mvpdaggerarch.data.LocalDataSource;

public class LocalDataSourceImpl implements LocalDataSource{


    @Override
    public void saveUser(User user) {
        ConfigDataEngine.putObject(ConfigDataKeyEnum.USER_INFO.getKey(),user);
    }

    @Override
    public User getUser() {
        return ConfigDataEngine.getObject(ConfigDataKeyEnum.USER_INFO.getKey(),User.class);
    }

}
