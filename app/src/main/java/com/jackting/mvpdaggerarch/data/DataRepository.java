package com.jackting.mvpdaggerarch.data;

import com.jackting.core.base.BaseModel;
import com.jackting.mvpdaggerarch.data.http.HttpDataSourceImpl;
import com.jackting.mvpdaggerarch.data.local.LocalDataSourceImpl;

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
}
