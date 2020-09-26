package com.example.eva1_4_frag_parametro;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


public class paramFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    //ATRIBUTOS DE NUESTRA CLASE
    private String mParam1;
    private String mParam2;



    public paramFragment() {
        // Required empty public constructor
    }

  // TODO: Rename and change types and number of parameters
    public static paramFragment newInstance(String param1, String param2) {
        paramFragment fragment = new paramFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);//EXTRAS NOMBRE|VALOR
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout = (FrameLayout)inflater.inflate(R.layout.fragment_param, container, false);
        TextView txtVwDatos = frameLayout.findViewById(R.id.txtVwDatos);
        //Asigno los argumentos mParam1 y mParam2
        txtVwDatos.append("\n");
        txtVwDatos.append(mParam1);
        txtVwDatos.append("\n");
        txtVwDatos.append(mParam2);
        return frameLayout;
    }


}
