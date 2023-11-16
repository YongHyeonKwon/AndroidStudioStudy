package com.example.ex_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ex_adapter.databinding.ActivityMain3Binding;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 사용자가 원하는 layout에 다양한 데이터를 연결하는 Adapter 만들기
        // 1. 데이터 ( 프로필 이미지, 이름, 상태메세지)
        // 2. 사용가가 원하는 디자인의 layout 생성!
        // 3. 사용자가 새롭게 생성하는 adapter

        ArrayList<InfoVO> dataset = new ArrayList<>();

        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "채수민", "오늘은 뭐먹지..?"));
        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "손지영", "해피해피데이"));
        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "김운비", "취익취익~"));
        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "김민수", "좋아요~"));
        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "박기원", "오늘은 뭐먹지..?"));
        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "권용현", "해피해피데이"));
        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "유선웅", "취익취익~"));
        dataset.add(new InfoVO(R.drawable.ic_launcher_background, "상남자", "좋아요~"));


        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.user_list, dataset);

        binding.listView3.setAdapter(adapter);

    }
}