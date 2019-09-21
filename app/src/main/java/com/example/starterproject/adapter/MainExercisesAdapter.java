package com.example.starterproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.starterproject.R;
import com.example.starterproject.listener.OnRecyclerClickListener;
import com.sdsmdg.tastytoast.TastyToast;

public class MainExercisesAdapter extends RecyclerView.Adapter<MainExercisesAdapter.ExerciseViewHolder> {


    private Context context;
    private OnRecyclerClickListener clickListener;
    private int[] images = {
            R.drawable.fitness_mania_abs_circle,
            R.drawable.fitness_mania_arms_circle,
            R.drawable.fitness_mania_back_circle,
            R.drawable.fitness_mania_chest_circle,
            R.drawable.fitness_mania_hips_circle,
            R.drawable.fitness_mania_legs_circle,
            R.drawable.fitness_mania_buttocks_circle};

    public void setClickListener(OnRecyclerClickListener listener){
        clickListener = listener;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.main_activity_circle_item,parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {

        holder.circleImage.setImageResource(images[position]);

        holder.itemView.setOnClickListener(view -> {

            clickListener.OnExerciseClicked(position);
        });
    }

    @Override
    public int getItemCount() {
        return 7;
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder {

        ImageView circleImage;
        ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImage = itemView.findViewById(R.id.circle_image);
        }
    }
}
