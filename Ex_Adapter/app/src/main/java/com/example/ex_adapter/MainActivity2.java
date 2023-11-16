package com.example.ex_adapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.ex_adapter.databinding.ActivityMain2Binding;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 데이터의 내용을 유지하기 위하여 버튼 이벤트 이전에 ArrayList 생성하기
        ArrayList<String> arr = new ArrayList<>();


        // 항목을 하나씩 입력하고 버튼을 누르면 listView에 추가되는 기능 만들기
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = binding.edtInput.getText().toString();

                arr.add(data);

                ArrayAdapter adapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, arr);

                binding.listView2.setAdapter(adapter);

            }
        });




    }
}