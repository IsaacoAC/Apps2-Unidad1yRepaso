package com.example.rep_5_servicios;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
    Thread miThread;
    Intent intent2;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.wtf("Mi servicio","ONCREATE" );
    }

    @Override
    public void onStart(final Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.wtf("Mi servicio", intent.getStringExtra("DATO") );
        miThread = new Thread(){
            @Override
            public void run() {
                super.run();
                while(true){
                    try {
                        Thread.sleep(1000);
                        //Log.wtf("Mi servicio", "Thread");
                        intent2 = new Intent("Mi_servicio");
                        intent2.putExtra("enviados", "Datos enviados");
                        sendBroadcast(intent2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        };
        miThread.start();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.wtf("Mi servicio","ONDESTROY" );
        miThread.interrupt();
    }
}
