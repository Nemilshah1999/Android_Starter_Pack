package com.example.nehaudeshi.intentapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        // Getting the object of the data passed
        Bundle firstData = getIntent().getExtras();

        // Checking if input was null
        if(firstData==null){
            return;
        }

        // Extracting the data
        String firstMessage=firstData.getString("firstMessage");

        final TextView secondText = (TextView)findViewById(R.id.secondText);
        secondText.setText(firstMessage);

    }

}
