package com.example.ex_adapter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ex_adapter.databinding.ActivityMainBinding; // ActivityMainBinding 클래스 임포트

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding; // binding 변수 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. 데이터 생성하기 
        String[] arr = {"짜장","짬뽕","탕수육","깐쇼새우","유린기","유산슬","팔보채","연태","고량주",
                "짜장","짬뽕","탕수육","깐쇼새우","유린기","유산슬","팔보채","연태","고량주"};

        // 2. Adapter 생성하기
        // new ArrayAdapter<>(어플의 정보(Context), 사용할 layout(안드로이드 기본 제공), 사용할 data(arr 배열)
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arr);

        // 3. ListView에 데이터 연결
        binding.listView.setAdapter(adapter);

        // 4. listView에 이벤트 연결
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), arr[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
