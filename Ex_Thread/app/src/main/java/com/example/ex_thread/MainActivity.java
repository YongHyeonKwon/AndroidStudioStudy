package com.example.ex_thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

import com.example.ex_thread.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 어플 시작과 동시에 TextView의 숫자가 바뀌는 기능!
        MyThread thread = new MyThread();
        thread.start(); // Thread의 run() 호출하는 메소드!


    }


    class MyThread extends Thread {
        // Thread를 실행하기 위해 꼭 필요한 메소드!

        @Override
        public void run() {

            // 1~10까지 숫자가 하나씩 카운팅 되는 타이머 생성!
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(2000); // 1000 = 1초
                    // Log.d("check", 1+"");

                    // 해당  숫자를 화면에 띄우기!
                    // -> Thread가 작업하지 못한다!
                    // -> 화면에 대한 UI 작업은 OnCreate()에 있는 메인 UI만 작업이 가능하다!
                    // binding.Number.setText(1 + "");

                    // Handler를 통한 데이터 전달! -> Thread에서 메인 UI로 메시지를 보내는 기능!
                    // 1. 정수형 -> msg.arg1
                    // 2. 정수형 -> msg.arg2
                    // 3. 객체형 -> msg.obj
                    Message msg = new Message();
                    msg.arg1 = i;

                    handler.sendMessage(msg);


                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    } // Thread 종료

    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {

            // 전달 받은 메시지 꺼내오기
            int i = msg.arg1;

            // 메인에 수정될 내용 연결하기
            binding.Number.setText(i+"");

        }
    };




}