package com.hollysmart.testbasemodule.api



import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.*


/**
 * Created by gbin on 2022/01/10.
 * Api 接口
 */

interface ApiService {


    /**
     * 前置服务器
     */

    @GET("/sys/randomImage/{timestamp}")
    fun getRandomImage(@Path("timestamp") timestamp:String,@QueryMap options:Map<String, String>): Observable<JsonObject>




}