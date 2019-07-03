package com.jackting.mvpdaggerarch.base;

import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.util.ActivityUtils;

public abstract class ContainerActivity  extends BaseActivity{

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_container;
    }

    protected void initOne(BaseFragment fragment,BasePresenter presenter){
        fragment.setPresenter(presenter);

        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment,R.id.container);
    }
}
