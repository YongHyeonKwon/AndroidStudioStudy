package com.example.ex_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ex_intent.databinding.ActivityMain3Binding;
import com.example.ex_intent.databinding.ActivitySub3Binding;

public class SubActivity3 extends AppCompatActivity {

    ActivitySub3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySub3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String id = getIntent().getStringExtra("id");
        binding.tvMsg1.setText(id+"님 환영합니다.");
    }



}