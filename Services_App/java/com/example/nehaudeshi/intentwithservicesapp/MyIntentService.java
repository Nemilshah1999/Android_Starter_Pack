package com.example.nehaudeshi.intentwithservicesapp;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


public class MyIntentService extends IntentService {

    private static final String TAG = "com.example.nehaudeshi.intentwithservicesapp";

    public MyIntentService() {

        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        // Getting the following message in logcat when application is started
        Log.i(TAG, "The service has started");
    }
}


