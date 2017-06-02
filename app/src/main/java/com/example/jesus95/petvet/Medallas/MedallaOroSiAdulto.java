package com.example.jesus95.petvet.Medallas;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.jesus95.petvet.R;

import java.io.OutputStreamWriter;

public class MedallaOroSiAdulto extends AppCompatActivity {
    View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medalla_oro_si_adulto);
        getSupportActionBar().hide();

        layout = (View) findViewById(R.id.layout_oroadultos);

        try
        {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            openFileOutput("medallasalimento.txt", Context.MODE_PRIVATE));

            fout.write("1");
            fout.close();
            Log.e("Mylog", "Se logro escribir");
        }
        catch (Exception e)
        {
            Log.e("Mylog", "Error al escribir fichero a memoria interna");

        }


        layout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                finish();
            }

        });

    }
}
