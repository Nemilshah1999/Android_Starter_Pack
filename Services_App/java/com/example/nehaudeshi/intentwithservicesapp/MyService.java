package com.example.nehaudeshi.intentwithservicesapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {

    private static final String TAG = "com.example.nehaudeshi.intentwithservicesapp";

    public MyService() {
    }

    // Executed when service starts running
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "Service has been started");

        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    long futuretime = System.currentTimeMillis() + 5000;
                    while (System.currentTimeMillis() < futuretime) {
                        synchronized (this) {
                            try {
                                wait(futuretime-System.currentTimeMillis());
                                Log.i(TAG, "Service is running");
                            } catch (Exception e) {}
                        }
                    }
                }
            }
        };

        Thread myThread = new Thread(r);
        myThread.start();

        // Starts again if stopped due to some reason
        return Service.START_STICKY;
    }

    // Executed when destroyed
    @Override
    public void onDestroy() {
        Log.i(TAG,"Service has been destroyed");
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
       return null;
    }
}
