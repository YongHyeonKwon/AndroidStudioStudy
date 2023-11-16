package com.example.ex_adapter;

public class ProductVO {

    private int imgPro;
    private String titlePro;
    private String numPro;

    // 생성자 메소드

    public ProductVO(int imgPro, String titlePro, String  numPro) {
        this.imgPro = imgPro;
        this.titlePro = titlePro;
        this.numPro = numPro;
    }

    public int getImgPro() {

        return imgPro;
    }

    public void setImgPro(int imgPro) {

        this.imgPro = imgPro;
    }

    public String getTitlePro() {

        return titlePro;
    }

    public void setTitlePro(String titlePro) {

        this.titlePro = titlePro;
    }

    public String  getNumPro() {

        return numPro;
    }

    public void setNumPro(String  numPro) {

        this.numPro = numPro;
    }

    // Getter/Setter 메소드



}
