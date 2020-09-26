package com.example.rep_1_asyntask;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.txtView);
        MiClaseAsincrona mcaPrueba= new MiClaseAsincrona();
        mcaPrueba.execute(1,10,1000);
    }

    class MiClaseAsincrona extends AsyncTask<Integer,String,Double>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            txtView.append("Inicio del hilo");
        }

        @Override
        protected Double doInBackground(Integer... integers) {
            int i= integers[0];
            while (i<=integers[1]){
                try {
                    Thread.sleep(integers[2]);
                    publishProgress("Hola mundo!\n ");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            txtView.append(values[0]);
        }

        @Override
        protected void onPostExecute(Double aDouble) {
            super.onPostExecute(aDouble);
            txtView.append("Fin del hilo");
        }
    }
}
