package com.example.rep_2_asyntask_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imgVwBan;
    int[] imagenes = {R.drawable.f1,R.drawable.f2,R.drawable.f3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVwBan = findViewById(R.id.imgVwBan);
        ClaseAsincrona banner = new ClaseAsincrona();
        banner.execute(0,2,1000);
    }

    class ClaseAsincrona extends AsyncTask<Integer,Integer,Double>{

        @Override
        protected Double doInBackground(Integer... integers) {
            int i = integers[0];
            while(i<=integers[1]){

                try {
                    Thread.sleep(integers[2]);
                    publishProgress(imagenes[i]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
                if (i==3)
                    i=0;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            imgVwBan.setImageResource(values[0]);
        }
    }
}
