package com.example.starterproject.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.starterproject.R;
import com.example.starterproject.databinding.ActivityMuscleDetailBinding;

public class MuscleDetailActivity extends AppCompatActivity {

    ActivityMuscleDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_muscle_detail);

        initListners();
    }

    private void initListners() {
    }
}
