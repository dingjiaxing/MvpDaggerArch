package com.jackting.mvpdaggerarch.ui.main.home;

import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.BaseFragment;
import com.jackting.mvpdaggerarch.base.BaseView;
import com.jackting.mvpdaggerarch.di.ActivityScoped;

import javax.inject.Inject;

@ActivityScoped
public class MainHomeFragment extends BaseFragment<MainHomeContract.Presenter> implements MainHomeContract.View {

    @Inject
    public MainHomeFragment() {
    }

    @Override
    protected BaseView getBaseView() {
        return this;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main_home;
    }

    @Override
    protected void init() {

    }
}
