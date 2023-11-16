package com.example.ex_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ex_intent.databinding.ActivitySub2Binding;

public class SubActivity2 extends AppCompatActivity {

    ActivitySub2Binding binding;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySub2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        // MainActivity에서 넘겨주는 데이터 꺼내오기
        // 꺼내올 때는 해당하는 데이터의 타입에 맞춰 get타입Extra() 사용!
        String data = getIntent().getStringExtra("data");

        binding.tvMsg.setText(data);

    }
}