package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    // 1. 바인딩 객체 지정!
    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 2. 화면 설정하기
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 3. 이미지 영역 숨기기
        binding.img.setVisibility(View.INVISIBLE);
        binding.img.setVisibility(View.VISIBLE);

        // 4. 텍스트 색상 변경하기
        binding.tvTitle.setTextColor(Color.MAGENTA);
        binding.tvTitle.setTextColor(Color.parseColor("#006400"));

    }
}