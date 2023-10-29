package com.app.weather_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.app.weather_app.Adapters.HourlyAdapter;
import com.app.weather_app.Models.Hourly;
import com.app.weather_app.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    private RecyclerView.Adapter adapterHourly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<Hourly> list=new ArrayList<>();

        list.add(new Hourly("9 PM",28,"cloudy"));
        list.add(new Hourly("10 PM",30,"sunny"));
        list.add(new Hourly("11 PM",34,"wind"));
        list.add(new Hourly("12 PM",25,"rainy"));
        list.add(new Hourly("1 AM",32,"storm"));

        binding.view1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        adapterHourly=new HourlyAdapter(list);
        binding.view1.setAdapter(adapterHourly);
    }
}