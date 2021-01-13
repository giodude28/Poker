package com.example.poker;

public class TipsStratViewModel {

    String tname;
//    String earn;
    String tdesc;
//    int image;

    public TipsStratViewModel(String name, String description) {
        this.tname = name;
        this.tdesc = description;
//        this.earn = earn;
//      this.image = image;
    }

//    public String getEarn() {
//        return earn;
//    }
//
//    public void setEarn(String earn) {
//        this.earn = earn;
//    }

    public String getName() {
        return tname;
    }

    public void setName(String name) {
        this.tname = name;
    }

    public String getDescription() {
        return tdesc;
    }

    public void setDescription(String description) {
        this.tdesc = description;
    }

//        public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }
}
