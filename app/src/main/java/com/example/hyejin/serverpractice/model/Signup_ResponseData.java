package com.example.hyejin.serverpractice.model;

import com.google.gson.annotations.SerializedName;

public class Signup_ResponseData {
    @SerializedName("mandalCnt")
    public String mandalCnt;
    @SerializedName("mandalMax")
    public String mandalMax;
    @SerializedName("_id")
    public String _id;
    @SerializedName("id")
    public String id;
    @SerializedName("passwd")
    public String passwd;
    @SerializedName("name")
    public String name;
    @SerializedName("pushNotifications")
    public String[] pushNotifications;
    @SerializedName("mandalArtTheme")
    public String[] mandalArtTheme;
    @SerializedName("userMandalArt")
    public String[] userMandalArt;
    @SerializedName("triangleMandalArt")
    public String[] triangleMandalArt;
    @SerializedName("__v")
    public int __v;
}
