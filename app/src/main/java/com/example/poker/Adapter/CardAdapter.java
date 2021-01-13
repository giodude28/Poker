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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.poker.CardRankDetails;
import com.example.poker.Cards;
import com.example.poker.DashboardViewModel;
import com.example.poker.MainActivity;
import com.example.poker.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    List<DashboardViewModel> data;
    Context context;
    TextView name,desc;
    ImageView img,imahe;
    Dialog myDialog;
    public CardAdapter(Context context,List<DashboardViewModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.cname.setText(data.get(position).getName());
        holder.cdesc.setText(data.get(position).getDescription());
        Picasso.get().load(data.get(position).getImage()).into(holder.img);
        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_card_rank_details);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        name = myDialog.findViewById(R.id.title1);
        desc = myDialog.findViewById(R.id.desc1);
        imahe = myDialog.findViewById(R.id.cardimg);
        for (int i = 0; i<data.size(); i++) {
            if(holder.cname.getText()==data.get(position).getName()){
//                        Cards.cardname = data.get(position).getName();
//                        Cards.carddesc = data.get(position).getDescription();
                name.setText(data.get(position).getName());
                desc.setText(data.get(position).getDescription());
                Picasso.get().load(data.get(position).getImage()).into(imahe);
            }
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                myDialog.show();

            }
        });
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //        myDialog = new Dialog(context);
////        myDialog.setContentView(R.layout.activity_card_rank_details);
////        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////        name = myDialog.findViewById(R.id.title1);
////        desc = myDialog.findViewById(R.id.desc1);
//                for (int i = 0; i<data.size(); i++) {
//                    if(holder.cname.getText()==data.get(position).getName()){
//                        Intent soc = new Intent(context, CardRankDetails.class);
//                        Cards.cardname = data.get(position).getName();
//                        Cards.carddesc = data.get(position).getDescription();
//                        Cards.img = data.get(position).getImage();
//                        soc.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                        context.startActivity(soc);
//                }
//                }
//            }
//        });
      // MainActivity.recyclerView.scrollToPosition(position);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent mIntent = new Intent(context, CardRankDetails.class);
//                mIntent.putExtra("name", data.get(position).getName());
//                mIntent.putExtra("description", data.get(position).getDescription());
//                context.startActivity(mIntent);
//
//                MainActivity.recyclerView.scrollToPosition(position);
//            }
//        });

//        myDialog = new Dialog(context);
//        myDialog.setContentView(R.layout.activity_card_rank_details);
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        name = myDialog.findViewById(R.id.title1);
//        desc = myDialog.findViewById(R.id.desc1);
//                        for (int i = 0; i<data.size(); i++) {
//                    if(holder.cname.getText()==data.get(position).getName()){
////                        Cards.cardname = data.get(position).getName();
////                        Cards.carddesc = data.get(position).getDescription();
//                        name.setText(data.get(position).getName());
//                        desc.setText(data.get(position).getDescription());
//                }
//                }
//
////        name.setText(data.get(position).getName());
////        desc.setText(data.get(position).getDescription());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //
//                myDialog.show();
//
//            }
//        });
//        Picasso.get().load(data.get(position).get()).into(imey, new Callback() {
//            @Override
//            public void onSuccess() {
//                holder.progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                holder.eimg.setImageResource(R.drawable.ic_launcher_background);
//                holder.progressBar.setVisibility(View.GONE);
//
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

    public TextView cname;
    public TextView cdesc;
    public  ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           img = itemView.findViewById(R.id.img1);
            cname = itemView.findViewById(R.id.cardname);
            cdesc = itemView.findViewById(R.id.carddesc);
        }
    }
}
