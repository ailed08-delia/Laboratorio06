package com.example.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText texto;
    Button coment;
    Button cance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texto = (EditText)findViewById(R.id.latitud);
        coment= (Button) findViewById(R.id.guardar);
        cance= (Button) findViewById(R.id.cancelar);
        texto.setText(leerValoracion());

    }
    private String leerValoracion(){
        SharedPreferences sp = getSharedPreferences("Valoracion",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sp.edit();
        String s1 = sp.getString("comentario", "");
        return s1;
    }

    private void guardarValoracion( String comentario){
        SharedPreferences sp = getSharedPreferences("Valoracion",MODE_PRIVATE);
        SharedPreferences.Editor myEdit = sp.edit();
        myEdit.putString("comentario", comentario);
        myEdit.commit();
    }

    @Override
    protected void onPause() {
        super.onPause();
        guardarValoracion(texto.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        guardarValoracion(texto.getText().toString());
    }
}