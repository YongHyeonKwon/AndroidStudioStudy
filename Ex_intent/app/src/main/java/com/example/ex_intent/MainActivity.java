package com.example.ex_intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.example.ex_intent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. btnWeb 버튼 사용하기
        binding.btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 화면에 움직이기 위한 액션을 주기 위해서는 intent를 사용해야 한다.
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:www.naver.com"));

                // intent가 실행될 수 있는 명령
                startActivity(intent);
            }
        });

        binding.btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(intent);
            }
        });

        binding.btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Dial 화면 띄우기
                // Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1234-5678"));
                // startActivity(intent);

                // call 화면 띄우기
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-9677-2654"));

                // 전화 기능에 대한 권한을 승인 받아야 사용할 수 있다!
                // 사용하고자 하는 권한이 있는지 체크하여 판단하기
                if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED){
                    // 해당하는 기능에 대한 권한을 요청한다!
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE}, 0);
                }

                startActivity(intent);
            }
        });

    }

}