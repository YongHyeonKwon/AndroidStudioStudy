package com.example.ex_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.ex_adapter.databinding.ActivityMain4Binding;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 어플이 시작되는 시점

        // 나만의 Adapter 클래스 생성
        // SubActivity 화면 생성
        // ProductVO 클래스 생성 -> 데이터를 관리하기 위한 클래스

        // 이미지 파일들을 관리하기 위한 배열생성
        int[] imgArr = {R.drawable.item1, R.drawable.item2, R.drawable.item3, R.drawable.item4,
                R.drawable.item5, R.drawable.item6, R.drawable.item7, R.drawable.item8, R.drawable.item9,
                R.drawable.item10, R.drawable.item11,};

        // 상품의 이름을 관리하기 위한 배열생성
        String[] proName = {"텀블러", "실내화", "케이스", "인형", "피규어", "안마봉", "파우치",
                "공책", "필통", "티셔츠", "티셔츠"};

        ArrayList<ProductVO> dataset = new ArrayList<>();

        for (int i = 0; i < imgArr.length; i++) {
            dataset.add(new ProductVO(imgArr[i], proName[i], "상품 : " + 10));


            ProAdapter adapter = new ProAdapter(getApplicationContext(), R.layout.product_list, dataset);

            binding.listView.setAdapter(adapter);
        }
    }
}