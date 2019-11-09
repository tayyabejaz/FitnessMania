package com.example.starterproject.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.example.starterproject.R;
import com.example.starterproject.databinding.ActivityBodyPointBinding;

import static com.example.starterproject.Constants.ABS;
import static com.example.starterproject.Constants.ARMS;
import static com.example.starterproject.Constants.BACK;
import static com.example.starterproject.Constants.BODY_PART_ACTIVITY;
import static com.example.starterproject.Constants.BUTTOCKS;
import static com.example.starterproject.Constants.CHEST;
import static com.example.starterproject.Constants.HIPS;
import static com.example.starterproject.Constants.LEGS;
import static com.example.starterproject.Constants.MAIN_CIRCLE_IMAGE;

public class BodyPointActivity extends AppCompatActivity {

    ActivityBodyPointBinding binding;
    String intent_circle, intent_individual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_body_point);


        intent_circle = getIntent().getExtras().getString(MAIN_CIRCLE_IMAGE);
        if (intent_circle != null) {
            updateUI();
        }

//        intent_individual = getIntent().getExtras().getString(BODY_PART_ACTIVITY);
//        if (intent_individual != null) {
//            updateImages();
//        }

    }

//    private void updateImages() {
//        switch (intent_individual) {
//            case "abs":
//
//            case "abdominal":
//
//            case "obliques":
//
//            case "seratus anterior":
//
//                binding.activityTitle.setText("ABS Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/abs_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//
//                break;
//
//
//            case "arms":
//
//            case "biceps":
//
//            case "triceps":
//
//            case "forearms":
//
//                binding.activityTitle.setText("Arms Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/arms_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//
//                break;
//
//            case "chest":
//            case "pectoralis major":
//
//                binding.activityTitle.setText("Chest Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/chest_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//
//                break;
//
//            case "shoulders":
//            case "anterios delts":
//            case "lateral_delts":
//            case "posterior_delts":
//
//                binding.activityTitle.setText("Shoulders Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/shoulders_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//                break;
//
//            case "backs":
//            case "infraspinatus":
//            case "latissimus_dorsi":
//            case "teres":
//            case "trapezius":
//
//                binding.activityTitle.setText("Back Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/back_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//                break;
//
//            case "legs":
//            case "calves":
//            case "hamstrings":
//            case "quads":
//            case "sartorius":
//            case "tibialis anterior":
//
//
//                binding.activityTitle.setText("Legs Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/legs_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//                break;
//
//            case "buttocks":
//            case "gluteus maximus":
//            case "gluteus medius":
//
//
//                binding.activityTitle.setText("Buttocks Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/buttocks_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//                break;
//
//            case "hips":
//            case "hip abductors":
//            case "hip flexor":
//            case "tensor fasciae latae":
//
//
//                binding.activityTitle.setText("Hips Training");
//                Glide.with(this)
//                        .load("file:///android_asset/full_body_image/hips_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
//                        .into(binding.bodyPointMainImage);
//                break;
//        }
//    }

    private void updateUI() {

        switch (intent_circle) {
            case ABS:
                binding.activityTitle.setText(intent_circle);
                Glide.with(this)
                        .load("file:///android_asset/full_body_image/abs_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
                        .into(binding.bodyPointMainImage);
                break;

            case ARMS:
                binding.activityTitle.setText(intent_circle);
                Glide.with(this)
                        .load("file:///android_asset/full_body_image/arms_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
                        .into(binding.bodyPointMainImage);
                break;

            case BACK:
                binding.activityTitle.setText(intent_circle);
                Glide.with(this)
                        .load("file:///android_asset/full_body_image/back_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
                        .into(binding.bodyPointMainImage);
                break;

            case CHEST:
                binding.activityTitle.setText(intent_circle);
                Glide.with(this)
                        .load("file:///android_asset/full_body_image/chest_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
                        .into(binding.bodyPointMainImage);

                break;

            case HIPS:
                binding.activityTitle.setText(intent_circle);
                Glide.with(this)
                        .load("file:///android_asset/full_body_image/hips_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
                        .into(binding.bodyPointMainImage);

                break;

            case LEGS:
                binding.activityTitle.setText(intent_circle);
                Glide.with(this)
                        .load("file:///android_asset/full_body_image/legs_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
                        .into(binding.bodyPointMainImage);

                break;

            case BUTTOCKS:
                binding.activityTitle.setText(intent_circle);
                Glide.with(this)
                        .load("file:///android_asset/full_body_image/buttocks_muscles_structure".toLowerCase().replace(" ", "_") + ".webp")
                        .into(binding.bodyPointMainImage);

                break;
        }

    }
}
