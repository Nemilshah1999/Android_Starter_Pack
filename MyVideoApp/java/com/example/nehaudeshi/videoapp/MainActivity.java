package com.example.nehaudeshi.videoapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference video view
        final VideoView myVideoView = (VideoView)findViewById(R.id.myVideoView);

        // Set the Video path
        myVideoView.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");

        // Play the video
        myVideoView.start();
    }
}
