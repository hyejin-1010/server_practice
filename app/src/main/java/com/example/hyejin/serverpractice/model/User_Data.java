package com.example.hyejin.serverpractice.model;

import com.google.gson.annotations.SerializedName;

public class User_Data {
    @SerializedName("id")
    public String id;
    @SerializedName("passwd")
    public String passwd;
    @SerializedName("name")
    public String name;
}
