package com.example.starterproject.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;

import com.example.starterproject.R;
import com.example.starterproject.adapter.MainExercisesAdapter;
import com.example.starterproject.databinding.ActivityMainBinding;
import com.example.starterproject.listener.OnRecyclerClickListener;
import com.example.starterproject.managers.ActivityManager;

public class MainActivity extends AppCompatActivity implements OnRecyclerClickListener {

    private ActivityMainBinding mainBinding;
    private MainExercisesAdapter mainExercisesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.setMainActivityData(this);

        initAdapters();
    }

    private void initAdapters() {

        mainExercisesAdapter = new MainExercisesAdapter();
        mainExercisesAdapter.setClickListener(this);
        connectingToRecycler();
    }

    private void connectingToRecycler() {

        LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        mainBinding.mainActivityCircleRecycler.setLayoutManager(layoutManager);
        mainBinding.mainActivityCircleRecycler.setAdapter(mainExercisesAdapter);
    }

    @Override
    public void OnExerciseClicked(int position) {
        Bundle bundle;
        switch (position) {

            case 0:
                bundle = new Bundle();
                bundle.putString("title", "Abs Training");
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 1:
                bundle = new Bundle();
                bundle.putString("title", "Arms Training");
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 2:
                bundle = new Bundle();
                bundle.putString("title", "Back Training");
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 3:
                bundle = new Bundle();
                bundle.putString("title", "Chest Training");
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 4:
                bundle = new Bundle();
                bundle.putString("title", "Hips Training");
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 5:
                bundle = new Bundle();
                bundle.putString("title", "Legs Training");
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 6:
                bundle = new Bundle();
                bundle.putString("title", "Buttocks Training");
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

        }
    }
}
