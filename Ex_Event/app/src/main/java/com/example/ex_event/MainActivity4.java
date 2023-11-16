package com.example.ex_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.ex_event.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity implements View.OnClickListener{

    ActivityMain4Binding binding;

    // 모든 이미지를 관리할 수 있는 배열 생성
    // 안드로이드는 res 들어가는 모든 정보를 정수형으로 관리한다!
    int[] arr = {R.drawable.juyung, R.drawable.rupi, R.drawable.spun};

    // 인덱스의 번호를 기억할 수 있는 변수

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 버튼이 눌리면 이미지가 변경되도록 만들기!
        // 이미지1, 이미지2, 이미지3
        binding.btnR.setOnClickListener(this);
        binding.btnL.setOnClickListener(this);

        // 초기 이미지 설정
        binding.img.setImageResource(arr[index]);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == binding.btnR.getId()) { // 다음 버튼
            // 다음 이미지로 이동
            index = (index + 1) % arr.length;
        } else if (view.getId() == binding.btnL.getId()) { // 이전 버튼
            // 이전 이미지로 이동
            index = (index - 1 + arr.length) % arr.length;
        }
//      이미지 뷰에 새 이미지 설정
        binding.img.setImageResource(arr[index]);
        }
    }
