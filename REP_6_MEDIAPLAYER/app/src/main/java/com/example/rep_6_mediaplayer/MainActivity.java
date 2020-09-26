package com.example.rep_6_mediaplayer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer2 = MediaPlayer.create(this,R.raw.cancion1);
    }

    public void iniciar(View v){
        if(mediaPlayer2 !=null)
        mediaPlayer2.start();
    }

    public void detener(View v){
        if(mediaPlayer2 !=null)
            mediaPlayer2.stop();
    }
}
