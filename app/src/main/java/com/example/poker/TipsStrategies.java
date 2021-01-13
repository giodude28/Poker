package com.example.poker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.poker.Adapter.HomeAdapter;
import com.example.poker.Adapter.PlayerAdapter;
import com.example.poker.Adapter.TipStratAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class TipsStrategies extends AppCompatActivity {
    private TipsStratViewModel tipsStratViewModel;
    TipStratAdapter tipStratAdapter;
    public static RecyclerView recyclerView;
    int counter;
    private BottomNavigationView bottomNavigationView;
    String[] tnames={"Learn the Rules,Positions and Poker Hands Ranking","Start at low Stakes to understand Poker Strategy","Find the Best Games","Play tight but Aggressive in Poker","Use Table Position in Poker","Start Playing One Table","Only Play when you feel Lucky or Good",
    "Learn Poker Odds","Think About your Opponents Cards","Take your time","Learn to Fold"};
    String[] tdescription={"Of course, this is the first step you want to take, and most players know this. Although it may be easy to learn general poker rules, you should actually spend some time to understand what poker hand rankings are. You should not be in the middle position, but must consider whether to hit a straight with a flush, and therefore waste precious decision time.",
    "Before entering the game, be sure to consider this poker technique. Many players are not interested in playing low-level games, but you need to make sure that the goal is to learn poker strategy, not to waste money in doing so. Therefore, you have several reasons to start with a low stake:\n" +
            "\n" +
            "-First of all, you will know that you are not risking a lot of money, so even if you lose some money in the beginning, it will not hurt you and you will feel more comfortable. You will be able to learn the game without spending a lot of money on the process, so this is a good idea.\n" +
            "-Secondly, every time you increase your bet, the player's skill level will increase. Starting with the lowest limit, you can play against the weakest players and learn the game instead of donating to those who are in better shape now.\n" +
            "-Finally, it allows you to view the entire picture and feel the appearance of the entire game. You will understand the position, what kind of poker hand should be played, and can practice everything.",
    "This is related to the previous technique, starting with a lower stake, which is a bit related, but finding the best game will help you increase your EV even more.\n" +
            "There is no place for yourself in poker. If you insist on playing better players, you will eventually lose. It's that easy.\n" +
            "Even if you are the 10th player in the world, but you are still competing with nine people who are better than you, sooner or later you will go bankrupt.\n" +
            "To be honest, this is very important for every poker player, no matter how good they are, because it will determine your winning rate.\n" +
            "Most importantly, in a better game, you have less volatility and can raise your bet faster, which in itself is a huge reward.\n" +
            "\n" +
            "If you are not sure how to find the best game, please refer to the following tips:\n" +
            "\n" +
            "\t-Find the best game for your format (some rooms are more suitable for cash games, other rooms are more suitable for MTT)\n" +
            "\t-Research when to find peak traffic and more casual players\n" +
            "\t-Find the best option in your country/region to ensure safety while playing games and to ensure the safety of your funds",
    "Many amateur players make the mistake of playing too wide and opening too much Texas Hold'em.\n" +
            "\n" +
            "At the beginning, the key is to play only the strongest cards to keep the VPIP poker statistics at a low level and avoid making many difficult decisions after the flop. This can reduce your play when you decide to take action, but it will be more positive.\n" +
            "\n" +
            "In low-level games, most opponents often play random hands, and this technique alone can keep you ahead of them. Using this tool, you will be able to learn poker strategies in a more effective way without losing money.\n" +
            "\n" +
            "Therefore, it is important to improve and bet on yourself when playing the game, not just call your opponent to put the most pressure on. Knowing that you have the advantage of holding a better hand before the flop, you will win their range in the long run.",
     "When deciding to play Texas Hold'em, your location will be one of the most important factors to consider. You will win more money from future positions, so try to start more games from there.",
    "I don’t sweat how important this poker tip is! Your goal is to learn poker strategy and focus on viewing all the information. Therefore, keep multi-table meetings in the future, stick to one table, and try to absorb all available information.\n" +
            "\n" +
            "Look at how your opponents play and the opponents in the duel. As we said, focusing on using your position and adopting a harsh and aggressive attitude can get you a long way.",
    "Emotions are your enemy at the poker table. To be sure, you will start to feel angry or sad when you lose while playing the game, and you need to deal with this, but don’t start the game when you are in a bad mood to make the situation worse.\n" +
            "\n" +
            "When we feel tired, angry or even drunk, we are all doing stupid things, which may cost us a lot of money. Avoid starting the game when you are in a bad mood. This will be the first step, but to become a better poker player, this is a very important step.",
    "You need to know the poker odds at which you have to hit the winning hand and the pot odds you get. Then, all you have to do is to make decisions based on it, not your emotions.\n" +
            "\n" +
            "What are the pot odds? This is a concept that allows you to understand that you continue to trade at the right price and helps you make the right decision. This is a big concept and we will not go into it in depth, but I will quickly list the most common Texas Hold'em hands for you, and the number of outs of a few special players you need to improve before the next street:\n" +
            "\n" +
            "\t-Internal shot-4 outs\n" +
            "\t-Two checks-6 cards\n" +
            "\t-Open Draw – 8 innings\n" +
            "\t-Straight Flush – 9 outs\n" +
            "\t-Lottery and direct hits – 12 out\n" +
            "\t-Straight Flush Draw – 15 outs",
    "When you know that the probability is high, you will improve your poker hand in a tie and you must learn to put your opponent within range. This will allow you to understand how many times you have actually been out, and then make a more informed decision. Many factors can give hints as to what hands the opponent may be playing. This is a very difficult and advanced topic, but you can start with a simple version.\n" +
            "\n" +
            "\t-Think about his position, what cards he can open and play from there;\n" +
            "\t-His post-flop actions can hint at what he might have. Placing or placing a bet may indicate his strength or weakness, you should look for this information;\n" +
            "\t-The texture of the board is also an important factor to consider. Compared with connected boards, people are unlikely to have many strengths on dry boards;\n" +
            "\t-He took the time to make decisions and the size to use can also provide us with more information.",
    "Don't get into the habit of making decisions automatically. Even advanced players spend a lot of time wasting all their winning opportunities, which is a huge mistake. Take a moment to think about everything we have discussed.\n" +
            "\n" +
            "Especially at the beginning, all issues may be taken into consideration immediately, such as your position, poker hand ranking, opponent's cards and so on. This is why you should stick to the poker technique of playing only one table and spend all your time making decisions.\n",
    "You need to seriously consider this poker technique. When your passive opponent that you have been calling all the time suddenly rises, you should bend down a lot, and even have some strong hands. In most cases, a pair of cards is even as good as a top card or super card.\n" +
            "\n" +
            "When you first start playing, letting go of these hands will encounter some problems, but if you want to succeed, this is one thing. Players at the lowest level of the game will not be bluffing, and in the long run, you will provide a huge help to yourself by folding a pair of hands to attack in these positions.\n" +
            "\n" +
            "Not all opponents are passive opponents. If you are fighting against a madman or someone who is very aggressive and constantly improving, then you should not fold. You need to understand that there are different types of players, and you really need to fight them. The last part of my poker tips list will help you solve this problem."};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_strategies);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.strat);
        initialize();
        navBottom();

    }

    private void initialize(){
        List<TipsStratViewModel> awit = new ArrayList<>();
        for(int i = 0; i < tnames.length; i ++ ){
            awit.add(new TipsStratViewModel(tnames[i],tdescription[i]));
        }

        recyclerView =findViewById(R.id.recyclerViewPlay);
        recyclerView.setLayoutManager(new LinearLayoutManager(TipsStrategies.this));
        tipStratAdapter = new TipStratAdapter(TipsStrategies.this,awit);
        recyclerView.setAdapter(tipStratAdapter);
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
                    case R.id.strat:

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