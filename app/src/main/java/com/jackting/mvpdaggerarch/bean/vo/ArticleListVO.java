package com.jackting.mvpdaggerarch.bean.vo;

import com.jackting.mvpdaggerarch.bean.entity.Article;

import java.util.List;

public class ArticleListVO {
    public int curPage;
    public List<Article> datas;
    public int pageCount;
    public int size;
    public int total;
}
