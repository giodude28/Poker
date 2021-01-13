package com.example.poker.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poker.CardRankDetails;
import com.example.poker.Cards;
import com.example.poker.DashboardViewModel;
import com.example.poker.MainActivity;
import com.example.poker.PlayerDetail;
import com.example.poker.PlayerPosition;
import com.example.poker.PlayerViewModel;
import com.example.poker.Players;
import com.example.poker.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.ViewHolder> {
    List<PlayerViewModel> data;
    Context context;
    TextView name,desc,earn;
    ImageView image1;


    public PlayerAdapter(Context context,List<PlayerViewModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.playeritem, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.cname.setText(data.get(position).getName());
        holder.earn.setText(data.get(position).getEarn());
        holder.image.setImageResource(data.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i<data.size(); i++) {
                    if(holder.cname.getText()==data.get(position).getName()){
                        Intent soc = new Intent(context, PlayerDetail.class);
                        Players.pname = data.get(position).getName();
                        Players.pdesc = data.get(position).getDescription();
                        Players.pearn = data.get(position).getEarn();
                        Players.img = data.get(position).getImage();
                        soc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(soc);
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView cname;
        public TextView cdesc;
    public TextView earn;
    public ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           image = itemView.findViewById(R.id.img1);
            earn = itemView.findViewById(R.id.playerearn);
            cname = itemView.findViewById(R.id.playername);
            cdesc = itemView.findViewById(R.id.desc);
        }
    }
}
