package com.example.nehaudeshi.bmi_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void calcBmi(View view){

        double height = 0;
        double weight = 0;
        double bmi=0;
        String result;

        EditText weightText = (EditText)findViewById(R.id.weightText);
        EditText heightText = (EditText)findViewById(R.id.heightText);

        Button button = (Button)findViewById(R.id.button2);

        TextView bmiText = (TextView)findViewById(R.id.bmiText);
        TextView resultText = (TextView)findViewById(R.id.resultText);

        weight = Double.parseDouble(weightText.getText().toString());
        height = Double.parseDouble(heightText.getText().toString());

        bmi = height*height;
        bmi = weight/bmi;

        bmiText.setText(String.valueOf(bmi));

        if(bmi<18.5){
            result = "Underweight";
        }
        else if(bmi<25){
            result = "Normal";
        }
        else{
            result = "Overweight";
        }

        resultText.setText(result);

    }

}
