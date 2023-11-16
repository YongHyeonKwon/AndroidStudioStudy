package com.example.ex_adapter;

public class InfoVO {

    // 이미지, 이름, 상태메세지

    private int img;
    private String name;
    private String msg;

    // alt + insert -> 메소드 생성 단축키

    // 생성자 메소드



    public InfoVO(int img, String name, String msg) {
        this.img = img;
        this.name = name;
        this.msg = msg;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
