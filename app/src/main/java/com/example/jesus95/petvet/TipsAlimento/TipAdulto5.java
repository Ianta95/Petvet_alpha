package com.example.jesus95.petvet.TipsAlimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jesus95.petvet.Medallas.MedallaOroSiAdulto;
import com.example.jesus95.petvet.Medallas.NoMedallaCachorro;
import com.example.jesus95.petvet.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TipAdulto5 extends AppCompatActivity {
    View layout;
    int paseono = 0;
    String mleeraciertos;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_adulto5);

        getSupportActionBar().hide();

        layout = (View) findViewById(R.id.layout_vitaminas);

        layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    BufferedReader fin =
                            new BufferedReader(
                                    new InputStreamReader(
                                            openFileInput("preguntasadulto.txt")));

                    mleeraciertos = fin.readLine();
                    fin.close();
                    Log.e("Mylog", "Exito al leer aciertos");
                } catch (Exception ex) {
                    Log.e("Mylog", "Error al leer aciertos");
                }

                paseono = Integer.parseInt(mleeraciertos);


                if (paseono < 2) {
                    intent = new Intent(TipAdulto5.this, NoMedallaCachorro.class);
                } else {
                    intent = new Intent(TipAdulto5.this, MedallaOroSiAdulto.class);
                }
                startActivity(intent);
                finish();

            }



        });


    }
}
