package com.example.nehaudeshi.mynewapp;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Creating the objects
        RelativeLayout myLayout = new RelativeLayout(this);
        Button myButton = new Button(this);

        //Setting Widget Properties
        myLayout.setBackgroundColor(Color.BLUE);
        myButton.setBackgroundColor(Color.GREEN);
        myButton.setText("Click Here");

            //Setting Layout Parameters for widget
        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

            //Setting Alignment Parameters
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);



        EditText username = new EditText(this);

        //Adding ids to widgets
        myButton.setId(1);
        username.setId(2);

        //Setting Layout Parameters for widget
        RelativeLayout.LayoutParams userDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Setting Alignment Parameters
        userDetails.addRule(RelativeLayout.ABOVE,myButton.getId());
        userDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);

        //Converting dips to px and setting width
        Resources r = getResources();
        int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,r.getDisplayMetrics());
        username.setWidth(px);

        //Setting widget margins
        userDetails.setMargins(0,0,0,50);

        //Adding widgets to the layout
        myLayout.addView(myButton,buttonDetails);
        myLayout.addView(username,userDetails);

        //Displaying the Layout in the Activity UI
        setContentView(myLayout);
    }
}

