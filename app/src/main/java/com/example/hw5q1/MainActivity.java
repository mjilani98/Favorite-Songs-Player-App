package com.example.hw5q1;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{
    private SoundPool soundPool ;           //sound pool
    private int[] soundId = new int[5];    //sound id
    private int currentlyPlaying = -1;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //display the screen
        setContentView(R.layout.activity_main);

        //create sound pool builder
        SoundPool.Builder soundPoolBuilder = new SoundPool.Builder();

        //create sound pool
        soundPool = soundPoolBuilder.build();

        //load audio file into sound pool and get sound id
        soundId[0] = soundPool.load(this, R.raw.funkyboxstep, 1);
        soundId[1] = soundPool.load(this, R.raw.igotastickarrbryanteoh, 1);
        soundId[2] = soundPool.load(this, R.raw.lotus, 1);
        soundId[3] = soundPool.load(this, R.raw.morning, 1);
        soundId[4] = soundPool.load(this, R.raw.startingoutwaltzvivace, 1);
    }

    //event handler of play button
    public void play(View view)
    {
        //generate random number to be song number
        Random random = new Random();
        int randomSong = random.nextInt(5);

        //play sound
        soundPool.play(soundId[randomSong], 1, 1, 1, 0, 1);

        currentlyPlaying = soundId[randomSong];
    }

    //event handler of pause button
    public void pause(View view)
    {
        //pause sound
        if(currentlyPlaying != -1)
            soundPool.pause(currentlyPlaying);

    }

    //event handler of resume button
    public void resume(View view)
    {
        //resume sound
        if(currentlyPlaying != -1)
            soundPool.resume(currentlyPlaying);

    }

    //event handler of stop  button
    public void stop(View view)
    {
        //resume sound
        if(currentlyPlaying != -1)
            soundPool.stop(currentlyPlaying);

    }
}