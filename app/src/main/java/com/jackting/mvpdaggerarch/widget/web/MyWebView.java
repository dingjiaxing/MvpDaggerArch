package com.jackting.mvpdaggerarch.widget.web;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

import com.jackting.mvpdaggerarch.widget.web.settings.WebViewDefaultSetting;
import com.jackting.mvpdaggerarch.widget.web.webViewClient.MyWebViewClient;

public class MyWebView extends WebView {
    Context context;
    MyWebViewClient webViewClient;
    public MyWebView(Context context) {
        super(context);
        init(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    protected void init(Context context){
        this.context=context;
        WebViewDefaultSetting.getInstance().toSetting(this);
        webViewClient=new MyWebViewClient();
        setWebViewClient(webViewClient);

    }
}
