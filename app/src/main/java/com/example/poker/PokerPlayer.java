package com.example.poker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.Timer;

public class PokerPlayer extends AppCompatActivity {

    LinearLayout toolbar;
    int mOriginalHeight;
    boolean initialSizeObtained = false;
    int currentHeight;
    boolean isShrink = false;
    Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokerplayer);



    }
}