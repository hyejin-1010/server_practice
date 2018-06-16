package com.example.hyejin.serverpractice.api;

import com.example.hyejin.serverpractice.model.SignUp_Data;
import com.example.hyejin.serverpractice.model.Signup_ResponseData;
import com.example.hyejin.serverpractice.model.User_Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface API {
    @POST("/signup/")
    Call<Signup_ResponseData> singup(@Body User_Data user_data);

    @POST("/signin/")
    Call<Signup_ResponseData> signin(@Body SignUp_Data signUp_data);

    @POST("/aa/")
    Call<List<Signup_ResponseData>> aa();
}
