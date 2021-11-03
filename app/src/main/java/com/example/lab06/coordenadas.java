package com.example.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class coordenadas extends AppCompatActivity {
    EditText latitud;
    EditText longitud;
    Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordenadas);
        latitud = (EditText)findViewById(R.id.latitud);
        longitud = (EditText)findViewById(R.id.longitud);
        guardar= (Button) findViewById(R.id.guardar);
        latitud.setText(leerLatitud());
        longitud.setText(leerLongitud());
    }
    private String leerLatitud(){
        SharedPreferences sp = getSharedPreferences("Coordenadas",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sp.edit();
        String s1 = sp.getString("latitud", "");
        return s1;
    }
    private String leerLongitud(){
        SharedPreferences sp = getSharedPreferences("Coordenadas",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sp.edit();
        String s1 = sp.getString("longitud", "");
        return s1;
    }
    private void guardarLatitud( String comentario){
        SharedPreferences sp = getSharedPreferences("Coordenadas",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sp.edit();
        myEdit.putString("latitud", comentario);
        myEdit.commit();
    }
    private void guardarLongitud( String comentario){
        SharedPreferences sp = getSharedPreferences("Coordenadas",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sp.edit();
        myEdit.putString("longitud", comentario);
        myEdit.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        guardarLatitud(latitud.getText().toString());
        guardarLongitud(longitud.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        guardarLatitud(latitud.getText().toString());
        guardarLongitud(longitud.getText().toString());
    }
}