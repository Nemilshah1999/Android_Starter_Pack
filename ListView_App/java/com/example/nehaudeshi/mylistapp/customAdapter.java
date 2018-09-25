package com.example.nehaudeshi.mylistapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends ArrayAdapter<String>{
    public customAdapter(@NonNull Context context, String [] Fruits) {
        super(context,R.layout.custom_row, Fruits);
    }

    @NonNull
    @Override
    // Set view of list view
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Initialisation
        LayoutInflater myInflater = LayoutInflater.from(getContext());
        View CustomView = myInflater.inflate(R.layout.custom_row,parent,false);

        // Get reference to Text and Image Views
        String singleFruitItem = getItem(position);
        TextView myText = (TextView) CustomView.findViewById(R.id.myText);
        ImageView myImage = (ImageView) CustomView.findViewById(R.id.myImage);

        // Setting the text and image
        myText.setText(singleFruitItem);
        myImage.setImageResource(R.drawable.apple);

        return CustomView;
    }
}

