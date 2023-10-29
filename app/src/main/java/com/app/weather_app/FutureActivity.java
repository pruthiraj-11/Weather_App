package com.app.weather_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.weather_app.databinding.ActivityFutureBinding;

public class FutureActivity extends AppCompatActivity {
    ActivityFutureBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFutureBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}