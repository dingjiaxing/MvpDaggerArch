package com.jackting.mvpdaggerarch.base;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jackting.core.base.CoreBaseFragment;
import com.jackting.mvpdaggerarch.R;

public abstract class BaseFragment<P extends BasePresenter> extends CoreBaseFragment {

    private TextView tvHeaderTitle;
    private ImageView ivHeaderBack;

    protected P presenter;
    private AbsPresenter absPresenter;

    @Override
    protected void initCreate() {
        initHeader();
        initHeaderEvent();
        if(absPresenter!=null){
            absPresenter.takeView(getBaseView());
        }
        super.initCreate();
    }

    protected abstract BaseView getBaseView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if(absPresenter!=null){
            absPresenter.dropView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.presenter = null;
        this.mActivity = null;
        this.absPresenter = null;
    }

    void initHeader(){
//        tvHeaderTitle=rootView.findViewById(R.id.tv_header_title);
//        ivHeaderBack=rootView.findViewById(R.id.iv_header_back);


    }

    public void setPresenter(P presenter){
        if(presenter instanceof AbsPresenter){
            this.absPresenter=(AbsPresenter) presenter;
        }
        this.presenter=presenter;
    }

    void initHeaderEvent(){
        if(ivHeaderBack!=null){
            ivHeaderBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mActivity.finish();
                }
            });
        }
    }

    protected void setTitle(String titleString){
        if(tvHeaderTitle!=null && titleString!=null){
            tvHeaderTitle.setText(titleString);
        }
    }

    protected void setTitle(int stringResId){
        if(tvHeaderTitle!=null){
            tvHeaderTitle.setText(mActivity.getText(stringResId));
        }
    }
}
