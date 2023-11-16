package com.example.ex_volley;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ex_volley.databinding.ActivityLoginBinding;
import com.example.ex_volley.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity {

    ActivityLoginBinding binding;

    RequestQueue requestQueue;

    StringRequest request;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. Volley 초기화 작업
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        // 2. 버튼 이벤트
        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = binding.id.getText().toString();
                String pw = binding.pw.getText().toString();

                // 통신을 위한 내용 만들기 
                request = new StringRequest(
                        Request.Method.POST,
                        "http://211.223.106.158:8091/AndroidServer/ServerTest",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                // reponse  결과값을 JSON 타입으로 파싱을 하면 원하는 키값에 대한 value값을 꺼내올 수 있다.

                                try {
                                    JSONObject json = new JSONObject(response);

                                    JSONObject data = json.getJSONObject("result");
                                    Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_SHORT).show();

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }

                                Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                ){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {

                        Map<String, String> params = new HashMap<>();

                        params.put("id", id);
                        params.put("pw", pw);

                        return params;
                    }
                }; // request에 대한 내용이 끝나는 지점

                requestQueue.add(request);
            }
        }); // 버튼 이벤트 끝나는 지점

    }
}