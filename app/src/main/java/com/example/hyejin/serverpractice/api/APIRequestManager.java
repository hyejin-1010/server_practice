package com.example.hyejin.serverpractice.api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRequestManager {
    public static String SERVER_URL = "http://iwin247.info:3322";
    private static APIRequestManager apiManager;

    private Retrofit retrofit;
    private API api;

    public static APIRequestManager getInstance(){
        apiManager = new APIRequestManager();

        return apiManager;
    }

    public API requestServer(){
        retrofit = new Retrofit.Builder().baseUrl(SERVER_URL).addConverterFactory(GsonConverterFactory.create()).build();

        return retrofit.create(API.class);
    }
}
