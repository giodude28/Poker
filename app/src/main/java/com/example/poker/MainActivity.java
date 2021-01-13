package com.example.poker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.poker.Adapter.CardAdapter;

import java.util.ArrayList;
import java.util.List;
import com.example.poker.DashboardViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

private DashboardViewModel dashboardViewModel;
    private BottomNavigationView bottomNavigationView;
    CardAdapter cardAdapter;
public static RecyclerView recyclerView;
int counter;
String[] name={"High Card","One Pair","Two Pair","Three of a kind","Straight","Flush","FullHouse","Four of a kind","Straight Flush","Royal Flush"};
String[] desc={"If the combination cannot be made, the player's hand will be considered the highest single card. If two players have the same high card, the second highest card will break the tie.",
        "When you have two identical cards, a pair is formed.",
        "When more than one player has two pairs, the highest player wins.",
        "When you have three identical cards. a Three of a kind is formed.",
        "Straight refers to five cards, consisting of several consecutive cards, and has nothing to do with suits. If two players have straights, the higher hand straight wins.",
        "When you have three identical cards. a Three of a kind is formed.",
        "When a player has three different types and a pair in the same hand, it is called Full House.",
        "When you have a four identical cards at the same time. Four of a kind is formed.",
        "It is rarer than four cards of the same type. A straight flush card consists of five consecutive cards, all from the same deck.",
        "The best of all of these is this famous combination, which is formed by straight flushes that pass through A, so it is unparalleled. The odds for this hand may be as high as 1 in 650,000 trades."};
Integer[] imahe={R.drawable.high,R.drawable.onepair,R.drawable.two,R.drawable.trio,R.drawable.straight,R.drawable.flush,R.drawable.fullhouse,R.drawable.four,R.drawable.straightflush,R.drawable.royalflush};
//View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.card);
        initialize();
        navBottom();
    }
    private void initialize(){
       List<DashboardViewModel> awit = new ArrayList<>();
        for(int i = 0; i < name.length; i ++ ){
            awit.add(new DashboardViewModel(name[i],desc[i],imahe[i]));
        }

        recyclerView =findViewById(R.id.recyclerViewDashboard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardAdapter = new CardAdapter(MainActivity.this,awit);
        recyclerView.setAdapter(cardAdapter);
    }

    private void navBottom()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        Intent vid = new Intent(getApplicationContext(), Mainhome.class);
                        startActivity(vid);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.player:
                        Intent stad =  new Intent(getApplicationContext(), PlayerList.class);
                        startActivity(stad);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.strat:
                        Intent awd =  new Intent(getApplicationContext(), TipsStrategies.class);
                        startActivity(awd);
                        overridePendingTransition(0,0);
                        finish();
                        break;
                    case R.id.Guides:
                        Intent aaa =  new Intent(getApplicationContext(), GuideList.class);
                        startActivity(aaa);
                        overridePendingTransition(0,0);
                        finish();
                        break;
//                        case R.id.linkss:
//                            Intent soc = new Intent(getApplicationContext(), linktab.class);
//                            startActivity(soc);
//                            overridePendingTransition(0,0);
//                            break;
                    case R.id.card:
                        return true;
                }
                return true;
            }
        });
    }


    @Override
    public void onBackPressed() {
        if (counter == 0) {
            counter = 1;
            Toast.makeText(this, "Press Again To Exit.", Toast.LENGTH_SHORT).show();
        } else {
            finish();
        }
    }
}