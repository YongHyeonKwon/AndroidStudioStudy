package com.example.ex_fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.ex_fragment.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        // 프래그먼트 화면에 대한 클래스 객체 생성
        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();
        Fragment3 fragment3 = new Fragment3();


        // 각 메뉴에 따른 프래그먼트 연결
        binding.Nav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId() == R.id.btnHome){
                    // 프래그먼트 영역에 원하는 화면을 배치하는 작업
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, fragment1).commit();
                } else if (item.getItemId() == R.id.btnWeb) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.Frame, fragment2).commit();
                }

                return true; // 선택된 값을 리턴하는 내용
            }
        });

        // 프래그먼트 영역에 원하는 화면을 배치하는 작업
        getSupportFragmentManager().beginTransaction().replace(R.id.Frame, fragment1).commit();
        
        
    }
}