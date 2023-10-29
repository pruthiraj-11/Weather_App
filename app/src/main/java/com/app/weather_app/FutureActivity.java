package com.app.weather_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.app.weather_app.Adapters.FuturePreditionAdapter;
import com.app.weather_app.Models.FuturePredictionModel;
import com.app.weather_app.databinding.ActivityFutureBinding;

import java.util.ArrayList;

public class FutureActivity extends AppCompatActivity {
    ActivityFutureBinding binding;
    private RecyclerView.Adapter adapterFuture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFutureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
        binding.backbtn.setOnClickListener(view -> {
            startActivity(new Intent(FutureActivity.this, MainActivity.class));
            finish();
        });
    }

    private void initRecyclerView() {
        ArrayList<FuturePredictionModel> list=new ArrayList<>();

        list.add(new FuturePredictionModel("Sat","storm","Storm",25,10));
        list.add(new FuturePredictionModel("Sun","cloudy","Cloudy",25,10));
        list.add(new FuturePredictionModel("Mon","windy","Windy",25,10));
        list.add(new FuturePredictionModel("Tue","cloudy_sunny","Cloudy Sunny",25,10));
        list.add(new FuturePredictionModel("Wed","sunny","Sunny",25,10));
        list.add(new FuturePredictionModel("Thu","rainy","Rainy",25,10));

        binding.view2.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapterFuture=new FuturePreditionAdapter(list);
        binding.view2.setAdapter(adapterFuture);
    }
}