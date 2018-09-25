package com.example.nehaudeshi.workoutadvisor;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindWorkoutActivity extends Activity {

    // making an object of the public class - workoutExpert
    private workoutExpert expert = new workoutExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_workout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    }

    public void onClickFindWorkout(View view){

        // Making objects by selecting by Id
        TextView workouts = (TextView)findViewById(R.id.workout);
        Spinner workoutType = (Spinner) findViewById(R.id.workoutType);

        // Getting the workout type selected in the spinner
        String workout = String.valueOf(workoutType.getSelectedItem());


//       // Displaying the selected item in text view
//       workouts.setText(workout);

        // Getting the list of workouts for a workout type
        List <String> workoutList = expert.getWorkouts(workout);

        // Edits the immutable string class object
        StringBuilder workoutsFormatted = new StringBuilder();

        // Appending all workouts
        for(String work : workoutList){
            workoutsFormatted.append(work).append("\n");
        }

        // Displaying the selected item's workout in text view
        workouts.setText(workoutsFormatted);
    }
}
