package com.example.ex_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.ex_intent.databinding.ActivityMain2Binding;
import com.example.ex_intent.databinding.ActivityMainBinding;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Main -> Sub 이동하는 단 방향 Intent 사용!
        // Main에 있는 버튼을 클릭하면 Intent를 사용하여 Sub 이동

        binding.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 화면의 이동을 위한 Intent 생성
                // new Intent(출발점(MainActivity2, 도착점(SubActivity2))
                Intent intent = new Intent(getApplicationContext(), SubActivity2.class);

                // Intent에 담아주고 싶은 데이터를 담아주기!
                intent.putExtra("data", "test");

                startActivity(intent);
                
                // 실행중인 화면을 이동하면서 종료시키는 기능
                finish();
            }
        });

    }
}