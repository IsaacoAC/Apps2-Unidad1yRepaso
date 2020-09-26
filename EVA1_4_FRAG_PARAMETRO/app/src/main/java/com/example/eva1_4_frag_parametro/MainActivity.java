package com.example.eva1_4_frag_parametro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void crearFrag (View v){
        //transaccion
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //crear el fragment
        paramFragment paramFragment = com.example.eva1_4_frag_parametro.paramFragment.newInstance("Hola mundo","Valores asigndaods al fragmento");

        //reemplazar nuestro layout con el fragment
        ft.replace(R.id.frmlytFrag,paramFragment);
        //commit
        ft.commit();
    }
}
