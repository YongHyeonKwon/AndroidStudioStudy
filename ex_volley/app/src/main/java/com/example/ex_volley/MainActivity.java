package com.example.ex_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ex_volley.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    StringRequest request; // 통신을 위한 내용을 담을 수 있는 객체
    RequestQueue requestQueue; // 서버에 요청을 전달하는 객체

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 버튼을 클릭하면 원하는 url로 통신 요청을 전달!

        // 1. RequestQueue 초기화 작업
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        // 버튼 이벤트 생성
        binding.Request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              String data =  binding.Input.getText().toString();

                request = new StringRequest(
                        Request.Method.GET,
                        "http://211.223.106.158:8091/AndroidServer/ServerTest?data=" + data ,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // 통신이 성공했을 때 진행할 수 있는 로직의 위치!
                                // 매개변수 response -> 실제 응답으로 돌아오는 결과값
                                Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // 통신에 실패했을 때 사용할 수 있는 로직의 위치
                                Toast.makeText(getApplicationContext(), error+"", Toast.LENGTH_SHORT).show();
                            }
                        }

                );

                requestQueue.add(request);
                
            }
        });


            // 통로를 통해서 실제 요청을 실행하는 명령!



    }
}