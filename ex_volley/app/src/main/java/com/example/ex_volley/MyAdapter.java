package com.example.ex_volley;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {

    private Context context;

    private int layout;

    private ArrayList<MovieVO> dataset;

    // 생성자 메소드


    public MyAdapter(Context context, int layout, ArrayList<MovieVO> dataset) {
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

        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        }

        TextView rank = convertView.findViewById(R.id.rank);
        TextView oldNew = convertView.findViewById(R.id.oldNew);
        TextView movieTitle = convertView.findViewById(R.id.movieTitle);
        TextView count = convertView.findViewById(R.id.count);
        TextView open = convertView.findViewById(R.id.open);

        // 데이터셋으로부터 데이터를 꺼내와 view 연결!
        rank.setText(dataset.get(position).getRank());
        oldNew.setText(dataset.get(position).getOldNew());
        movieTitle.setText(dataset.get(position).getMovieTitle());
        count.setText(dataset.get(position).getCount());
        open.setText(dataset.get(position).getOpen());

        return convertView;

    }
}
