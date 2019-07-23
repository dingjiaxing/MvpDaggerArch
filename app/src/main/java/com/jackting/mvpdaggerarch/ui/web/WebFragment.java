package com.jackting.mvpdaggerarch.ui.web;

import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.jackting.core.base.BaseView;
import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.base.BaseFragment;
import com.jackting.mvpdaggerarch.widget.web.MyWebView;
import com.orhanobut.logger.Logger;

import javax.inject.Inject;

import butterknife.BindView;

public class WebFragment extends BaseFragment<WebContract.Presenter> implements WebContract.View {


    @BindView(R.id.webView)
    MyWebView webView;
    @BindView(R.id.tv_web_title)
    TextView tvTitle;

    public String url="";

    @Inject
    public WebFragment() {
    }

    @Override
    protected BaseView getBaseView() {
        return this;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_web;
    }

    @Override
    protected void init() {
        url=getArguments().getString(WebActivity.URL_KEY);
        Logger.d("url",url);
        webView.loadUrl(url);

    }
}
