package com.example.myapplication41.model;

import com.example.myapplication41.interfaces.Interfaces;
import com.example.mylibrary.BannerRetrifitUtils;
import com.example.mylibrary.INetCallkBack;
import com.example.mylibrary.ShowRetrifitUtils;


/**
 * 项目名： My Application41
 * 包名：   com.example.myapplication41.model
 * 文件名： Model
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 15:42
 * 描述：TODO  M层，用于接收各类数据
 */
public class Model implements Interfaces.IModel {
    //网络解析一号
    @Override
    public <B> void getBannerData(Interfaces.IPresenter iPresenter, String url, String cityid, String token, INetCallkBack.setBanner<B> view) {
        BannerRetrifitUtils.getInstance().getBanner(url,cityid,token,view);
    }
    //网络解析二号
    @Override
    public <S> void getShowData(Interfaces.IPresenter iPresenter, String url, String cityid, String token, INetCallkBack.setShow<S> view) {
        ShowRetrifitUtils.getInstance().getShow(url,cityid,token,view);
    }
    //理论上可以添加多个网络解析
}
