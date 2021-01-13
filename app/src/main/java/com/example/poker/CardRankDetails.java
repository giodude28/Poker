package com.example.poker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class CardRankDetails extends AppCompatActivity {
TextView tt,dd;
ImageView imahe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_rank_details);
//
//        tt = findViewById(R.id.title1);
//        dd = findViewById(R.id.desc1);
//        imahe = findViewById(R.id.cardimg);
//
////        String description = getIntent().getExtras().getString("description");
////        String namae = getIntent().getExtras().getString("name");
//
//        tt.setText(Cards.cardname);
//        dd.setText(Cards.carddesc);
//        Picasso.get().load(Cards.img).into(imahe);
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//              //  loadingItems.setVisibility(View.GONE);
//                tt.setVisibility(View.VISIBLE);
//                dd.setVisibility(View.VISIBLE);
//            }
//        }, 2500);
    }
    @Override
    public void onBackPressed(){
        Intent in = new Intent(this, MainActivity.class);
        finish();
        startActivity(in);
    }
        }
