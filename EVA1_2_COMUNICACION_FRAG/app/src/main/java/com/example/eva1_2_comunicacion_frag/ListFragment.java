package com.example.eva1_2_comunicacion_frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;


public class ListFragment extends Fragment {

    //DATOS DE LA LISTA
    String[] datos={
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "octubre",
            "Noviembre",
            "diciembre",
            "Enero2",
            "Enero3",
            "Enero4",
            "Enero5",
            "Enero6",
            "Enero7"
    };

    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main= (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout= (FrameLayout)inflater.inflate(R.layout.fragment_list, container, false);
        //AQUI LLENAMOS LA LISTA
        final ListView llstVwDatos;
        llstVwDatos = frameLayout.findViewById(R.id.lstVwDatos);
        llstVwDatos.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                datos
        ));
        //evento
        llstVwDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //AQUI VA EL CODIGO
                main.onMessageFromFragmentToMain("Lista",datos[position]);

            }
        });
        //-----------------------
        return frameLayout;
    }
}
