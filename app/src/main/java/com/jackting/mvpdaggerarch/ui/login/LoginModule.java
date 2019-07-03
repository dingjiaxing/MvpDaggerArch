package com.jackting.mvpdaggerarch.ui.login;



import com.jackting.mvpdaggerarch.di.ActivityScoped;
import com.jackting.mvpdaggerarch.di.FragmentScoped;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class LoginModule {


    @FragmentScoped
    @ContributesAndroidInjector
    abstract LoginFragment loginFragment();


    @ActivityScoped
    @Binds
    abstract LoginContract.Presenter loginPresenter(LoginPresenter presenter);



}
