package com.example.lab06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab06.ui.login.LoginActivity;

public class Principal extends AppCompatActivity {
    Button feed;
    Button foro;
    Button sesion;
    Button coordenadas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        feed= (Button) findViewById(R.id.feed);
        foro= (Button) findViewById(R.id.foro);
        sesion= (Button) findViewById(R.id.sesion);
        coordenadas= (Button) findViewById(R.id.coordenadas);

        feed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Principal.this,MainActivity.class));
            }
        });
        foro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Principal.this,Foro.class));
            }
        });
        sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Principal.this, LoginActivity.class));
            }
        });
        coordenadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Principal.this, coordenadas.class));
            }
        });
    }
}