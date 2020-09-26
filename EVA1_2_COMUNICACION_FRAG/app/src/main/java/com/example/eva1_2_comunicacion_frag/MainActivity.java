package com.example.eva1_2_comunicacion_frag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1. RECUPERAR LOS FRAGMENTOS
    ListFragment lista;
    DataFragment datos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //2.ACCEDER A LOS FRAGMENTOS
    //HAY UN METODO QUE SE EJECUTA CUANDO UN FRAG SE VINCULA
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if (fragment.getClass()==ListFragment.class)
            lista = (ListFragment)fragment;
        else if (fragment.getClass()==DataFragment.class)
            datos= (DataFragment)fragment;
    }


    //INTERFAZ DE COMUNICACION
    public void onMessageFromFragmentToMain(String sender, String param){
        if(sender.equals("Lista")){//recibimos informacion
            //enviar al fragmento data
            datos.onMessageFromMainToFragment(param);

        }else if(sender.equals("Data")){
            //imprimir mensaje
            Toast.makeText(this,param,Toast.LENGTH_LONG).show();
        }
    }
}
