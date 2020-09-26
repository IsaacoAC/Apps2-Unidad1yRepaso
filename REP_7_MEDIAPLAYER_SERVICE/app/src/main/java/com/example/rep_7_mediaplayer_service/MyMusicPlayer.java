package com.example.rep_7_mediaplayer_service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class MyMusicPlayer extends Service {

    MediaPlayer mediaPlayer2 = null;


    public MyMusicPlayer() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(),R.raw.cancion1);
        if(mediaPlayer2 != null)
            mediaPlayer2.start();
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mediaPlayer2 != null)
            mediaPlayer2.stop();
    }
}
