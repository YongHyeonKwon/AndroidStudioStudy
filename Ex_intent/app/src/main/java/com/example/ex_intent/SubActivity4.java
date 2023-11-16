package com.example.ex_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ex_intent.databinding.ActivitySub4Binding;

public class SubActivity4 extends AppCompatActivity {

    ActivitySub4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySub4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. Main에서 보내주는 Intent 가져오기
        Intent intent2 = getIntent();

        // 2. Intent에 담겨져 있는 데이터 꺼내오기
       String data = intent2.getStringExtra("msg");

        // 3. 가져온 데이터 TextView에 띄우기!
        binding.tvTitle2.setText(data);

        // 4. 버튼을 클릭하면 다시 Main화면으로 돌아가기!
        binding.btnSend2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg = binding.tvTitle2.getText().toString();

                intent2.putExtra("msg", msg);

                // setResult(상태 코드, 데이터(인텐트))
                setResult(RESULT_OK, intent2);

                finish();
            }
        });
    }
}