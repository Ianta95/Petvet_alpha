package com.example.jesus95.petvet.PreguntasMultiples;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.jesus95.petvet.Medallas.MedallaOroAdulto;
import com.example.jesus95.petvet.Medallas.NoMedallaCachorro;
import com.example.jesus95.petvet.R;
import com.example.jesus95.petvet.models.PreguntasMultiplesOk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MultipleCachorro1 extends AppCompatActivity {
    Button botona, botonb, botonc, botond, botone, botonf;
    private PreguntasMultiplesOk mPreguntas = new PreguntasMultiplesOk();
    int n = 0, seleccionescorrectas = 0, fails = 0, paseono=0;
    String mleeraciertos;
    String mRespuesta1;
    String mRespuesta2;
    TextView pregunta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_cachorro1);
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
                cambiarboton(botona, mRespuesta1, mRespuesta2);
                seleccionescorrectas++;
                finalizar(botona, mRespuesta1, mRespuesta2);

            }
        });

        botonb.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonb, mRespuesta1, mRespuesta2);
                seleccionescorrectas++;
                finalizar(botona, mRespuesta1, mRespuesta2);


            }
        });

        botonc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonc, mRespuesta1, mRespuesta2);
                fails++;
                finalizar(botona, mRespuesta1, mRespuesta2);


            }
        });

        botond.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botond, mRespuesta1, mRespuesta2);
                fails++;
                finalizar(botona, mRespuesta1, mRespuesta2);


            }
        });

        botone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botone, mRespuesta1, mRespuesta2);
                fails++;
                finalizar(botona, mRespuesta1, mRespuesta2);


            }
        });

        botonf.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                cambiarboton(botonf, mRespuesta1, mRespuesta2);
                fails++;
                finalizar(botona, mRespuesta1, mRespuesta2);


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

        mRespuesta1 = mPreguntas.getCorrectAnswer1(n);
        mRespuesta2 = mPreguntas.getCorrectAnswer2(n);



    }



    public void cambiarboton(Button opcion, String respuestax, String respuestay){
        if((respuestax == opcion.getText()) || (respuestay == opcion.getText())){
            opcion.setText("¡Correcto!");
            opcion.setBackgroundColor(Color.YELLOW);
        }else{
            opcion.setText("¡UPS! INCORRECTO");
            opcion.setBackgroundColor(Color.RED);
        }
    }

    public void finalizar(Button opcion, String respuestax, String respuestay) {

        Intent intent;


        if((seleccionescorrectas == 2) || (fails == 3)){
            Log.e("Mylog","se activo juzgado "+paseono);
            try
            {
                BufferedReader fin =
                        new BufferedReader(
                                new InputStreamReader(
                                        openFileInput("preguntascachorro.txt")));

                mleeraciertos = fin.readLine();
                fin.close();
                Log.e("Mylog", "Exito al leer aciertos");
            }
            catch (Exception ex)
            {
                Log.e("Mylog", "Error al leer aciertos");
            }

            paseono = Integer.parseInt(mleeraciertos);
            if(seleccionescorrectas==2){
                Log.e("Mylog","paseono tenia "+paseono);
                paseono++;
                Log.e("Mylog","ahora tiene "+paseono);
            }

            if(paseono < 6){
                intent = new Intent(MultipleCachorro1.this, NoMedallaCachorro.class);
            }else{
                intent = new Intent(MultipleCachorro1.this, MedallaOroAdulto.class);
            }
            startActivity(intent);
            finish();
        }

    }
}
