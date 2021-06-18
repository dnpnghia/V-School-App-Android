package com.example.v_school;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity {

    /*Duration of wait*/
    private final int SPLASH_DISPLAY_LENGTH = 3000;
    private SoundPool soundPool;

    private AudioManager audioManager;


    // Maximumn sound stream.
    private static final int MAX_STREAMS = 5;

    // Stream type.
    private static final int streamType = AudioManager.STREAM_MUSIC;

    private boolean loaded;

    private int soundIdDestroy;
    private int soundIdGun;
    private float volume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("V-school");

        setContentView(R.layout.activity_welcome);

         new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /* Create an Intent that will start the MainActivity. */
                Intent mainIntent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}
