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
import com.example.poker.GuideViewModel;
import com.example.poker.Mainhome;
import com.example.poker.R;

import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.ViewHolder> {
    List<GuideViewModel> data;
    Context context;
    TextView gui,dui;

    public static String asd = "000000000";
//    ImageView img;
   // Dialog myDialog;
    public GuideAdapter(Context context, List<GuideViewModel> data){
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public GuideAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.guideitem, parent, false);
        GuideAdapter.ViewHolder viewHolder = new GuideAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final GuideAdapter.ViewHolder holder, final int position) {
        holder.gname.setText(data.get(position).getGuidename());
        holder.gdesc.setText(data.get(position).getDescription());

        final Dialog myDialog;
        myDialog = new Dialog(context);
        myDialog.setContentView(R.layout.activity_guide_detail);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        gui = myDialog.findViewById(R.id.title12);
        dui = myDialog.findViewById(R.id.tdesc);

        for (int i = 0; i<data.size(); i++) {
            if(holder.gname.getText()==data.get(position).getGuidename()){
                gui.setText(data.get(position).getGuidename());
                dui.setText(data.get(position).getDescription());
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
//            public void onClick(View v) {
//
//                Intent so = new Intent(context, Mainhome.class);
//                context.startActivity(so);
//
//            }
//        });

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                //        myDialog = new Dialog(context);
////        myDialog.setContentView(R.layout.activity_card_rank_details);
////        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
////        name = myDialog.findViewById(R.id.title1);
////        desc = myDialog.findViewById(R.id.desc1);
//                for (int i = 0; i<data.size(); i++) {
//                    if(holder.gname.getText()==data.get(position).getGuidename()){
//                        Intent soc = new Intent(context, CardRankDetails.class);
//                        Cards.cardname = data.get(position).getGuidename();
//                        Cards.carddesc = data.get(position).getDescription();
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

    public TextView gname;
    public TextView gdesc;
public TextView usee;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            img = itemView.findViewById(R.id.img1);
            gname = itemView.findViewById(R.id.guidename);
            gdesc = itemView.findViewById(R.id.guidedesc);
    usee = itemView.findViewById(R.id.awd);
        }
    }
}
