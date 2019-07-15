package com.jackting.mvpdaggerarch.ui.main.profile;

import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.BaseFragment;
import com.jackting.mvpdaggerarch.base.BaseView;
import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.jackting.mvpdaggerarch.ui.main.home.MainHomeContract;

import javax.inject.Inject;

@ActivityScoped
public class MainProfileFragment extends BaseFragment<MainProfileContract.Presenter> implements MainProfileContract.View {

    @Inject
    public MainProfileFragment() {
    }

    @Override
    protected BaseView getBaseView() {
        return this;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main_profile;
    }

    @Override
    protected void init() {

    }
}
