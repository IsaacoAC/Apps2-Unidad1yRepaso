package com.example.eva1_2_comunicacion_frag;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;


public class DataFragment extends Fragment {

    TextView txtVwDatos;
    MainActivity main;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main=(MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.fragment_data, container, false);
        txtVwDatos = linearLayout.findViewById(R.id.txtVwDatos);
        Button btnDatos= linearLayout.findViewById(R.id.btnBoton);
        btnDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.onMessageFromFragmentToMain("Data", "Mensaje del fragmento de datos");
            }
        });

        return linearLayout;
    }
//INTERFAZ DE COMUNICACION
    public void onMessageFromMainToFragment(String param){
        txtVwDatos.setText(param);
    }
}
