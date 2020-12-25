package com.example.pagetable.util;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApIService {
    @GET
    Observable<ResponseBody> get(@Url String url);

    @POST
    @FormUrlEncoded
    Observable<ResponseBody> post(@Url String url);

    @GET
    @FormUrlEncoded
    Observable<ResponseBody> formget(@Url String url, HashMap<String,String> map);
}
