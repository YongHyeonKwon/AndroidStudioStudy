package com.example.ex_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ex_intent.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 로그인 버튼이 눌리면
        // 아이디와 비밀번호 넘겨 로그인 확인하기!
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               // 아이디와 비밀번호 값을 가져와 로그인이 가능한지 판단!
               // ID : test / PW : 123

               String id = binding.edtID.getText().toString();
               String pw = binding.edtPw.getText()+"";

               if (id.equals("test") && pw.equals("123")) {
                   // 로그인 가능하다! -> intent 화면 이동! -> id값을 intent 담아서 전달
                   Intent intent = new Intent(getApplicationContext(), SubActivity3.class);
                    intent.putExtra("id", id);
                   startActivity(intent);
                    finish(); // 실행 이후의 화면을 꺼주는 기능! -> MAinactivity3
               }else{
                   // 로그인 실패 -> toast 띄워주기
                   // getApplicationContext() == this 키워드 대체 가능
                   Toast.makeText(getApplicationContext(), "로그인 실패",
                           Toast.LENGTH_SHORT).show();
               }

           }
        });

    }
}