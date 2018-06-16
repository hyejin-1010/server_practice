package com.example.hyejin.serverpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hyejin.serverpractice.api.APIRequestManager;
import com.example.hyejin.serverpractice.model.SignUp_Data;
import com.example.hyejin.serverpractice.model.Signup_ResponseData;
import com.example.hyejin.serverpractice.model.User_Data;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "ServerPractice" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        P.user_data = new User_Data();
        SignUpData.signUp_data = new SignUp_Data();
    }

    @Override
    protected void onResume() {
        super.onResume();

        P.user_data.id = "hyejin";
        P.user_data.name = "khj";
        P.user_data.passwd = "001010";

        SignUpData.signUp_data.id = "akat32127";
        SignUpData.signUp_data.passwd = "akat32!";

        // 회원가입
        /*
        Call<Signup_ResponseData> call = APIRequestManager.getInstance().requestServer().singup(P.user_data);
        call.enqueue(new Callback<Signup_ResponseData>() {
            @Override
            public void onResponse(Call<Signup_ResponseData> call, Response<Signup_ResponseData> response) {
                switch (response.code()){
                    case 200:
                        Signup_ResponseData token = response.body();
                        Log.d(TAG, "회원가입 성공:" + token.name);
                        break;
                    case 412:
                        Log.e(TAG, "중복가입");
                        break;
                }
            }

            @Override
            public void onFailure(Call<Signup_ResponseData> call, Throwable t) {
                Log.e(TAG, "에러: " + t.getMessage());
                t.printStackTrace();
            }
        });
        */

        Call<Signup_ResponseData> call2 = APIRequestManager.getInstance().requestServer().signin(SignUpData.signUp_data);
        call2.enqueue(new Callback<Signup_ResponseData>() {
            @Override
            public void onResponse(Call<Signup_ResponseData> call, Response<Signup_ResponseData> response) {
                if(response.code() == 200){
                    Signup_ResponseData responseData = response.body();

                    Log.d(TAG, "로그인 성공 : " + responseData.name + ", " + responseData._id);
                } else {
                    Log.e(TAG, "에러 " + response.code());
                }
            }

            @Override
            public void onFailure(Call<Signup_ResponseData> call, Throwable t) {
                Log.e(TAG, "에러: " + t.getStackTrace());
            }
        });

        Call<List<Signup_ResponseData>> call3 = APIRequestManager.getInstance().requestServer().aa();
        call3.enqueue(new Callback<List<Signup_ResponseData>>() {
            @Override
            public void onResponse(Call<List<Signup_ResponseData>> call, Response<List<Signup_ResponseData>> response) {
                if(response.code() == 200){
                    List<Signup_ResponseData> result = response.body();

                    for(int i=0; i<result.size(); i++){
                        Log.d(TAG, "DB[" + i + "]_name: " + result.get(i).name);
                    }
                } else {
                    Log.e(TAG, "에러 " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Signup_ResponseData>> call, Throwable t) {
                Log.e(TAG, "에러: " + t.getStackTrace());
            }
        });
    }
}
