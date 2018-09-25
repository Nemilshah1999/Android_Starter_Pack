package com.example.nehaudeshi.mylistapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] fruits = {"Apple","Orange","Peach","Mango"};

        // Enables the array to be viewed as a list
        //ListAdapter myAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,fruits);
        ListAdapter myAdapter = new customAdapter(this,fruits);

        // Adding adapter to the list view
        ListView myListView = (ListView)findViewById(R.id.myListView);
        myListView.setAdapter(myAdapter);

        // Setting on item click action
        myListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        // To get the string selected from the list
                        String fruit = String.valueOf(parent.getItemAtPosition(position));
                        // Showing the selected item as a popup
                        Toast.makeText(MainActivity.this, fruit, Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

}
