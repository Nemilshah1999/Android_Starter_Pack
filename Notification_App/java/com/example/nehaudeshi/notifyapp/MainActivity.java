package com.example.nehaudeshi.notifyapp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Setting some references and variables
    NotificationCompat.Builder notification;
    NotificationManager notificationManager;
    private static final int unique_id=40111;
    private static final String channel_id="Ch_01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Setting the notification manager for getting notification services
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // Setting the notification Service
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channel_id, "My Notifications", NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(notificationChannel);
        }


        // Setting reference for notification
        notification = new NotificationCompat.Builder(this,channel_id);

        // When the notification is checked, it should disappear
        notification.setAutoCancel(true);

    }

    public void myButtonClicked(View view){

        // Setting Notification configurations
        notification.setSmallIcon(R.drawable.image);
        notification.setTicker("This is a ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("This is the title");
        notification.setContentText("Here is the text");

        // When notification is clicked, returrning to the application
        Intent intent = new Intent(this,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);
        
        notificationManager.notify(unique_id,notification.build());
    }
}
