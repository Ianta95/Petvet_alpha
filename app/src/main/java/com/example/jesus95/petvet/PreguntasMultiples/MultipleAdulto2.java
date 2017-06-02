package com.example.jesus95.petvet.PreguntasMultiples;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jesus95.petvet.R;
import com.example.jesus95.petvet.TipsAlimento.TipAdulto5;
import com.example.jesus95.petvet.models.PreguntasMultiplesOk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MultipleAdulto2 extends AppCompatActivity {
    Intent intent;

    Button botona, botonb, botonc, botond;
    private PreguntasMultiplesOk mPreguntas = new PreguntasMultiplesOk();
    int n = 2, seleccionescorrectas = 0, fails = 0, paseono=0;
    String mleeraciertos;
    String mRespuesta1;
    String mRespuesta2;
    TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_adulto2);
        getSupportActionBar().hide();

        pregunta = (TextView) findViewById(R.id.texto_pregunta);
        botona = (Button) findViewById(R.id.buttonA);
        botonb = (Button) findViewById(R.id.buttonB);
        botonc = (Button) findViewById(R.id.buttonC);
        botond = (Button) findViewById(R.id.buttonD);

        intent = new Intent(MultipleAdulto2.this, TipAdulto5.class);

        botona.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botona, mRespuesta1, mRespuesta2);
                fails++;
                Log.e("Mylog","fails esta en: "+fails);
                finalizar();
                if(seleccionescorrectas==2){
                    startActivity(intent);
                    finish();
                }
                if(fails==1){
                    startActivity(intent);
                    finish();
                }

            }
        });

        botonb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonb, mRespuesta1, mRespuesta2);
                seleccionescorrectas++;
                Log.e("Mylog","seleccionescorrectas esta en: "+seleccionescorrectas);
                finalizar();
                if(seleccionescorrectas==2){
                    startActivity(intent);
                    finish();
                }
                if(fails==1){
                    startActivity(intent);
                    finish();
                }


            }
        });

        botonc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonc, mRespuesta1, mRespuesta2);
                fails++;
                Log.e("Mylog","fails esta en: "+fails);
                finalizar();
                if(seleccionescorrectas==2){
                    startActivity(intent);
                    finish();
                }
                if(fails==1){
                    startActivity(intent);
                    finish();
                }


            }
        });

        botond.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botond, mRespuesta1, mRespuesta2);
                seleccionescorrectas++;
                Log.e("Mylog","seleccionescorrectas esta en: "+seleccionescorrectas);
                finalizar();
                if(seleccionescorrectas==2){
                    startActivity(intent);
                    finish();
                }
                if(fails==1){
                    startActivity(intent);
                    finish();
                }


            }
        });


        updateQuestion(n);

    }

    private void updateQuestion(int n) {
        pregunta.setText(mPreguntas.getQuestion(n));
        botona.setText(mPreguntas.getChoice1(n));
        botonb.setText(mPreguntas.getChoice2(n));
        botonc.setText(mPreguntas.getChoice3(n));
        botond.setText(mPreguntas.getChoice4(n));

        mRespuesta1 = mPreguntas.getCorrectAnswer6(n);
        mRespuesta2 = mPreguntas.getCorrectAnswer7(n);


    }

    public void cambiarboton(Button opcion, String respuestaa, String respuestab ){
        if((respuestaa == opcion.getText()) || (respuestab == opcion.getText()) ){
            opcion.setText("¡Correcto!");
            opcion.setBackgroundColor(Color.YELLOW);
        }else{
            opcion.setText("¡UPS! INCORRECTO");
            opcion.setBackgroundColor(Color.RED);
        }
    }

    public void finalizar(){

        if((seleccionescorrectas == 2) || (fails == 1)) {
            Log.e("Mylog", "se activo juzgado " + paseono);
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
            if (seleccionescorrectas == 2) {
                Log.e("Mylog", "paseono tenia " + paseono);
                paseono++;
                Log.e("Mylog", "ahora tiene " + paseono);
            }

            try
            {
                OutputStreamWriter fout=
                        new OutputStreamWriter(
                                openFileOutput("preguntasadulto.txt", Context.MODE_PRIVATE));

                fout.write(""+paseono);
                fout.close();
                Log.e("Mylog", "Se logro escribir mfinal con: "+paseono);

            }
            catch (Exception e)
            {
                Log.e("Mylog", "Error al escribir fichero a memoria interna");

            }


        }

        Log.e("Mylog", "Omitio garrafalmente mi codigo");

    }



}


