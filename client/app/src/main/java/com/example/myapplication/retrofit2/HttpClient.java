package com.example.myapplication.retrofit2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {

<<<<<<< .merge_file_a10436
    private static String BASE_URL = "http://192.168.0.23:8080";
=======
    private static String BASE_URL = "http://192.168.0.13:8080";
>>>>>>> .merge_file_a19980

    public static HttpService getApiService(){
        return getInstance().create(HttpService.class);
    }

    public static Retrofit getInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}