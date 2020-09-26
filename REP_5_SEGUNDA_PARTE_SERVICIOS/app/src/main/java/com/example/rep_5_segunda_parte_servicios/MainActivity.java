package com.example.rep_5_segunda_parte_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwDatos = findViewById(R.id.txtVwDatos);
        BroadcastReceiver bcreceiver = new miBroadcastReceiver();
        IntentFilter filtro = new IntentFilter("Mi_servicio");
        registerReceiver(bcreceiver, filtro);
    }

    class miBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //pocesamos el mensaje recibido
            txtVwDatos.append(intent.getStringExtra("enviados"));
        }
    }

}
