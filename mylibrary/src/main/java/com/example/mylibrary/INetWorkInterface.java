package com.example.mylibrary;

/**
 * 项目名： My Application41
 * 包名：   com.example.mylibrary.utils
 * 文件名： INetWorkInterface
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 16:01
 * 描述：TODO 接口继承提升接口的上限
 */
public interface INetWorkInterface extends INetCallkBack{
    //收放者进阶一号
    interface BannerData {
        <B> void getBanner(String url, String cityid, String token, setBanner<B> view);
    }
    //收放者进阶二号
    interface ShowData {
        <S> void getShow(String url, String cityid, String token, setShow<S> view);
    }
}
