package com.example.dell.myapplication.retrofit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.dell.myapplication.R;
import com.example.dell.myapplication.three.SchoolModule;
import com.google.gson.Gson;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitActivity extends AppCompatActivity {

    private TextView resultView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit);
        resultView = findViewById(R.id.result);

        init();
    }

    private void init() {
        //先要构建出okHttpClient
        OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
        okHttpBuilder.readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);

        OkHttpClient okHttpClient = okHttpBuilder.build();
        String url = "https://gank.io/";
        String Durl = "https://api.douban.com/v2/movie/";
        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(url)
                .baseUrl(Durl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
                .build();


//        retrofit.create(MyTestRequest.class)
//                .getGirls()
//                .enqueue(new Callback<ResponseBody>() {
//                    @Override
//                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                        ResponseBody body = response.body();
//                        try {
//                            resultView.setText(body.string());
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//                    }
//                });

        RxtestRequest rxtestRequest = retrofit.create(RxtestRequest.class);
        Observable<ResponseBody> top250 = rxtestRequest.getTop250(0, 10);
        top250.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {

                        try {
                            resultView.setText(responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        //构建出Retrofit实例
//        Retrofit.Builder builder = new Retrofit.Builder();
//        Retrofit retrofit = builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
//                .baseUrl("your_upload_url")
//                .client(okHttpClient)
//                .build();

//        retrofit
//                .create(ApiService.class)
//                .getTop250(5)
//                .subscribeOn(Schedulers.io())//请求在IO线程中
//                .observeOn(AndroidSchedulers.mainThread())//回调在主线线程
//                .subscribe(new Observer<Top250Bean>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Top250Bean top250Bean) {
//                        //请求成功
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//                        //请求失败
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });


    }
}
