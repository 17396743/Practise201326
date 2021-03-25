package com.example.mylibrary;

import android.util.Log;

import com.google.gson.Gson;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 项目名： My Application41
 * 包名：   com.example.mylibrary
 * 文件名： BannerRetrifitUtils
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 18:53
 * 描述：TODO 一号网络解析
 */
public class BannerRetrifitUtils implements INetWorkInterface.BannerData {
    //基础模块
    private static BannerRetrifitUtils retrifitUtils;
    //网络解析模块
    private ApiServer apiBannerServer;

    //基础模块
    public BannerRetrifitUtils() {
        //网络解析
        Retrofit build = new Retrofit.Builder()
                .client(HttpLoggingInterceptor()) //加入网络拦截器
                .baseUrl(URLContrat.BANNER_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //加入RXJAVA工厂模式
                .build();
        apiBannerServer = build.create(ApiServer.class);
    }
    //基础模块
    public static BannerRetrifitUtils getInstance() {
        if (retrifitUtils == null) {
            synchronized (BannerRetrifitUtils.class) {
                if (retrifitUtils == null) {
                    retrifitUtils = new BannerRetrifitUtils();
                }
            }
        }
        return retrifitUtils;
    }

    //网络拦截器
    public OkHttpClient HttpLoggingInterceptor() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new Interceptor() {
                    @NotNull
                    @Override
                    public Response intercept(@NotNull Chain chain) throws IOException {
                        Request request = chain.request();
                        Response proceed = chain.proceed(request);
                        String string = proceed.peekBody(1024).string();
                        Log.d("TAG", "Banner_intercept：" + string);
                        return proceed;
                    }
                }).build();
    }

    //网络解析
    @Override
    public <B> void getBanner(String url, String cityid, String token, INetCallkBack.setBanner<B> view) {
        apiBannerServer.getBannerData(url, cityid, token)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string();
                            Type[] genericInterfaces = view.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type type = actualTypeArguments[0];
                            Gson gson = new Gson();
                            B b = gson.fromJson(string, type);
                            view.setBannerBean(b);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.setBannerError("" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
