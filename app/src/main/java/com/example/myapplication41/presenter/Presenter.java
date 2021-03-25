package com.example.myapplication41.presenter;

import com.example.myapplication41.interfaces.Interfaces;
import com.example.myapplication41.model.Bean.BannerBean;
import com.example.myapplication41.model.Bean.ShowBean;
import com.example.myapplication41.model.Model;
import com.example.mylibrary.INetCallkBack;
import com.example.mylibrary.URLContrat;

/**
 * 项目名： My Application41
 * 包名：   com.example.myapplication41.presenter
 * 文件名： presenter
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 15:42
 * 描述：TODO P层用于连接层和V层
 */
public class Presenter implements Interfaces.IPresenter {
    private Interfaces.IModel model;
    private Interfaces.IView view;
    //用于与V层进行绑定
    public Presenter(Interfaces.IView view) {
        model = new Model();
        this.view = view;
    }
    //用于与V层进行交互
    @Override
    public Presenter getData() {
        //交互者一号
        model.getBannerData(this, URLContrat.BANNER_NEWURL, URLContrat.BANNER_CITYID, URLContrat.BANNER_TOKEN, new INetCallkBack.setBanner<BannerBean>() {
            @Override
            public void setBannerBean(BannerBean bannerBean) {
                view.BannerData(bannerBean);
            }

            @Override
            public void setBannerError(String error) {
                view.BannerError(error);
            }
        } );

        //交互者二号
        model.getShowData(this, URLContrat.SHOW_NEWURL, URLContrat.SHOW_CITYID, URLContrat.SHOW_TOKEN, new INetCallkBack.setShow<ShowBean>() {

            @Override
            public void setShowBean(ShowBean showBean) {
                view.ShowData(showBean);
            }

            @Override
            public void setShowError(String error) {
                view.ShowError(error);
            }
        });
        //用于与V层进行二次绑定，这个改，可不改，因为已经绑定过一次了，有没有，用处并不大。
        return this;
    }
}
