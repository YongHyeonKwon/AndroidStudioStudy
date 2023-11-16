package com.example.ex_volley;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ex_volley.databinding.ActivityMain2Binding;

import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    RequestQueue requestQueue;

    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. Volley 초기화 작업
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        // 2. 버튼 이벤트
        binding.Request2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 3. 입력된 값 가져오기
                String data = binding.Input2.getText().toString();

                // 4. request의 내용 생성
                request = new StringRequest(
                        Request.Method.POST,
                        "http://211.223.106.158:8091/AndroidServer/ServerTest",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {


                            }
                        }
                ){
                    // 데이터를 전달하기 위한 메소드 생성 -> getParams()
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();

                        params.put("data1", data);

                        return params;

                    }
                };

                // 5. requestqueue에 포함시켜 전달
                requestQueue.add(request);
            }
        });

    }
}