package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    // 바인딩 사용하기 위한 객체 -> gradle 수정하면 자동으로 해당 객체가 생성!
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // activity_main.xml 의 위치를 가지고 오는 기능
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. 기능을 부여하고 싶은 view의 위치를 찾아온다!
        // findViewById()
        // TextView tvMsg1 = findViewById(R.id.tvMsg1);

        // ViewBinding 사용하기
        // : xml의 view 컴포넌트에 접근하는 object를 반환받아 저장하는 개념


        // 2. text 내용을 수정하는 기능 연결
        binding.tvMsg1.setText("즐거운 월요일 안드로이드 수업~!");

        // 실행 단축키 : alt + shift + x
        
        // 3. text 내용을 가져오는 기능 연결
        String msg = binding.tvMsg1.getText().toString();

        // 4. 이클립스의 console처럼 띄워서 확인하기 -> Logcat 사용
        Log.d("data", msg);
    }
}