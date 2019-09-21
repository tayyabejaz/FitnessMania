package com.example.starterproject.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.starterproject.R;
import com.example.starterproject.databinding.ActivityBodyPointBinding;

public class BodyPointActivity extends AppCompatActivity {

    ActivityBodyPointBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_body_point);

        binding.activityTitle.setText(getIntent().getExtras().getString("title"));

    }
}
