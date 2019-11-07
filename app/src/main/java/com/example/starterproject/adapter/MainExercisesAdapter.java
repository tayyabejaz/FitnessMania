package com.example.starterproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.starterproject.R;
import com.example.starterproject.application.AppClass;
import com.example.starterproject.listener.OnRecyclerClickListener;

import java.util.ArrayList;
import java.util.List;

public class MainExercisesAdapter extends RecyclerView.Adapter<MainExercisesAdapter.ExerciseViewHolder> {


    private Context context;
    private OnRecyclerClickListener clickListener;

    private List<String> itemList = new ArrayList<String>() {
        {
            add(AppClass.getContext().getString(R.string.abs));
            add(AppClass.getContext().getString(R.string.arms));
            add(AppClass.getContext().getString(R.string.back));
            add(AppClass.getContext().getString(R.string.shoulders));
            add(AppClass.getContext().getString(R.string.legs));
            add(AppClass.getContext().getString(R.string.chest));
            add(AppClass.getContext().getString(R.string.hips));
            add(AppClass.getContext().getString(R.string.buttocks));

        }
    };

    public void setClickListener(OnRecyclerClickListener listener) {
        clickListener = listener;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.main_activity_circle_item, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {


        String path="file:///android_asset/main_images/"+itemList.get(position).toLowerCase()+"_circle.webp";
        Glide.with(context).load(path).into(holder.circleImage);

        holder.itemView.setOnClickListener(view -> {

            clickListener.OnExerciseClicked(position);
        });
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder {

        ImageView circleImage;

        ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImage = itemView.findViewById(R.id.circle_image);
        }
    }
}
