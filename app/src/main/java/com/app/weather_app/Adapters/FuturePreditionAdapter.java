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
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_hourly,parent,false);
        context= parent.getContext();
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
//        holder.textView1.setText(list.get(position).getHour());
//        holder.textView2.setText(list.get(position).getTemp()+"");

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
        TextView textView1,textView2;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.pic);
            textView1=itemView.findViewById(R.id.hourText);
            textView2=itemView.findViewById(R.id.hourtemp);
        }
    }
}
