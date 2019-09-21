package com.example.starterproject.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;

import com.example.starterproject.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        intiateSplash();
    }

    private void intiateSplash(){

        new Handler().postDelayed(() -> startActivity(),2000);
    }

    private void startActivity() {
        startActivity(new Intent(SplashActivity.this,MainActivity.class));
    }
}
