package com.example.starterproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.starterproject.R;
import com.example.starterproject.databinding.ExerciseListItemBinding;
import com.example.starterproject.listener.OnRecyclerClickListener;
import com.example.starterproject.model.ExerciseList;

import java.util.ArrayList;
import java.util.List;

public class ExercisesListAdapter extends RecyclerView.Adapter<ExercisesListAdapter.ExerciseListViewHolder> {

    private Context context;
    private List<ExerciseList> dataList = new ArrayList();
    private OnRecyclerClickListener itemListener;

    public void setOnListener(OnRecyclerClickListener listener) {
        this.itemListener = listener;
    }

    public ExercisesListAdapter(Context context, List<ExerciseList> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public ExerciseListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        ExerciseListItemBinding listItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.exercise_list_item, parent, false);

        return new ExerciseListViewHolder(listItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseListViewHolder holder, int position) {
        holder.binding.exerciseListTextview.setText(dataList.get(position).exerciseName);

        Glide.with(context).load(dataList.get(position).exerciseImage).into(holder.binding.exerciseListImage);

        holder.itemView.setOnClickListener(view -> {

            itemListener.OnExerciseClicked(position);

        });


    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class ExerciseListViewHolder extends RecyclerView.ViewHolder {

        ExerciseListItemBinding binding;

        ExerciseListViewHolder(@NonNull ExerciseListItemBinding itemView) {
            super(itemView.getRoot());

            binding = DataBindingUtil.bind(itemView.getRoot());

        }

        void bindData(ExerciseList exerciseList) {
            binding.setSetData(exerciseList);
            binding.executePendingBindings();
        }
    }
}
