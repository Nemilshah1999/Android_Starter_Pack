package com.example.nehaudeshi.sharedpreferenceapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    TextView myText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        usernameInput = (EditText)findViewById(R.id.usernameInput);
        passwordInput = (EditText)findViewById(R.id.passwordInput);
        myText = (TextView)findViewById(R.id.myText);
    }

    public void saveInfo(View view){
        // Setting the shared preferences
        SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpref.edit();
        editor.putString("username",usernameInput.getText().toString());
        editor.putString("password",passwordInput.getText().toString());

        // Make changes in shared preferences
        editor.apply();

        // Makes a toast displaying the data is saved
        Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();

        // Empties the input text
        usernameInput.setText("");
        passwordInput.setText("");
    }

    public void displayData(View view){
        // Getting the shared prefernces
        SharedPreferences sharedpref = getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        String name = sharedpref.getString("username","");
        String password = sharedpref.getString("password","");

        // Displaying the shared preferences
        myText.setText(name + " " + password);
    }
}

