package com.example.poker;

public class PlayerViewModel {

    String playername;
    String earn;
    String desc;
    int image;

    public PlayerViewModel(String name, String description,String earn,int image) {
        this.playername = name;
        this.desc = description;
        this.earn = earn;
      this.image = image;
    }

    public String getEarn() {
        return earn;
    }

    public void setEarn(String earn) {
        this.earn = earn;
    }

    public String getName() {
        return playername;
    }

    public void setName(String name) {
        this.playername = name;
    }

    public String getDescription() {
        return desc;
    }

    public void setDescription(String description) {
        this.desc = description;
    }

        public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
