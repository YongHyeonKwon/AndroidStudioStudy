package com.example.ex_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
// BaseAdapter 상속 받아서 나만의 Adapter 생성!

    // Adapter용의 생성자 메소드 생성!

    private Context context;

    private int layout;
    private ArrayList<InfoVO> dataset;

    public  MyAdapter(Context context, int layout, ArrayList<InfoVO> dataset){
        this.context = context;
        this.layout = layout;
        this.dataset = dataset;
    }

    @Override
    public int getCount() {
        // 사용자가 사용하고자 하는 데이터의 개수를 반환해주는 메소드
        return dataset.size();
    }

    @Override
    public Object getItem(int position) {
        // 특정 Item의 위치를 반환하는 메소드
        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {
        // 특정 Item의 Id를 반환하는 메소드 
        return 0;
    }

    // Adapter 생성시 가장 중요한 필수! 메소드
    // ListView에 들어가는 Item의 내용을 초기화(view의 위치, 데이터 추가)
    // 하고 화면에 보이도록 세팅하는 메소드)
    // +) 화면과 데이터들을 실제로 연결해주는 기능 -> setAdapter()
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 눈에 보이는 디자인을 xml 코드로 변형하는 과정!
        // -> 해당 과정은 데이터가 새롭게 추가될 때 마다 작업이 진행
        // 기본 틀이라고 볼 수 있는 화면이 계속해서 새롭게 메모리 적재가 된다면 어플리케이션이 너무 무거워진다.

        if(convertView == null) { // 화면을 xml 코드로 변환한 적이 있는지 판단!
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list, parent, false);
        }

        // 셋팅된 xml 파일로부터 쓰고자 하는 view의 위치를 찾아오는 기능
        ImageView img = convertView.findViewById(R.id.img);
        TextView tvName = convertView.findViewById(R.id.tvName);
        TextView tvTitle = convertView.findViewById(R.id.tvTitle);

        // 찾아온 위치에 띄우고 싶은 데이터 띄워주기
        img.setImageResource(dataset.get(position).getImg());
        tvName.setText(dataset.get(position).getName());
        tvTitle.setText(dataset.get(position).getMsg());

        return convertView;

    }


}
