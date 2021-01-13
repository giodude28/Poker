package com.example.poker;

public class HomeViewModel {

    String rulename;
    String description;
   int image;

    public HomeViewModel(String name, String description,int image) {
        this.rulename = name;
        this.description = description;
        this.image = image;
    }

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
