package com.example.dell.myapplication.retrofit;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * create by lizejun
 * date 2018/8/6
 */
public interface RxtestRequest {

    @GET("top250")
    Observable<ResponseBody> getTop250(@Query("start") int start,@Query("count") int count);
}
