package com.example.poker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class PlayerDetail extends AppCompatActivity {
    TextView pn,pd,pe;
    ImageView pimg;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);
        getSupportActionBar().setTitle("Player Details");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        pn = findViewById(R.id.pname);
        pd = findViewById(R.id.pdesc);
        pe = findViewById(R.id.earn);
        pimg = findViewById(R.id.img);



        pn.setText(Players.pname);
        pd.setText(Players.pdesc);
        pe.setText(Players.pearn);
       // pimg.setInt(Players.img);
        Picasso.get().load(Players.img).into(pimg);
    }
    @Override
    public void onBackPressed(){
        Intent in = new Intent(this, PlayerList.class);
        finish();
        startActivity(in);
    }
}
