package com.example.rep_4_runonuithread_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBan;
    int[] imagenes = {R.drawable.f1,R.drawable.f2,R.drawable.f3};
    int indice;

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            imgVwBan.setImageResource(imagenes[indice]);
        }
    };

    Thread thilo = new Thread(){
        @Override
        public void run() {
            super.run();
            for(indice=0; indice<=2; indice++){
                try {
                    Thread.sleep(1000);
                    runOnUiThread(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (indice==2)
                    indice=-1;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBan = findViewById(R.id.imgVwBan);
        thilo.start();
    }
}
