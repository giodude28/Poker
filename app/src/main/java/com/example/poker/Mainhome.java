package com.example.poker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.poker.Adapter.CardAdapter;
import com.example.poker.Adapter.HomeAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

import java.util.ArrayList;
import java.util.List;

public class Mainhome extends AppCompatActivity {
    private HomeViewModel homeViewModel;

    HomeAdapter homeAdapter;
int counter;
    private CarouselView carousel;
    public List<Integer> llvpics = new ArrayList<>();
    public static RecyclerView recyclerView;
    private BottomNavigationView bottomNavigationView;
    String[] rules={"RAISE","FOLD","CALL","CHECK","OPENING"};
    String[] desc={"A raise is to increase the size of an existing bet in the same betting round. Players who make the second round (not counting open numbers) or raise subsequently will re-raise. Players who have previously raised in the same round of betting are called raises",
    "To fold is to fold and lose interest in the current pot. The folded player does not need to place further bets, but the player cannot win. You can express the crease verbally, you can throw your hands down into other waste piles called feces, or you can put it in a pot",
    "To call is to match a bet or match a raise. When all active players bet equal or everyone folds or raises, the betting round ends. If no opponent bets or raises, the player wins the pot.",
    "If no one has opened the betting round, the player can pass or check, which is equivalent to betting zero and/or calling the current betting zero. At the time of the check, the player refused to bet; this means that they do not want to open, but want to keep their cards and reserve the right to call or raise later in the same round of the opponent's opening. In a game played with Blinds, since Blinds are live betting and must be summoned or raised to stay in their hands, players may not be able to check the opening round.",
    "The action of making the first voluntary bet in the betting round is called starting the next round. In the first betting round, it is also called opening the pot, although in a variation of the common blinds, the blinds \"open\" the first betting round, and other players bet and/or raise The \"big blind\" places a bet."};
   Integer[] image={R.drawable.raise,R.drawable.fold,R.drawable.call,R.drawable.check,R.drawable.open};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainhome);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.home);
        carousel = findViewById(R.id.frontimg);
        initialize();
        navBottom();

    }
    //,image[i]
    private void initialize(){
        List<HomeViewModel> awit = new ArrayList<>();
        for(int i = 0; i < rules.length; i ++ ){
            awit.add(new HomeViewModel(rules[i],desc[i],image[i]));
        }

        recyclerView =findViewById(R.id.recyclerViewDashboard);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1,RecyclerView.HORIZONTAL,false));
        SnapHelper pagerSnapHelper = new PagerSnapHelper();
        pagerSnapHelper.attachToRecyclerView(recyclerView);
        homeAdapter = new HomeAdapter(Mainhome.this,awit);
        recyclerView.setAdapter(homeAdapter);
        showPics();
    }

    private void navBottom()
    {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.strat:
                        Intent vid = new Intent(getApplicationContext(), TipsStrategies.class);
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
                    case R.id.card:
                        Intent awd =  new Intent(getApplicationContext(), MainActivity.class);
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
                    case R.id.home:

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
    public void showPics() {
        llvpics.add(R.drawable.high);
        llvpics.add(R.drawable.onepair);
        llvpics.add(R.drawable.two);
        llvpics.add(R.drawable.trio);
        llvpics.add(R.drawable.four);
        llvpics.add(R.drawable.fullhouse);
        llvpics.add(R.drawable.straight);
        llvpics.add(R.drawable.flush);
        llvpics.add(R.drawable.straightflush);
        llvpics.add(R.drawable.royalflush);
        carousel.setImageListener(new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {

                ArrayList<Integer> imageListTitle = new ArrayList<Integer>();

//               /llvpics.addAll(m);
                for(int i = 0; i < llvpics.size(); i++ ){
                    imageListTitle.add(llvpics.get(i));
                }
//                //imageView.setImageResource(imagelist[position]);
                Picasso.get().load(imageListTitle.get(position)).into(imageView);

            }
        });
        carousel.setPageCount(llvpics.size());

    }
}