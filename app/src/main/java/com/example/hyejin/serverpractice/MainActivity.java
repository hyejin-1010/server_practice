package com.example.hyejin.serverpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.hyejin.serverpractice.api.APIRequestManager;
import com.example.hyejin.serverpractice.model.Signup_ResponseData;
import com.example.hyejin.serverpractice.model.User_Data;

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
    }

    @Override
    protected void onResume() {
        super.onResume();

        P.user_data.id = "hyejin";
        P.user_data.name = "khj";
        P.user_data.passwd = "001010";

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
    }
}
