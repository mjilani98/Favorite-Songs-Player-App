package com.example.hw5q1;

import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity
{
    private SoundPool soundPool ;   //sound pool
    private int soundId;            //sound id


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //display the screen
        setContentView(R.layout.activity_main);

        //create sound pool builder
        SoundPool.Builder soundPoolBuilder = new SoundPool.Builder();

        //create sound pool
        soundPool = soundPoolBuilder.build();

        //load audio file into sound pool and get sound id
        soundPool.load(this,R.raw.lotus,1);
        soundPool.load(this,R.raw.morning,2);
        soundPool.load(this,R.raw.startingoutwaltzvivace,3);
        soundPool.load(this,R.raw.funkyboxstep,4);
        soundPool.load(this,R.raw.igotastickarrbryanteoh,5);
    }
    //event handler of play button
    public void play(View view)
    {
        //play sound
        soundPool.play(soundId, 1, 1, 1, 0, 1);
    }
}