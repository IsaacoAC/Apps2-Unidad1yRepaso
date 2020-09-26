package com.example.rep_7_mediaplayer_service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Intent intento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intento = new Intent(this,MyMusicPlayer.class);
    }

    public void iniciar(View v){
        startService(intento);
    }

    public void stop(View v){
        stopService(intento);
    }
}
