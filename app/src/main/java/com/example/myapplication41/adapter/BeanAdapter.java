package com.example.myapplication41.adapter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 项目名： My Application41
 * 包名：   com.example.myapplication41.adapter
 * 文件名： BeanAdapter
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 15:38
 * 描述：TODO MVP核心处。主要用于实现方法。
 */
public abstract class BeanAdapter<B> extends AppCompatActivity {

    private B presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutid());
        //用于优化
        if (presenter== null){
            presenter = getData();
        }
        intData();
        initView();

    }
    //回调页面视图id
    protected abstract int getlayoutid();
    //放置页面视图组件
    protected abstract void initView();
    //调用数据用
    protected abstract void intData();
    //绑定P层用
    protected abstract B getData();
}
