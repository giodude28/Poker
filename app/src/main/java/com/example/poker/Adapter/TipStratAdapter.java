package com.example.poker.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poker.PlayerDetail;
import com.example.poker.PlayerViewModel;
import com.example.poker.Players;
import com.example.poker.R;
import com.example.poker.Tips;
import com.example.poker.TipsStratDetails;
import com.example.poker.TipsStratViewModel;

import java.util.List;

public class TipStratAdapter extends RecyclerView.Adapter<TipStratAdapter.ViewHolder> {
    List<TipsStratViewModel> data;
    Context context;
    TextView awd,aa;
    ImageView img;
    public TipStratAdapter(Context context,List<TipsStratViewModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public TipStratAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.tipsstratitem, parent, false);
        TipStratAdapter.ViewHolder viewHolder = new TipStratAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final TipStratAdapter.ViewHolder holder, final int position) {
        holder.tn.setText(data.get(position).getName());
        holder.td.setText(data.get(position).getDescription());
//        holder.earn.setText(data.get(position).getEarn());
//        holder.img.setImageResource(data.get(position).getImage());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                for (int i = 0; i<data.size(); i++) {
//                    if(holder.tn.getText()==data.get(position).getName()){
//                        Intent soc = new Intent(context, TipsStratDetails.class);
//                        Tips.title = data.get(position).getName();
//                        Tips.description = data.get(position).getDescription();
////                        Players.pearn = data.get(position).getEarn();
////                        Players.img = data.get(position).getImage();
//                        soc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(soc);
//                    }
//                }
//            }
//        });
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_tips_strat_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        awd = myDialog.findViewById(R.id.title);
        aa = myDialog.findViewById(R.id.tdesc);
        for (int i = 0; i<data.size(); i++) {
                    if(holder.tn.getText()==data.get(position).getName()){
//                        Cards.cardname = data.get(position).getName();
//                        Cards.carddesc = data.get(position).getDescription();
                        awd.setText(data.get(position).getName());
                        aa.setText(data.get(position).getDescription());
                }
                }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                myDialog.show();

            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tn;
    public TextView cdesc;
        public TextView td;
//        public ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            img = itemView.findViewById(R.id.img1);
            tn = itemView.findViewById(R.id.tname);
            td = itemView.findViewById(R.id.tdesc);
//            cdesc = itemView.findViewById(R.id.desc);
        }
    }
}

