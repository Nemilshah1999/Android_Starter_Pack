package com.example.nehaudeshi.coffeebuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Drink_Activity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_);

        ImageView image = (ImageView)findViewById(R.id.image);
        TextView nameText = (TextView)findViewById(R.id.nameText);
        TextView descText = (TextView)findViewById(R.id.descText);


        Intent intent = getIntent();
        int id = intent.getIntExtra("DRINK_NO",0);

        nameText.setText(Drinks.drinks[id].getName());
        descText.setText(Drinks.drinks[id].getDesc());
        image.setImageResource(Drinks.drinks[id].getImageID());
    }
}
