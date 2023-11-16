package com.example.ex_event;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.ex_event.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    ActivityMain3Binding binding;

    // 3. 익명 클래스를 사용하는 이벤트 연결
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 1. 버튼이 눌리는 것을 감지!
        // 2. 입력되는 창에 입력된 내용을 가지고 오기!
        // 3. 가지고 온 텍스트 값을 TextView에 띄우기

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 2. 입력되는 창에 입력된 내용을 가지고 오기!
                String msg1 = String.valueOf(binding.edtMsg.getText());
                // String msg2 = binding.edtMsg.getText()+"";

                // 3. 가지고온 텍스트 값을 TextView에 띄우기!
                binding.tvTitle.setText(msg1);

                // 4. 수정한 내용을 사용한 이후 tvTitle 초기화 하기
                binding.edtMsg.setText("");
            }
        });

        // 키보드 이벤트 연결하기 -> enter 눌렀을 때 이벤트 진행
        binding.edtMsg.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

                if (keyCode == keyEvent.KEYCODE_ENTER) {
                    // 엔터키가 눌림을 감지 할 수 있는 코드!

                    String msg1 = String.valueOf(binding.edtMsg.getText());
                    // String msg2 = binding.edtMsg.getText()+"";

                    // 3. 가지고온 텍스트 값을 TextView에 띄우기!
                    binding.tvTitle.setText(msg1);

                    // 4. 수정한 내용을 사용한 이후 tvTitle 초기화 하기
                    binding.edtMsg.setText("");

                    return true;
                }
                // 리스너에 대한 이벤트를 다음 리스터에게 전달할 것인지 여부 결정하는 키워드!
                // ture : 다음 리스너에 이벤트 전달 X
                // false : 다음 리스너에 이벤트 전달 허용

                return false;

            }
        });


    }
}