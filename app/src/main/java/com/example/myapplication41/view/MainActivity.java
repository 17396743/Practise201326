package com.example.myapplication41.view;

import android.util.Log;

import com.example.myapplication41.R;
import com.example.myapplication41.adapter.BeanAdapter;
import com.example.myapplication41.interfaces.Interfaces;
import com.example.myapplication41.model.Bean.BannerBean;
import com.example.myapplication41.model.Bean.ShowBean;
import com.example.myapplication41.presenter.Presenter;

public class MainActivity extends BeanAdapter implements Interfaces.IView {

    //Log标识
    private static final String TAG = ".MainActivity";

    //页面视图绑定
    @Override
    protected int getlayoutid() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void intData() {
        //启动P层到M层，获取数据用。
        getData();
    }

    @Override
    protected Presenter getData() {
        return new Presenter(this).getData();
    }

    //接收数据用
    //接收者一号
    @Override
    public void BannerData(BannerBean bannerBean) {
        Log.d(TAG, "BannerData: " + bannerBean.getData().getList().get(0).getDescription());
    }

    @Override
    public void BannerError(String error) {
        Log.e(TAG, "BannerError: " + error);
    }

    //接收者二号
    @Override
    public void ShowData(ShowBean showBean) {
        Log.d(TAG, "ShowData: " + showBean.getData().getList().get(0).getAddress());
    }

    @Override
    public void ShowError(String error) {
        Log.e(TAG, "ShowError: " + error);
    }
}