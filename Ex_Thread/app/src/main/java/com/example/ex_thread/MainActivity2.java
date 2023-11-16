package com.example.ex_thread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

import com.example.ex_thread.databinding.ActivityMain2Binding;
import com.example.ex_thread.databinding.ActivityMainBinding;

import java.sql.Time;

public class MainActivity2 extends AppCompatActivity {

    ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 각각 버튼을 눌렀을 때 타이머가 시작되는 어플 만들기

        binding.Btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimeThread thread = new TimeThread(binding.Text1);
                thread.start();
            }
        });

        binding.Btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimeThread thread = new TimeThread(binding.Text2);
                thread.start();
            }
        });

    } // onCreate 종료 위치

    // Thread 생성하기
    class TimeThread extends Thread{

        TextView view;

        // 생성자 메소드 -> 어떤 view가 선택됐는지 초기화 작업
        public  TimeThread(TextView view){
            this.view = view;
        }

        @Override
        public void run() {

            for(int i = 0; i <= 20; i++){
                try {
                    Thread.sleep(1000);

                    // 1. 값을 메인 화면으로 전달할 수 있는 메세지 객체 생성 -> Handler에서 사용이 가능
                    // 정수형 / 객체형
                    Message msg = new Message();
                    msg.arg1 = i;
                    msg.obj = view; // 선택된 뷰를 메세지에 담아 전달

                    handler.sendMessage(msg);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    // Handler 생성하기
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            int i = msg.arg1;
            TextView txt = (TextView) msg.obj; // 오브젝트를 꺼내올 때는 다운캐스팅이 필요하다

            txt.setText(i + "");
        }
    };


}