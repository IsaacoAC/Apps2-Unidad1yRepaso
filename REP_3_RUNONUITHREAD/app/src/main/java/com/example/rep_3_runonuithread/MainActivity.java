package com.example.rep_3_runonuithread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtView;
    Runnable runnable = new Runnable(){
        @Override
        public void run() {
            //aqui modificamos la interfaz grafica
            txtView.append("Queso Habanero Mamado \n");
        }
    };

    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            for (int i=0; i<=10;i++){
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.txtView);
        thread.start();
    }
}
