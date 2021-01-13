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
import com.example.poker.Adapter.PlayerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;



public class PlayerList extends AppCompatActivity {

    private PlayerViewModel playerViewModel;
    private BottomNavigationView bottomNavigationView;
    PlayerAdapter playerAdapter;
    public static RecyclerView recyclerView;
int counter;
    String[] playername={"Dan Bilzerian","Phil Ivey","Sam Farha","Chris Ferguson","Doyle Brunson","Bryn Kenney","Daniel Negreanu","Justin Bonomo","Tony G","Antonio Esfandiari"};
    String[] earnings={"$200 Million","$100+ Million","$100 Million","$80 Million","$75 Million","$56 Million","$50 Million","$49 Million","$36 Million","$27 Million"};
    String[] playerdesc={"Many are dubious of this claim though, as he received an unknown sum of money from a trust fund, plus has many business ventures, as well as a highly lucrative social media presence.Bilzerian has made some big claims about his poker playing abilities, including that he made $50 million from poker in 2014 alone.He has never won a major tournament, instead claiming that his money comes from cash games only. The social media sensation has also been arrested on various occasions.Regardless of how he got his money though, hes still the richest poker player in the world by far.If you are interested in playing poker, check out our online poker guide.",
            "Many consider Phil Ivey to be one of the greatest players of all time. The American has managed to win 10 WSOP bracelets – only Phil Hellmuth has more.He has also appeared at the final table of the Main Event, finishing 7th in 2009. He has won one WPT title, plus has reached nine final tables.Ivey has won numerous large prizes at tournaments, including AU$4 million for coming first at the 2014 Aussie Millions LK Boutique AU$250,000 Challenge.Ivey is also a successful online player, plus he’s a superb high-stakes cash game player, once winning $16 million in three days playing against Texan billionaire Andy Beal.",
            "Most players will recognize Sam Farha as the man who lost to Chris Moneymaker in the 2003 Main Event. The Lebanese poker player has bagged three WSOP bracelets over the years and although he does play tournaments, he’s better known as a high-stakes Omaha cash game player.Farha’s biggest tournament win, aside from his prize for finishing second at the WSOP Main Event, is $488,241, which he won when finishing first at the 2010 WSOP $10,000 Omaha Hi-Low Split-8 or Better Championship.His wealth also comes from several business interests, TV and movie appearances, and writing books.",
            "It would be fair to say that Chris Ferguson is not the most popular man in poker.He was accused of being one of the people behind a massive Ponzi scheme at Full Tilt Poker, which stole around $444 million from players.Even though he later came out with an apology, it was considered too little, too late by many.Despite his shady behaviour he is still a great player, having won the WSOP Main Event in 2000 in which he scooped a $1.5 million prize.Overall, he has earned nearly $7 million throughout his career in live tournament winnings, with a large percentage of this figure coming from his 90 money finishes at the WSOP.",
            "Doyle Brunson is known as one of the greatest names in poker history.Throughout his career, he won 10 WSOP bracelets and won the Main Event twice, in 1976 and 1977.The retiree also regularly played cash games at Bobby’s Room at the Bellagio, including a limit mixed poker game with $4,000/$8,000 blinds.Overall, Brunson has earned over $6.1 million from live tournament winnings. How much he earned while playing high stakes cash games is unknown.He's also earned money from various other sources, including his book Super System, which is regarded as one of the best poker strategy books ever written.",
            "Bryn Kenney is an American player and perhaps one of the lesser known names on this list.He has only won one WSOP bracelet, however he has finished in the money 32 times. He is number one on the list of the players with the highest tournament earnings ever, with winnings of over $55 million.Kenney is perhaps best-known for winning the highest prize ever awarded at a poker tournament. He won over $20.5 million at the 2019 Triton Million charity event in London.He actually came second, however he made a deal with eventual winner Aaron Zang when he was the chip leader, allowing him to win the larger prize.",
            "Daniel Negreanu is the most famous poker player of all time. His personality has made him a huge hit with fans, and his skill has ensured he’s one of the richest poker players around.\"Kid Poker” has six WSOP bracelets and is the only player to be named WSOP Player of the Year twice. He’s also a member of the Poker Hall of Fame.Overall, Negreanu has won nearly $42 million in tournament prize money and has earned a considerable sum from sponsorship deals, with the biggest seeing him become the face of PokerStars.Negreanu and PokerStars parted ways in 2019 though and he’s now an ambassador for GGPoker, which leaves many wondering which is the best poker room of the two. Check out our PS v GGPoker review to find out!",
            "Next up, we come to Justin Bonomo, who has found huge success in both live and online tournaments.He’s a three-time WSOP bracelet winner and has cashed 55 times at the event. He has also won many large online events, including the Super High Roller Bowl Online in 2020.Bonomo’s biggest ever win came when he won the “Big One for One Drop” tournament in 2018, which added $10 million to his bank account and made him the number one all-time live tournament money winner, until his total was surpassed by Bryn Kenney.",
            "Tony G – real name Antanas Guoga – is one of the loudest, most outspoken poker players around.He’s also a politician in the European Parliament, as well as a successful businessman. He’s never won a WSOP bracelet, however he has finished in the money 15 times.During his poker career, Tony G has won several six-figure prizes. Most of his wealth comes from his business activities though.He is the chief executive officer of Cypherpunk Holdings, an investment company listed on the Canadian Securities Exchange.",
            "At number 10 on this list of the richest poker players is Antonio Esfandiari, one of the best-known players on the poker circuit.The former magician managed to win three World Series of Poker bracelets throughout his career, plus he’s won three WPT titles, with the first coming in 2004 at the L.A. Poker Classic.Esfandiari’s biggest ever win came in 2012, when he won the “Big One for One Drop” tournament at the WSOP. This saw him win a massive $18,346,673 – at the time, the largest ever live poker prize. At one point, he had earned more via tournament winnings than anyone else, until his title was taken by Daniel Negreanu."};
    Integer[] image={R.drawable.dan_bilzerian,R.drawable.philivey,R.drawable.samfarha,R.drawable.chris_ferguson,R.drawable.doylebrunson,R.drawable.brynkenney,R.drawable.danielnegreanu,R.drawable.justinebonomo,R.drawable.tony_g,R.drawable.antonioesfandiari};
//View root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.player);
        initialize();
        navBottom();
    }
    private void initialize(){
        List<PlayerViewModel> awit = new ArrayList<>();
        for(int i = 0; i < playername.length; i ++ ){
            awit.add(new PlayerViewModel(playername[i],playerdesc[i],earnings[i],image[i]));
        }

        recyclerView =findViewById(R.id.recyclerViewPlay);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        playerAdapter = new PlayerAdapter(getApplicationContext(),awit);
        recyclerView.setAdapter(playerAdapter);

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
                    case R.id.card:
                        Intent stad =  new Intent(getApplicationContext(), MainActivity.class);
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
                    case R.id.player:
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