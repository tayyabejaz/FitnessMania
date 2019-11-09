package com.example.starterproject.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starterproject.R;
import com.example.starterproject.adapter.ExercisesListAdapter;
import com.example.starterproject.adapter.MainExercisesAdapter;
import com.example.starterproject.databinding.ActivityMainBinding;
import com.example.starterproject.listener.OnDetailExerciseClicked;
import com.example.starterproject.listener.OnRecyclerClickListener;
import com.example.starterproject.managers.ActivityManager;
import com.example.starterproject.model.ExerciseList;

import java.util.ArrayList;
import java.util.List;

import static com.example.starterproject.Constants.ABS;
import static com.example.starterproject.Constants.ARMS;
import static com.example.starterproject.Constants.BACK;
import static com.example.starterproject.Constants.BUTTOCKS;
import static com.example.starterproject.Constants.CHEST;
import static com.example.starterproject.Constants.HIPS;
import static com.example.starterproject.Constants.LEGS;
import static com.example.starterproject.Constants.MAIN_CIRCLE_IMAGE;
import static com.example.starterproject.Constants.MUSCLE_ACTIVITY;

public class MainActivity extends AppCompatActivity implements OnRecyclerClickListener, OnDetailExerciseClicked {

    private ActivityMainBinding mainBinding;
    private MainExercisesAdapter mainExercisesAdapter;

    private ExercisesListAdapter exercisesListAdapterArms;
    private ExercisesListAdapter exercisesListAdapterAbs;
    private ExercisesListAdapter exercisesListAdapterBack;
    private ExercisesListAdapter exercisesListAdapterChest;
    private ExercisesListAdapter exercisesListAdapterShoulders;
    private ExercisesListAdapter exercisesListAdapterButtocks;
    private ExercisesListAdapter exercisesListAdapterHips;
    private ExercisesListAdapter exercisesListAdapterLegs;

    private List<ExerciseList> armsitemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("arms"));
            add(new ExerciseList("biceps"));
            add(new ExerciseList("triceps"));
            add(new ExerciseList("forearms"));

        }
    };

    private List<ExerciseList> absItemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("abs"));
            add(new ExerciseList("abdominal"));
            add(new ExerciseList("obliques"));
            add(new ExerciseList("seratus anterior"));
        }
    };

    private List<ExerciseList> chestItemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("chest"));
            add(new ExerciseList("pectoralis major"));
        }
    };

    private List<ExerciseList> shouldersItemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("shoulders"));
            add(new ExerciseList("anterios delts"));
            add(new ExerciseList("lateral_delts"));
            add(new ExerciseList("posterior_delts"));
        }
    };

    private List<ExerciseList> backItemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("backs"));
            add(new ExerciseList("infraspinatus"));
            add(new ExerciseList("latissimus_dorsi"));
            add(new ExerciseList("teres"));
            add(new ExerciseList("trapezius"));
        }
    };

    private List<ExerciseList> legItemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("legs"));
            add(new ExerciseList("calves"));
            add(new ExerciseList("hamstrings"));
            add(new ExerciseList("quads"));
            add(new ExerciseList("sartorius"));
            add(new ExerciseList("tibialis anterior"));
        }
    };

    private List<ExerciseList> buttocksItemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("buttocks"));
            add(new ExerciseList("gluteus maximus"));
            add(new ExerciseList("gluteus medius"));
        }
    };

    private List<ExerciseList> hipsItemList = new ArrayList<ExerciseList>() {
        {
            add(new ExerciseList("hips"));
            add(new ExerciseList("hip abductors"));
            add(new ExerciseList("hip flexor"));
            add(new ExerciseList("tensor fasciae latae"));
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        initAdapters();
    }

    private void initAdapters() {

        mainExercisesAdapter = new MainExercisesAdapter();
        mainExercisesAdapter.setClickListener(this);

        exercisesListAdapterAbs = new ExercisesListAdapter(this, absItemList);
        exercisesListAdapterAbs.setOnListener(this, this);

        exercisesListAdapterArms = new ExercisesListAdapter(this, armsitemList);
        exercisesListAdapterArms.setOnListener(this, this);

        exercisesListAdapterBack = new ExercisesListAdapter(this, backItemList);
        exercisesListAdapterBack.setOnListener(this, this);

        exercisesListAdapterButtocks = new ExercisesListAdapter(this, buttocksItemList);
        exercisesListAdapterButtocks.setOnListener(this, this);

        exercisesListAdapterChest = new ExercisesListAdapter(this, chestItemList);
        exercisesListAdapterChest.setOnListener(this, this);

        exercisesListAdapterHips = new ExercisesListAdapter(this, hipsItemList);
        exercisesListAdapterHips.setOnListener(this, this);

        exercisesListAdapterLegs = new ExercisesListAdapter(this, legItemList);
        exercisesListAdapterLegs.setOnListener(this, this);

        exercisesListAdapterShoulders = new ExercisesListAdapter(this, shouldersItemList);
        exercisesListAdapterShoulders.setOnListener(this, this);
        connectingToRecycler();
    }

    private void connectingToRecycler() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        mainBinding.mainActivityCircleRecycler.setLayoutManager(layoutManager);
        mainBinding.mainActivityCircleRecycler.setAdapter(mainExercisesAdapter);

        mainBinding.absRecycler.setAdapter(exercisesListAdapterAbs);

        mainBinding.armsRecycler.setAdapter(exercisesListAdapterArms);

        mainBinding.chestRecycler.setAdapter(exercisesListAdapterChest);

        mainBinding.shoulderRecycler.setAdapter(exercisesListAdapterShoulders);

        mainBinding.backRecycler.setAdapter(exercisesListAdapterBack);

        mainBinding.legsRecycler.setAdapter(exercisesListAdapterLegs);

        mainBinding.buttocksRecycler.setAdapter(exercisesListAdapterButtocks);

        mainBinding.hipsRecycler.setAdapter(exercisesListAdapterHips);
    }

    @Override
    public void OnExerciseClicked(int position) {
        Bundle bundle;
        switch (position) {

            case 0:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, ABS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 1:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, ARMS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 2:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, BACK);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 3:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, CHEST);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 4:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, HIPS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 5:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, LEGS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case 6:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, BUTTOCKS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

        }
    }

    @Override
    public void onBodyInfoClick(String exerciseName) {
        Bundle bundle;
        switch (exerciseName) {

            case ABS:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, ABS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case ARMS:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, ARMS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case BACK:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, BACK);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case CHEST:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, CHEST);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case HIPS:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, HIPS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case LEGS:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, LEGS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

            case BUTTOCKS:
                bundle = new Bundle();
                bundle.putString(MAIN_CIRCLE_IMAGE, BUTTOCKS);
                ActivityManager.getInstance().openNewActivity(MainActivity.this, BodyPointActivity.class, bundle, true);
                break;

        }
    }


    @Override
    public void onDetailClicked(String exerciseName) {

        Intent intent = new Intent(this, MuscleDetailActivity.class);
        intent.putExtra(MUSCLE_ACTIVITY, exerciseName);

    }
}
