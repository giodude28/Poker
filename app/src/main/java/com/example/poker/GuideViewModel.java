package com.example.poker;

public class GuideViewModel {

    String guidename;
    String description;
//   int image;
//,int image
    public GuideViewModel(String name, String description) {
        this.guidename = name;
        this.description = description;
//        this.image = image;
    }

    public String getGuidename() {
        return guidename;
    }

    public void setGuidename(String guidename) {
        this.guidename = guidename;
    }

//    public int getImage() {
//        return image;
//    }
//
//    public void setImage(int image) {
//        this.image = image;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
