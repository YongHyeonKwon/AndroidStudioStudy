package com.example.ex_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.ex_event.databinding.ActivityMain4Binding;
import com.example.ex_event.databinding.ActivityMain5Binding;

import java.util.Random;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener{

    ActivityMain5Binding binding;

    // 주사위 이미지를 관리할 수 잇는 배열 생성!
    int[] arr = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
                 R.drawable.dice4, R.drawable.dice5, R.drawable.dice6 };

    int s1, s2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnShake.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        // 1. 주사위 눈이 변경이 되어야 한다! -> 랜덤으로 숫자가 변경된다
        Random rd = new Random();
        int num1 = rd.nextInt(6); // 첫 번째 주사위에 대한 랜덤 수
        int num2 = rd.nextInt(6); // 두 번째 주사위에 대한 랜덤 수

        // 2. 랜덤수에 맞춰 주사위 이미지 변경하기
        binding.dice1.setImageResource(arr[num1]);
        binding.dice2.setImageResource(arr[num2]);

        // 3. 두 개의 주사위 수 중에서 어떤 수가 더 큰지 판단
        // 해당하는 score의 점수가 1씩 증가되도록 연결한다.
        if(num1 > num2){
            int s1 = Integer.parseInt( binding.score1.getText()+""); // String
            s1++;
            binding.score1.setText(s1+"");
        } else if (num1 < num2) {
            int s2 = Integer.parseInt( binding.score2.getText()+""); // String
            s2++;
            binding.score2.setText(s2+"");
        }else{
            // Toast 메시지 만들기
            Toast.makeText(this, "동점입니다 !", Toast.LENGTH_SHORT).show();
        }
    }
}