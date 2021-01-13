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

import com.example.poker.HomeViewModel;
import com.example.poker.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
        List<HomeViewModel> data;
        Context context;
        TextView rn,rd;
        ImageView img;

public HomeAdapter(Context context,List<HomeViewModel> data){
        this.context = context;
        this.data = data;
        }

@NonNull
@Override
public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.homeitem, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
        }

@Override
public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.rules.setText(data.get(position).getRulename());
        holder.desc.setText(data.get(position).getDescription());
      holder.img.setImageResource(data.get(position).getImage());
    final Dialog myDialog;
    myDialog = new Dialog(context);
    myDialog.setContentView(R.layout.activity_home_details);
    myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    rn = myDialog.findViewById(R.id.rname);
    rd = myDialog.findViewById(R.id.rdesc);
    img = myDialog.findViewById(R.id.img);
    for (int i = 0; i<data.size(); i++) {
        if(holder.rules.getText()==data.get(position).getRulename()){
//                        Cards.cardname = data.get(position).getName();
//                        Cards.carddesc = data.get(position).getDescription();
            rn.setText(data.get(position).getRulename());
            rd.setText(data.get(position).getDescription());
            Picasso.get().load(data.get(position).getImage()).into(img);
        }
    }

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //
            myDialog.show();

        }
    });
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
//        final Dialog myDialog;
//        myDialog = new Dialog(context);
//        myDialog.setContentView(R.layout.activity_card_rank_details);
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        name = myDialog.findViewById(R.id.title);
//        desc = myDialog.findViewById(R.id.desc);
//        name.setText(data.get(position).getName());
//        desc.setText(data.get(position).getDescription());
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

    public TextView rules;
    //        public TextView cdesc;
    public TextView desc;
    public ImageView img;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img1);
        desc = itemView.findViewById(R.id.desc);
        rules = itemView.findViewById(R.id.rule);
//            cdesc = itemView.findViewById(R.id.desc);
    }
}
}
