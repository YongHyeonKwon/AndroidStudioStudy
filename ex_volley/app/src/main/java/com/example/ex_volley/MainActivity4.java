package com.example.ex_volley;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.ex_volley.databinding.ActivityMain4Binding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    StringRequest request;
    ActivityMain4Binding binding;

    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MovieVO> dataset = new ArrayList<MovieVO>();

        // 네트워크 통신을 위한 초기화 작업
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        // 사용할 어댑터 연결 해주기
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.movie_item, dataset);

        // 버튼이 눌렸을 때 통신이 시작되도록 연결!
        binding.btnReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request = new StringRequest(
                        Request.Method.GET,
                        "https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20231109",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                // 통신 성공시 처리할 로직 작성!
                                // Log.d("response", response);

                                // string 형태로 넘어오는 결과값을 JSON 타입으로 가져오기!
                                try {
                                    JSONObject json = new JSONObject(response);

                                    JSONObject json2 = json.getJSONObject("boxOfficeResult");

                                    JSONArray movies = json2.getJSONArray("dailyBoxOfficeList");

                                    // movies 담겨 있는 영화 데이터를 하나씩 dataset에 저장!
                                    for(int i =0; i< movies.length(); i++){
                                        JSONObject movie = (JSONObject) movies.get(i);

                                        String rank = movie.getString("rank");
                                        String oldNew = movie.getString("rankOldAndNew");
                                        String movieTitle = movie.getString("movieNm");
                                        String open = movie.getString("openDt");
                                        String count = movie.getString("audiCnt");

                                        dataset.add(new MovieVO(rank, count, oldNew, movieTitle, open));
                                    }

                                    // 데이터에 대한 최종 내용을 한 번만 갱신해서 정리하는 기능
                                    adapter.notifyDataSetChanged();
                                    // 원하는 listView 위치에 adapter 연결
                                    binding.listView.setAdapter(adapter);

                                } catch (JSONException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error+"",Toast.LENGTH_SHORT).show();
                    }
                }

                );
                // requestQueue에 작업에 대한 내용 전달하기
                requestQueue.add(request);
            }
        });


    }
}