package com.example.nehaudeshi.workoutadvisor;

import java.util.ArrayList;
import java.util.List;

public class workoutExpert {
    List <String> getWorkouts(String workoutTypes){
        List <String> workout = new ArrayList<String>();

        if(workoutTypes.equals("Chest")){
            workout.add("Bench Press");
            workout.add("Cable Flys");
        }

         else if(workoutTypes.equals("Triceps")){
            workout.add("Tricep Ext");
            workout.add("Tricep Pushdowns");
        }

        else if(workoutTypes.equals("Shoulders")){
            workout.add("Shoulder Press");
        }

        else if(workoutTypes.equals("Biceps")){
            workout.add("Bicep Curls");
        }
        return workout;
    }
}
