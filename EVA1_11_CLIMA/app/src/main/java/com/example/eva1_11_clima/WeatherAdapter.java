package com.example.eva1_11_clima;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class WeatherAdapter extends ArrayAdapter<Wheater>{
   // private Wheater[] objects;
    private List<Wheater> objects;
    private Context context;
    private int resource;
    public WeatherAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.objects=objects;
        this.context = context;
        this.resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){ //PRIMERA VEZ QUE SE EJECUTA LA APLICACION, HAY QUE CREAR EL LAYOUT
            convertView = ((Activity)context).getLayoutInflater().inflate(resource,parent,false);
        }
        //HAY QUE RECUPERAR LOS COMPONENTES
        ImageView imgVwClima;
        TextView txtVwCity;
        TextView txtVwTemp;
        TextView txtVwDesc;

        imgVwClima = convertView.findViewById(R.id.imgVwClima);
        txtVwCity = convertView.findViewById(R.id.txtVwCity);
        txtVwDesc = convertView.findViewById(R.id.txtVwDesc);
        txtVwTemp = convertView.findViewById(R.id.txtVwTemp);
        //conexion
        Wheater weather = objects.get(position);
        imgVwClima.setImageResource(weather.getImage());
        txtVwCity.setText(weather.getCity());
        txtVwTemp.setText("" + weather.getTemp());
        txtVwDesc.setText(weather.getDesc());

        return convertView;
    }
}
