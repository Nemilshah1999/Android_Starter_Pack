package com.example.nehaudeshi.mythreadapp;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Handler is a means of communication between myThread and mainThread
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            TextView myText = (TextView) findViewById(R.id.myText);

            // When a button is clicked, a delay is caused due to the while loop, and it takes 10 secs to change the text.
            // If the button is clicked multiple times(when not in the handler), the app shall crash
            myText.setText("Button Clicked");
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void ClickMyButton(View view){

        // Runnable is an interface containing the code needed to be executed inside myThread
       Runnable r = new Runnable() {
           @Override
           public void run() {

               long futuretime = System.currentTimeMillis()+10000;

               // Wait for 10 seconds before executing further code
               while(System.currentTimeMillis()<futuretime){
                   synchronized (this){
                       try{
                           // Waits for this time before executing further
                           wait(futuretime-System.currentTimeMillis());
                       }catch (Exception e){}
                   }
               }
                handler.sendEmptyMessage(0);
           }
       };

       // Making a thread
       Thread myThread = new Thread(r);
       myThread.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
