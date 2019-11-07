package com.example.starterproject.model;

public class ExerciseList {


    public String exerciseName;

    public String getExerciseName() {
        return exerciseName;
    }

    public ExerciseList(String exerciseNamexe){
        this.exerciseName=exerciseNamexe;
    }

    public String getExerciseImage() {
        return "file:///android_asset/exercise_list/"+this.exerciseName.toLowerCase().replace(" ", "_")+".webp";

    }

    public void setExerciseImage(String exerciseImage) {
        this.exerciseImage = exerciseImage;
    }

    public String exerciseImage;
}
