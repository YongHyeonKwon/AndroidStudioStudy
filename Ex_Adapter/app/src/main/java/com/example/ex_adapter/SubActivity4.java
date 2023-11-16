package com.example.ex_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.renderscript.ScriptGroup;

import com.example.ex_adapter.databinding.ActivitySub4Binding;

public class SubActivity4 extends AppCompatActivity {

    ActivitySub4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySub4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // MainActivity4 화면에서 원하는 상품의 btn을 누르면
        // 해당하는 상품의 정보를 따로 띄워주는 화면!

        String titlePro = getIntent().getStringExtra("data1");
        Bitmap imgPro = (Bitmap) getIntent().getExtras().get("data2");

        binding.titleSub.setText(titlePro);
        binding.imgSub.setImageBitmap(imgPro);
    }
}