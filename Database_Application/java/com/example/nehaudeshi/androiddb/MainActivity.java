package com.example.nehaudeshi.androiddb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText myInput;
    TextView myText;
    MyDBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting references to the views
        myInput = (EditText)findViewById(R.id.myInput);
        myText = (TextView)findViewById(R.id.myText);

        // Setting reference to the database handler
        dbHandler = new MyDBHandler(this,null,null,1);
        printDatabase();
    }

    public void printDatabase(){
        String dbstring= dbHandler.databaseToString();
        myText.setText(dbstring);
        myInput.setText("");
    }

    public void addButtonClick(View view){
        Products products = new Products(myInput.getText().toString());
        dbHandler.addProduct(products);
        printDatabase();
    }

    public void deleteButtonClick(View view){
        String inputText = myInput.getText().toString();
        dbHandler.deleteProduct(inputText);
        printDatabase();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

