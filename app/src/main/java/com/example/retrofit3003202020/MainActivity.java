package com.example.retrofit3003202020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Retrofit.Builder;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bước 1 : Khởi tạo retrofit

        //Định nghĩa khởi tạo gson
        Gson gson = new GsonBuilder()
                .setLenient()
                .disableHtmlEscaping()
                .create();

        // OkhttpClient

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                    .readTimeout(30, TimeUnit.SECONDS)
                                    .writeTimeout(30,TimeUnit.SECONDS)
                                    .connectTimeout(30,TimeUnit.SECONDS)
                                    .retryOnConnectionFailure(true)
                                    .protocols(Arrays.asList(Protocol.HTTP_1_1))
                                    .build();


        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("http://khoapham.vn/KhoaPhamTraining/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .client(okHttpClient)
                            .build();

        //Bước 2 : Khơi tạo interface request
        ApiRequest apiRequest = retrofit.create(ApiRequest.class);

        //Bước 3 : Gọi hàm request
        Call<Demo1> apiDataDemo1 = apiRequest.getDataDemo1();

        apiDataDemo1.enqueue(new Callback<Demo1>() {
            @Override
            public void onResponse(Call<Demo1> call, Response<Demo1> response) {
                Demo1 demo1 = response.body();
                Log.d("BBB",demo1.getLogo());
            }

            @Override
            public void onFailure(Call<Demo1> call, Throwable t) {
                Log.d("BBB",t.getMessage());
            }
        });

    }
}