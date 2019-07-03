package com.jackting.core.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;


import com.jackting.core.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerAppCompatActivity;


public abstract class CoreBaseActivity extends DaggerAppCompatActivity {
	protected static final String TAG = "CoreBaseActivity";
	private PopupWindow progressWindow;
	private Unbinder mUnbinder;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ActivityCollector.addActivity(this);
		setContentView(getContentViewResId());
		mUnbinder = ButterKnife.bind(this);
		initCreate();
	}

	protected  void initCreate() {
		findById();
		setListener();
		init();
	}
	/**
	 * 获取Activity的布局id
	 *
	 * @return
	 */
	protected abstract int getContentViewResId();
	protected  void findById(){}
	protected  void setListener(){}
	protected abstract void init();

	@Override
	protected void onDestroy() {
		super.onDestroy();
		ActivityCollector.removeActivity(this);
		if(mUnbinder != Unbinder.EMPTY){
			mUnbinder.unbind();
		}
		this.mUnbinder = null;
	}

	public void hideProgress(){
//		if(progressWindow!=null){
//			if(progressWindow.isShowing()){
//				progressWindow.dismiss();
//			}
//		}
	}
	public void showProgress(){
//		View view = LayoutInflater.from(this).inflate(R.layout.core_dialog_progress,null);
//		progressWindow = new PopupWindow(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//		progressWindow.setContentView(view);
//		progressWindow.setFocusable(false);
//		progressWindow.showAtLocation(findViewById(android.R.id.content).getRootView(), Gravity.CENTER,0,0);
	}
	/**
	 * 隐藏虚拟按键
	 */
	protected void hideBottomUIMenu() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

		//隐藏虚拟按键，并且全屏
		if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
			View v = this.getWindow().getDecorView();
			v.setSystemUiVisibility(View.GONE);
		} else if (Build.VERSION.SDK_INT >= 19) {
			//for new api versions.
			View decorView = getWindow().getDecorView();
			int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
					| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_FULLSCREEN;
			decorView.setSystemUiVisibility(uiOptions);
		}
	}


}
