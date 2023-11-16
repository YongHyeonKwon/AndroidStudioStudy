package com.example.ex_adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ProAdapter extends BaseAdapter {

    Context context;

    int layout;
    ArrayList<ProductVO> dataset;

    // 어댑터용 생성자 메소드 필요!
    public ProAdapter(Context context, int layout, ArrayList<ProductVO> dataset){
        this.context = context;
        this.layout = layout;
        this.dataset = dataset;
    }

    @Override
    public int getCount() {

        return dataset.size();
    }

    @Override
    public Object getItem(int position) {

        return dataset.get(position);
    }

    @Override
    public long getItemId(int position) {

        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // 1. view 그릇이 될 수 있는 레이아웃 작업!
        if(convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        }

        // 2. view 위치 값 찾기
        ImageView Imgpro = convertView.findViewById(R.id.imgPro);
        TextView titlePro = convertView.findViewById(R.id.titlePro);
        TextView numpro = convertView.findViewById(R.id.numPro);
        Button btn = convertView.findViewById(R.id.btn);

        // 3. 찾아온 view 위치에 데이터 연결하기
        Imgpro.setImageResource(dataset.get(position).getImgPro());
        titlePro.setText(dataset.get(position).getTitlePro());
        numpro.setText(dataset.get(position).getNumPro());

        // 4. 버튼은 이벤트가 연결될 수 있도록 작업!
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // SubActivity화면으로 전환하는 Intent 생성!
                Intent intent = new Intent(context, SubActivity4.class);

                // 선택된 상품의 이미지와
                intent.putExtra("data1", dataset.get(position).getTitlePro());

                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), dataset.get(position).getImgPro());
                intent.putExtra("data2", bitmap);

                intent.addFlags(intent.FLAG_ACTIVITY_NEW_TASK);

                context.startActivity(intent);
            }
        });

        return convertView;
    }
}
