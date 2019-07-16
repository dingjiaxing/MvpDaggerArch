package com.jackting.mvpdaggerarch.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.util.ActivityUtils;

import java.util.Set;

public abstract class ContainerActivity  extends BaseActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_container;
    }

    protected void initOne(BaseFragment fragment,BasePresenter presenter){
        Bundle extras=getIntent().getExtras();
//        Set keySet=extras.keySet();
        fragment.setArguments(extras);

        fragment.setPresenter(presenter);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment,R.id.container);
    }
}
