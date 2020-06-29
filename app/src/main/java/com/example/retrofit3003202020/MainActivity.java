package com.example.retrofit3003202020;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        Gson gson = new GsonBuilder().setLenient().disableHtmlEscaping().create();
        Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://khoapham.vn/KhoaPhamTraining/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();

        //Bước 2 : Khơi tạo interface request
        ApiRequest apiRequest = retrofit.create(ApiRequest.class);

        //Bước 3 : Gọi hàm request


    }
}