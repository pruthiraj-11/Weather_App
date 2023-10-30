package com.app.weather_app.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.weather_app.Models.FuturePredictionModel;
import com.app.weather_app.Models.Hourly;
import com.app.weather_app.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FuturePreditionAdapter extends RecyclerView.Adapter<FuturePreditionAdapter.viewholder> {
    ArrayList<FuturePredictionModel> list;
    Context context;

    public FuturePreditionAdapter(ArrayList<FuturePredictionModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_future,parent,false);
        context= parent.getContext();
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        holder.textView1.setText(""+list.get(position).getHighTemp());
        holder.textView2.setText(""+list.get(position).getLowTemp());
        holder.textView3.setText(list.get(position).getDay());
        holder.textView4.setText(list.get(position).getStatus());

        int drawableResourceId=holder.itemView.getResources().getIdentifier(list.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());

        Glide.with(context)
                .load(drawableResourceId)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewholder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView1,textView2,textView3,textView4;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.weatherimg);
            textView1=itemView.findViewById(R.id.hightxt);
            textView2=itemView.findViewById(R.id.lowtxt);
            textView3=itemView.findViewById(R.id.daytxt);
            textView4=itemView.findViewById(R.id.statustxt);
        }
    }
}
