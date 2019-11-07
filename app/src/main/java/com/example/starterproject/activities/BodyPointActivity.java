package com.example.starterproject.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.starterproject.R;
import com.example.starterproject.databinding.ActivityBodyPointBinding;
import com.example.starterproject.helper.AdsManager;

public class BodyPointActivity extends AppCompatActivity {

    ActivityBodyPointBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_body_point);

        updateUI(getIntent().getExtras().getString("title"));


    }

    private void updateUI(String title){

        switch (title){
            case "Abs Training":
                binding.activityTitle.setText(title);
//                binding.bodyPointMainImage.setImageResource(R.drawable.fitnes_mania_abs_body);
                break;

            case "Arms Training":
                binding.activityTitle.setText(title);
//                binding.bodyPointMainImage.setImageResource(R.drawable.fitnes_mania_arms_body);
                break;

            case "Back Training":
                binding.activityTitle.setText(title);
//                binding.bodyPointMainImage.setImageResource(R.drawable.fitnes_mania_back_body);
                break;

            case "Chest Training":
                binding.activityTitle.setText(title);
//                binding.bodyPointMainImage.setImageResource(R.drawable.fitnes_mania_chest_body);

                break;

            case "Hips Training":
                binding.activityTitle.setText(title);
//                binding.bodyPointMainImage.setImageResource(R.drawable.fitnes_mania_hips_body);

                break;

            case "Legs Training":
                binding.activityTitle.setText(title);
//                binding.bodyPointMainImage.setImageResource(R.drawable.fitnes_mania_legs_body);

                break;

            case "Buttocks Training":
                binding.activityTitle.setText(title);
//                binding.bodyPointMainImage.setImageResource(R.drawable.fitnes_mania_buttocks_body);

                break;
        }

    }
}
