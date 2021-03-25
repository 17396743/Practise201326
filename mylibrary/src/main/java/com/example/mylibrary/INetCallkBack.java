package com.example.mylibrary;


/**
 * 项目名： My Application41
 * 包名：   com.example.mylibrary.utils
 * 文件名： IntNetCallkBack
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 15:58
 * 描述：TODO  用于接收和发送获取到的网络数据
 */
public interface INetCallkBack {
    //收放者一号
    interface setBanner<B> {

        void setBannerBean(B b);

        void setBannerError(String error);
    }
    //收放者二号
    interface setShow<S> {

        void setShowBean(S s);

        void setShowError(String error);
    }


}
