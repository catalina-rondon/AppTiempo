package com.example.apptiempo;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FormularioActivity extends AppCompatActivity implements View.OnClickListener{
    EditText txtLatitud, txtLongitud, txtNombre, txtMail;
    ImageButton btnbuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario);
        txtLatitud = findViewById(R.id.txtLatitud);
        txtLongitud = findViewById(R.id.txtLongitud);
        txtNombre = findViewById(R.id.txtNombre);
        txtMail = findViewById(R.id.txtEmail);
        btnbuscar = findViewById(R.id.btnbuscar);

        btnbuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FormularioActivity.this, MostrarActivity.class);
                intent.putExtra("Nombre", txtNombre.getText().toString());
                intent.putExtra("Email", txtMail.getText().toString());
                intent.putExtra("Latitud", txtLatitud.getText().toString());
                intent.putExtra("Longitud", txtLongitud.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
