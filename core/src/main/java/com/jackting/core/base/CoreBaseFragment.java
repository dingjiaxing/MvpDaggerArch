package com.jackting.core.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;

/**
 * <p>Description:
 * <p>Company:863 software
 * <p>Email:itdjx@qq.com
 * @author:Created by Jack Ting on 2018/8/1
 */
public abstract class CoreBaseFragment extends DaggerFragment {

	/** Fragment 所在 Activity */
	protected CoreBaseActivity mActivity;
	protected View rootView;
	private Unbinder mUnbinder;

	// protected SystemBarTintManager mTintManager;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		mActivity =  (CoreBaseActivity) getActivity();
		super.onCreate(savedInstanceState);
		// mTintManager = new SystemBarTintManager(mActivity);
//		LogUtil.d("BaseFragment", getClass().getSimpleName());
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//		return super.onCreateView(inflater, container, savedInstanceState);
		View root=inflater.inflate(getContentViewResId(),container,false);
		mUnbinder = ButterKnife.bind(this,root);
		return root;
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		rootView=view;
		initCreate();
	}

	protected void initCreate() {
		init();
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if(mUnbinder != Unbinder.EMPTY){
			mUnbinder.unbind();
		}
	}

	@LayoutRes
	protected abstract int getContentViewResId();
	protected abstract void init();
}
