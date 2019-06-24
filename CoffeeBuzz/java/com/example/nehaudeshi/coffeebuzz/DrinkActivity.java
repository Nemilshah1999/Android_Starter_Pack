package com.example.nehaudeshi.coffeebuzz;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listDrinks = getListView();

        ArrayAdapter<Drinks> listAdapter = new ArrayAdapter<Drinks>(this, android.R.layout.simple_list_item_1, Drinks.drinks);
        listDrinks.setAdapter(listAdapter);

    }

    public void onListItemClick(ListView listview, View itemView, int position, long id){
        Intent intent = new Intent(DrinkActivity.this,Drink_Activity.class);
        intent.putExtra("DRINK_NO",(int) id);
        startActivity(intent);
    };

}
