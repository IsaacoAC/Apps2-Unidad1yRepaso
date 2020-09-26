package com.example.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent intServicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intServicio = new Intent(this,MyService.class);
        BroadcastReceiver bcreceiver = new miBroadcastReceiver();
        IntentFilter filtro = new IntentFilter("Mi_servicio");
        registerReceiver(bcreceiver, filtro);
    }

    public void Iniciar(View v){
        intServicio.putExtra("DATO","Dato de la actividad!");
        startService(intServicio);
    }

    public void Detener(View v){
        stopService(intServicio);
    }

    class miBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //pocesamos el mensaje recibido
            Log.wtf("Mensaje", "Thread");
        }
    }
}
