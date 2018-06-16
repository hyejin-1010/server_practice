package com.example.hyejin.serverpractice.api;

import com.example.hyejin.serverpractice.model.Signup_ResponseData;
import com.example.hyejin.serverpractice.model.User_Data;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("/signup/")
    Call<Signup_ResponseData> singup(@Body User_Data user_data);
}
