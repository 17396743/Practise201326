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
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * 项目名： My Application41
 * 包名：   com.example.mylibrary
 * 文件名： ShowRetrifitUtils
 * 创建者： 小狼不是哈士奇
 * B站：    幻雨之秋
 * 个人主页: https://hyzqacg.github.io/
 * 创建时间：2021/3/25 18:58
 * 描述：TODO
 */
public class ShowRetrifitUtils implements INetWorkInterface.ShowData {
    //基础模块
    private static ShowRetrifitUtils showRetrifitUtils;
    //网络解析模块
    private ApiServer apiShowServer;
    //基础模块
    public ShowRetrifitUtils() {
        //网络解析
        Retrofit build = new Retrofit.Builder()
                .client(HttpLoggingInterceptor())//加入网络拦截器
                .baseUrl(URLContrat.SHOW_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//加入RXJAVA工厂模式
                .build();
        apiShowServer = build.create(ApiServer.class);
    }
    //基础模块
    public static ShowRetrifitUtils getInstance() {
        if (showRetrifitUtils == null) {
            synchronized (BannerRetrifitUtils.class) {
                if (showRetrifitUtils == null) {
                    showRetrifitUtils = new ShowRetrifitUtils();
                }
            }
        }
        return showRetrifitUtils;
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
                        Log.d("TAG", "Show_intercept：" + string);
                        return proceed;
                    }
                }).build();
    }

    //网络解析
    @Override
    public <S> void getShow(String url, String cityid, String token, INetCallkBack.setShow<S> view) {
        apiShowServer.getShowData(url, cityid, token)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String string = responseBody.string().trim();
                            Type[] genericInterfaces = view.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            Gson gson = new Gson();
                            S s = gson.fromJson(string, t);
                            view.setShowBean(s);

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        view.setShowError("" + e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
