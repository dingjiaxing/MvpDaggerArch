package com.jackting.mvpdaggerarch.ui.main.home;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jackting.mvpdaggerarch.R;
import com.jackting.mvpdaggerarch.adapter.HomeArticleAdapter;
import com.jackting.mvpdaggerarch.base.BaseFragment;
import com.jackting.mvpdaggerarch.base.BaseView;
import com.jackting.mvpdaggerarch.bean.entity.Article;
import com.jackting.mvpdaggerarch.di.ActivityScoped;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

@ActivityScoped
public class MainHomeFragment extends BaseFragment<MainHomeContract.Presenter> implements MainHomeContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    HomeArticleAdapter adapter;
    List<Article> articleList=new ArrayList<>();

    @Inject
    public MainHomeFragment() {
    }

    @Override
    protected BaseView getBaseView() {
        return this;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.fragment_main_home;
    }

    @Override
    protected void init() {
        initRv();
    }

    void initRv(){
        adapter=new HomeArticleAdapter(articleList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity,RecyclerView.VERTICAL,false));
    }


    @Override
    public void showArticleList(List<Article> list) {
        this.articleList=list;
        adapter.setNewData(articleList);
//        adapter.notifyDataSetChanged();
    }
}
