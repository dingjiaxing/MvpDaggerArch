package com.jackting.mvpdaggerarch.ui.main;

import android.os.Bundle;

import androidx.fragment.app.FragmentTransaction;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.BaseActivity;
import com.jackting.mvpdaggerarch.ui.main.home.MainHomeFragment;
import com.jackting.mvpdaggerarch.ui.main.home.MainHomePresenter;
import com.jackting.mvpdaggerarch.ui.main.profile.MainProfileFragment;
import com.jackting.mvpdaggerarch.ui.main.profile.MainProfilePresenter;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.main_bottomBar)
    BottomNavigationBar bottomBar;

    FragmentTransaction ft;
    @Inject
    MainHomeFragment homeFragment;
    @Inject
    MainProfileFragment profileFragment;
    @Inject
    MainHomePresenter homePresenter;
    @Inject
    MainProfilePresenter profilePresenter;

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init() {
        homeFragment.setPresenter(homePresenter);
        profileFragment.setPresenter(profilePresenter);
        initFragment();

        bottomBar
                .addItem(new BottomNavigationItem(R.drawable.selector_main_home,getString(R.string.tab_home)))
                .addItem(new BottomNavigationItem(R.drawable.selector_main_user,getString(R.string.tab_profile)))
                .setFirstSelectedPosition(0)
                .initialise();

        bottomBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                selectFragment(position);
            }

            @Override
            public void onTabUnselected(int position) {
                hideFragment(position);
            }
            @Override
            public void onTabReselected(int position) {
            }
        });
    }

    void initFragment() {
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.main_container, profileFragment);
        ft.hide(profileFragment);
        ft.add(R.id.main_container, homeFragment);
        ft.commit();
        selectFragment(R.id.tab_home);
    }

    private void selectFragment(int tabId) {
        ft = getSupportFragmentManager().beginTransaction();
        hideFragment(bottomBar.getCurrentSelectedPosition());
        switch (tabId) {
            case 0:
                homeFragment.onResume();
                ft.show(homeFragment);
                break;
            case 1:
                profileFragment.onResume();
                ft.show(profileFragment);
                break;
        }
        ft.commit();
    }
    void hideFragment(int index) {
        switch (index) {
            case 0:
                if (homeFragment != null) {
                    ft.hide(homeFragment);
                }
                break;
            case 1:
                if (profileFragment != null) {
                    ft.hide(profileFragment);
                }
                break;
        }
    }

}
