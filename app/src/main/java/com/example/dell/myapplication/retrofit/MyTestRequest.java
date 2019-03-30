package com.example.dell.myapplication.retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Query;

/**
 * create by lizejun
 * date 2018/8/6
 */
public interface MyTestRequest {

    @GET("api/data/福利/10/1")
    Call<ResponseBody> getGirls();
}
