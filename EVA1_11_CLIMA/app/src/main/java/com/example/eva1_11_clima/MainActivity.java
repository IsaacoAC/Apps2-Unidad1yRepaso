package com.example.eva1_11_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class MainActivity extends AppCompatActivity {
    ListView lstVwCLima;
    List<Wheater> lstCiudades = new ArrayList<>();
    /*Wheater[] cities = {
        new Wheater("chihuahua", 22, "nublado", R.drawable.cloudy),
            new Wheater("Juarez", 0, "Nevado", R.drawable.snow),
            new Wheater("Madera", -5, "Nevado", R.drawable.snow),
            new Wheater("Mexicali", 38, "Soleado", R.drawable.sunny),
            new Wheater("Mazatlan", 28, "Soleado", R.drawable.sunny),
            new Wheater("Ojinaga", 15, "Peligro de Tornado", R.drawable.tornado),
            new Wheater("Parral", 13, "Tormenta Electrica", R.drawable.thunderstorm),
            new Wheater("Zacatecas", 20, "Probabilidad de lluvia", R.drawable.light_rain),
            new Wheater("Merida", 32, "Soleado", R.drawable.sunny),
            new Wheater("Veracruz", 22, "Lluvioso", R.drawable.rainy),
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVwCLima = findViewById(R.id.lstVwClima);

        NukeSSLCerts.nuke();//Ignorar los certificados

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=439d4b804bc8187953eb36d2a8c26a02",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("list");
                            for (int i=0;i< jsonArray.length();i++){
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Wheater wCiudad = new Wheater();
                                wCiudad.setCity(jsonObject.getString("name"));

                                JSONObject jsMain = jsonObject.getJSONObject("main");
                                wCiudad.setTemp((int)jsMain.getDouble("temp"));
                                JSONArray jaClima= jsonObject.getJSONArray("weather");
                                JSONObject joClima = jaClima.getJSONObject(0);
                                wCiudad.setDesc(joClima.getString("description"));

                                int iId= joClima.getInt("id");

                                if (iId<300){//tormentas
                                    wCiudad.setImage(R.drawable.thunderstorm);
                                }else if (iId<400){//lluvia ligera
                                    wCiudad.setImage(R.drawable.light_rain);
                                }else if (iId<600){//lluvia intensa
                                    wCiudad.setImage(R.drawable.rainy);
                                }else if (iId<700){//nieve
                                    wCiudad.setImage(R.drawable.snow);
                                }else if (iId<800){//despejado
                                    wCiudad.setImage(R.drawable.sunny);
                                }else if (iId<900){//nublado
                                    wCiudad.setImage(R.drawable.cloudy);
                                }else{
                                    wCiudad.setImage(R.drawable.tornado);
                                }
                                lstCiudades.add(wCiudad);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //aqui conectamos el adaptador
                        lstVwCLima.setAdapter(new WeatherAdapter(MainActivity.this,R.layout.mi_layout,lstCiudades));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);
        //lstVwCLima.setAdapter(new WeatherAdapter(this,R.layout.mi_layout,cities));
    }

    public static class NukeSSLCerts {
        protected static final String TAG = "NukeSSLCerts";

        public static void nuke() {
            try {
                TrustManager[] trustAllCerts = new TrustManager[] {
                        new X509TrustManager() {
                            public X509Certificate[] getAcceptedIssuers() {
                                X509Certificate[] myTrustedAnchors = new X509Certificate[0];
                                return myTrustedAnchors;
                            }

                            @Override
                            public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                            @Override
                            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                        }
                };

                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String arg0, SSLSession arg1) {
                        return true;
                    }
                });
            } catch (Exception e) {
            }
        }
    }

}
