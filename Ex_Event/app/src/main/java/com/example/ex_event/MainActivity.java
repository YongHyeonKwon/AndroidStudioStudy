package com.example.ex_event;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.ex_event.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    // 1. xml 파일을 활용한 event 연결
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
    }

    //나만의 event메소드 생성xxxx
    // 매개변수 -> 어떤 뷰에 해당하는 이벤트를 연결할 것인지!
    public void MyEvent(View view) {
        // 이벤트가 감지 되었을때 어떠한 처리를 수행할 것인지
        // 해당하는 로직을 가지고 있어야 한다.

        // 레이아웃의 배경색 변경
        binding.layout.setBackgroundColor(Color.RED);
    }


}