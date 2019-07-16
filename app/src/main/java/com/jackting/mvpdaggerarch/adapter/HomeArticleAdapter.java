package com.jackting.mvpdaggerarch.adapter;

import androidx.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.bean.entity.Article;

import java.util.List;

public class HomeArticleAdapter extends BaseQuickAdapter<Article, BaseViewHolder> {
    public HomeArticleAdapter(@Nullable List<Article> data) {
        super(R.layout.item_home_article,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Article item) {
        helper.setText(R.id.tv_item_home_article,item.title);
    }
}
