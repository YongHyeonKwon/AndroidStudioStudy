package com.example.ex_intent;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ex_intent.databinding.ActivityMain4Binding;

public class MainActivity4 extends AppCompatActivity {

    ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 양방향 화면전환! -> Main - sub - Main 돌아오기

        // 1. 버튼이 눌리면 입력된 값을 가져오는 이벤트!
        binding.btnSend.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String msg = binding.Input.getText().toString();

                // 2. 가져온 데이터를 intent에 담아 화면 전환하기!
                Intent intent = new Intent(getApplicationContext(), SubActivity4.class);
                intent.putExtra("msg", msg);

                // 단방향 전용의 intent 실행문!
                // starActivity();

                mainluncher.launch(intent); // 양방향 전용의 intent 실행문!
            }
        });
    }

    // 양방향을 위한 객체 사용!
    ActivityResultLauncher<Intent> mainluncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    // result : 이전화면 (Sub 화면)에서 발생한 결과 값을 담아주는 변수
                    if(result.getResultCode() == RESULT_OK){
                        // 양방향에 대한 통신이 제대로 수행된 것!
                        String data = result.getData().getStringExtra("msg");
                        binding.tvTitle.setText(data);
                    }else{
                        Toast.makeText(getApplicationContext(), "실패", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );
}
