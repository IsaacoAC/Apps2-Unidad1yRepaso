package com.example.eva1_11_clima;

public class Wheater {

    /* Ciudad String
     * Temp int
     * Descripcion String
     * Imagen int */

    private String City;
    private int Temp;
    private String desc;
    private int image;

    public Wheater(){
        City = "";
        Temp = 0;
        this.desc = "";
        this.image = -1;
    }

    public Wheater(String city, int temp, String desc, int image) {
        City = city;
        Temp = temp;
        this.desc = desc;
        this.image = image;
    }

    public String getCity() {
        return City;
    }

    public int getTemp() {
        return Temp;
    }

    public String getDesc() {
        return desc;
    }

    public int getImage() {
        return image;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setTemp(int temp) {
        Temp = temp;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setImage(int image) {
        this.image = image;
    }
}



