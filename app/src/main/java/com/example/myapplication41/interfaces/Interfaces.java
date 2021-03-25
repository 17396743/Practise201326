package com.example.myapplication41.interfaces;

import com.example.myapplication41.model.Bean.BannerBean;
import com.example.myapplication41.model.Bean.ShowBean;
import com.example.myapplication41.presenter.Presenter;
import com.example.mylibrary.INetCallkBack;

/**
 * 项目名： My Application41
 * 包名：   com.example.myapplication41.interfaces
 * 文件名： Interfaces
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 15:42
 * 描述：TODO MVP连接层
 */
//接口可以单继承，多继承，所以可以提升接口的上限
public interface Interfaces extends INetCallkBack{
    interface IModel {
        <B> void getBannerData(IPresenter iPresenter, String url, String cityid, String token, setBanner<B> view);

        <S> void getShowData(IPresenter iPresenter, String url, String cityid, String token, setShow<S> view);

    }
    //用于V层响应P层用
    interface IPresenter {
        Presenter getData();
    }
    //用于接收M层收到的数据
    interface IView {
        void BannerData(BannerBean bannerBean);

        void BannerError(String error);

        void ShowData(ShowBean showBean);

        void ShowError(String error);
    }
}
