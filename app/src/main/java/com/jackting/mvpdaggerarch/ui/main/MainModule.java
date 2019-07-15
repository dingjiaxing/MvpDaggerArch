package com.jackting.mvpdaggerarch.ui.main;

import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.jackting.mvpdaggerarch.di.FragmentScoped;
import com.jackting.mvpdaggerarch.ui.main.home.MainHomeContract;
import com.jackting.mvpdaggerarch.ui.main.home.MainHomeFragment;
import com.jackting.mvpdaggerarch.ui.main.home.MainHomePresenter;
import com.jackting.mvpdaggerarch.ui.main.profile.MainProfileContract;
import com.jackting.mvpdaggerarch.ui.main.profile.MainProfileFragment;
import com.jackting.mvpdaggerarch.ui.main.profile.MainProfilePresenter;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainModule {

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainHomeFragment mainHomeFragment();

    @ActivityScoped
    @Binds
    abstract MainHomeContract.Presenter mainHomePresenter(MainHomePresenter presenter);

    @FragmentScoped
    @ContributesAndroidInjector
    abstract MainProfileFragment mainProfileFragment();

    @ActivityScoped
    @Binds
    abstract MainProfileContract.Presenter mainProfilePresenter(MainProfilePresenter presenter);
}
