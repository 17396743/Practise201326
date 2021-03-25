package com.example.mylibrary;

import io.reactivex.Observable;

import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;
import retrofit2.http.Url;

/**
 * 项目名： My Application41
 * 包名：   com.example.mylibrary.utils
 * 文件名： ApiServer
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 15:45
 * 描述：TODO
 */
public interface ApiServer {
    //网络解析配置信息接收区
    @FormUrlEncoded
    @POST
    Observable<ResponseBody> getBannerData(@Url String url , @Field("cityid") String cityid, @Field("token") String token);

    @FormUrlEncoded
    @POST
    Observable<ResponseBody> getShowData(@Url String url , @Field("cityid") String cityid, @Field("token") String token);

}
