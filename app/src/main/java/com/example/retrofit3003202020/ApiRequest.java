package com.example.retrofit3003202020;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {

//    https://khoapham.vn/KhoaPhamTraining/ (end point)
//    https://khoapham.vn/KhoaPhamTraining/json/tien/demo1.json
    @GET("json/tien/demo1.json")
    Call<Demo1> getDataDemo1();
}
