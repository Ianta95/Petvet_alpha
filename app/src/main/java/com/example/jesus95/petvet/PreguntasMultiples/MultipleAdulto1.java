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
import com.example.jesus95.petvet.TipsAlimento.TipAdulto2;
import com.example.jesus95.petvet.models.PreguntasMultiplesOk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MultipleAdulto1 extends AppCompatActivity {

    Intent intent;

    Button botona, botonb, botonc, botond, botone, botonf;
    private PreguntasMultiplesOk mPreguntas = new PreguntasMultiplesOk();
    int n = 1, seleccionescorrectas = 0, fails = 0, paseono=0;
    String mleeraciertos;
    String mRespuesta1;
    String mRespuesta2;
    String mRespuesta3;
    TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_adulto1);
        getSupportActionBar().hide();

        pregunta = (TextView) findViewById(R.id.texto_pregunta);
        botona = (Button) findViewById(R.id.buttonA);
        botonb = (Button) findViewById(R.id.buttonB);
        botonc = (Button) findViewById(R.id.buttonC);
        botond = (Button) findViewById(R.id.buttonD);
        botone = (Button) findViewById(R.id.buttonE);
        botonf = (Button) findViewById(R.id.buttonF);

        updateQuestion(n);

        botona.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botona, mRespuesta1, mRespuesta2, mRespuesta3);
                fails++;
                finalizar(botona, mRespuesta1, mRespuesta2, mRespuesta3);
                Log.e("Mylog", "Fails subio a :"+fails);

            }
        });

        botonb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonb, mRespuesta1, mRespuesta2, mRespuesta3);
                seleccionescorrectas++;
                finalizar(botona, mRespuesta1, mRespuesta2, mRespuesta3);
                Log.e("Mylog", "Seleccion subio a :"+seleccionescorrectas);


            }
        });

        botonc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonc, mRespuesta1, mRespuesta2, mRespuesta3);
                seleccionescorrectas++;
                finalizar(botona, mRespuesta1, mRespuesta2, mRespuesta3);
                Log.e("Mylog", "Seleccion subio a :"+seleccionescorrectas);


            }
        });

        botond.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botond, mRespuesta1, mRespuesta2, mRespuesta3);
                fails++;
                finalizar(botona, mRespuesta1, mRespuesta2, mRespuesta3);
                Log.e("Mylog", "Fails subio a :"+fails);


            }
        });

        botone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botone, mRespuesta1, mRespuesta2, mRespuesta3);
                seleccionescorrectas++;
                finalizar(botona, mRespuesta1, mRespuesta2, mRespuesta3);
                Log.e("Mylog", "Seleccion subio a :"+seleccionescorrectas);


            }
        });

        botonf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonf, mRespuesta1, mRespuesta2, mRespuesta3);
                fails++;
                finalizar(botona, mRespuesta1, mRespuesta2, mRespuesta3);
                Log.e("Mylog", "Fails subio a :"+fails);


            }
        });

    }

    private void updateQuestion(int n) {
        pregunta.setText(mPreguntas.getQuestion(n));
        botona.setText(mPreguntas.getChoice1(n));
        botonb.setText(mPreguntas.getChoice2(n));
        botonc.setText(mPreguntas.getChoice3(n));
        botond.setText(mPreguntas.getChoice4(n));
        botone.setText(mPreguntas.getChoice5(n));
        botonf.setText(mPreguntas.getChoice6(n));

        mRespuesta1 = mPreguntas.getCorrectAnswer3(n);
        mRespuesta2 = mPreguntas.getCorrectAnswer4(n);
        mRespuesta3 = mPreguntas.getCorrectAnswer5(n);



    }






    public void cambiarboton(Button opcion, String respuestax, String respuestay, String respuestaz){
        if((respuestax == opcion.getText()) || (respuestay == opcion.getText()) || (respuestaz == opcion.getText())){
            opcion.setText("¡Correcto!");
            opcion.setBackgroundColor(Color.YELLOW);
        }else{
            opcion.setText("¡UPS! INCORRECTO");
            opcion.setBackgroundColor(Color.RED);
        }
    }

    public void finalizar(Button opcion, String respuestaa, String respuestab, String respuestac){

        if((seleccionescorrectas == 3) || (fails == 2)) {
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
            if (seleccionescorrectas == 3) {
                Log.e("Mylog", "paseono tenia " + paseono);
                paseono++;
                Log.e("Mylog", "ahora tiene " + paseono);

                try
                {
                    OutputStreamWriter fout=
                            new OutputStreamWriter(
                                    openFileOutput("preguntasadulto.txt", Context.MODE_PRIVATE));

                    fout.write(""+paseono);
                    fout.close();
                    Log.e("Mylog", "Se logro escribir");
                }
                catch (Exception e)
                {
                    Log.e("Mylog", "Error al escribir fichero a memoria interna");

                }

            }





            intent = new Intent(MultipleAdulto1.this, TipAdulto2.class);
            startActivity(intent);
            finish();
        }
    }

}
