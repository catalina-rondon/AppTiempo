package com.example.apptiempo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import kotlin.contracts.Returns;

public class MostrarActivity extends AppCompatActivity implements View.OnClickListener{
    TextView txtNombre, txtMail, txtClima;
    String Nom, Mail, Lat, Lon;
    ImageButton botonRegresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar);

        txtNombre = findViewById(R.id.Nombre);
        txtMail = findViewById(R.id.Email);
        txtClima = findViewById(R.id.txtClima);
        botonRegresar = findViewById(R.id.btnRegresar);

        Bundle extra = getIntent().getExtras();

        Nom = extra.getString("Nombre");
        Mail = extra.getString("Email");
        Lat = extra.getString("Latitud");
        Lon = extra.getString("Longitud");


        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(
                        new Intent(
                                MostrarActivity.this,
                                FormularioActivity.class
                        )
                );
            }
        });

        LeerWs(Lat, Lon);
        AsignarValores();
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    private void LeerWs(final String lat, final String lon) {

        String url = "https://api.openweathermap.org/data/2.5/weather?lat=" +
                lat +
                "&lon=" +
                lon +
                "&appid=b3750728fe731c52fc354ccf2e97b8ac";

        StringRequest postResquest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    txtClima.setText(jsonObject.getString("weather"));

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Error", error.getMessage());
            }
        });
        Volley.newRequestQueue(this).add(postResquest);
    }

    private void AsignarValores(){
        txtNombre.setText(Nom);
        txtMail.setText(Mail);
    }
}
