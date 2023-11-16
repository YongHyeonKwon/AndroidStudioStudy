package com.example.ex_volley;

public class MovieVO {

    // 영화 정보에 대해 필요한 데이터를 정리하는 클래스
    private  String rank;
    private  String count;

    private  String oldNew;

    private  String movieTitle;

    private  String open;

    public MovieVO(String rank, String count, String oldNew, String movieTitle, String open) {
        this.rank = rank;
        this.count = count;
        this.oldNew = oldNew;
        this.movieTitle = movieTitle;
        this.open = open;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getOldNew() {
        return oldNew;
    }

    public void setOldNew(String oldNew) {
        this.oldNew = oldNew;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
