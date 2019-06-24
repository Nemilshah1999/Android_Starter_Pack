package com.example.nehaudeshi.mycameraapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMG_CAPTURE = 1;

    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // References to button and image view
        Button myButton = (Button) findViewById(R.id.myButton);
        myImageView = (ImageView) findViewById(R.id.myImageView);

        // If mobile does nit have camera, disable the button
        if(!hasCamera()){
            myButton.setEnabled(false);
        }
    }

    // Checking if the mobile has camera
    public boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    // Launching the camera in the mobile and requesting image capture
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMG_CAPTURE);
    }

    // Setting captured image in image view
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // Checking if image has been captured and user is ok with the captured image
        if(requestCode==REQUEST_IMG_CAPTURE && resultCode==RESULT_OK){
            // Getting the captured image
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");

            myImageView.setImageBitmap(photo);
        }
    }
}
