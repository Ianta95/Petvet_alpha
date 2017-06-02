package com.example.jesus95.petvet.Guias;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.jesus95.petvet.R;
import com.example.jesus95.petvet.TipsAlimento.TipAdulto1;
import com.example.jesus95.petvet.TipsAlimento.TipAdulto3;
import com.example.jesus95.petvet.TipsAlimento.TipAdulto4;
import com.example.jesus95.petvet.models.PreguntasAdulto;
import com.example.jesus95.petvet.models.Tips;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GuiaInteractivaAdultos extends AppCompatActivity {

    Button respuesta1, respuesta2, respuesta3;
    TextView pregunta;
    Intent intent;


    private PreguntasAdulto mPreguntas = new PreguntasAdulto();
    private Tips mTips = new Tips();
    private String mRespuestas, mleeraciertos;
    private int mScore = 0, numpregunta = 0, mfallos = 0, mfinal = 0, mproceso = 0;
    private int mQuestionsLenght = mPreguntas.mQuestions.length;
    MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia_interactiva_adultos);
        getSupportActionBar().hide();

        respuesta1 = (Button) findViewById(R.id.btn_pregunta1);
        respuesta2 = (Button) findViewById(R.id.btn_pregunta2);
        respuesta3 = (Button) findViewById(R.id.btn_pregunta3);
        pregunta = (TextView) findViewById(R.id.texto_pregunta);

        //Definir archivo base
        try
        {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            openFileOutput("preguntasadulto.txt", Context.MODE_PRIVATE));

            fout.write(""+mScore);
            fout.close();
            Log.e("Mylog", "Se inicio archivo de registro, en: "+mScore);
        }
        catch (Exception e)
        {
            Log.e("Mylog", "Error al crear archivo");

        }
        //-------------------->



        Log.e("Mylog", "mQuestionlegth es :"+mQuestionsLenght);
        Log.e("Mylog","Se inicia con Procesos, mproceso es: "+mproceso);

        procesos();
        updateQuestion(numpregunta);


        respuesta1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                checarpregunta(respuesta1,mRespuestas);



            }

        });

        respuesta2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                checarpregunta(respuesta2,mRespuestas);



            }

        });

        respuesta3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                checarpregunta(respuesta3,mRespuestas);



            }

        });



    }

    private void updateQuestion(int n) {
        pregunta.setText(mPreguntas.getQuestion(n));
        respuesta1.setText(mPreguntas.getChoice1(n));
        respuesta2.setText(mPreguntas.getChoice2(n));
        respuesta3.setText(mPreguntas.getChoice3(n));

        mRespuestas = mPreguntas.getCorrectAnswer(n);

    }

    private void checarpregunta(Button respuesta, String Respuestas){
        if(respuesta.getText() == Respuestas){
            mScore++;
            mostrarcorrecto(numpregunta);
            numpregunta++;
            Log.e("Mylog","numpregunta es:"+numpregunta);
            if(numpregunta==2){
                mostrarfinal();
            }else {
                updateQuestion(numpregunta);
            }
        }else{
            mfallos++;
            mostrarerror(numpregunta);
            numpregunta++;
            Log.e("Mylog","numpregunta es:"+numpregunta);
            if(numpregunta==2){
                mostrarfinal();
            }else{
                updateQuestion(numpregunta);
            }

        }
    }

    private void mostrarerror(int n){
        materialDialog = new MaterialDialog.Builder(this)
                .title(R.string.opcion_incorrecta)
                .content(mTips.getTip(n))
                .positiveText("OK")
                .iconRes(R.drawable.erro)
                .limitIconToDefaultSize()
                .show();
    }




    public void mostrarcorrecto(int n){
        materialDialog = new MaterialDialog.Builder(this)
                .title(R.string.opcion_correcta)
                .content(mTips.getTip(n))
                .positiveText("OK")


                .iconRes(R.drawable.correcto)
                .limitIconToDefaultSize()
                .show();
    }

    public void procesos(){
        intent = new Intent(GuiaInteractivaAdultos.this, TipAdulto1.class);
        startActivity(intent);
        mproceso++;
    }



    public void mostrarfinal(){


        try
        {
            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("preguntasadulto.txt")));

            mleeraciertos = fin.readLine();
            fin.close();
            Log.e("Mylog", "Exito al leer aciertos");
        }
        catch (Exception ex)
        {
            Log.e("Mylog", "Error al leer aciertos");
        }

        mfinal = Integer.parseInt(mleeraciertos);
        mfinal = mfinal + mScore;

        try
        {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            openFileOutput("preguntasadulto.txt", Context.MODE_PRIVATE));

            fout.write(""+mfinal);
            fout.close();
            Log.e("Mylog", "Se logro escribir mfinal con: "+mfinal);
        }
        catch (Exception e)
        {
            Log.e("Mylog", "Error al escribir fichero a memoria interna");

        }



        intent = new Intent(GuiaInteractivaAdultos.this, TipAdulto3.class);
        startActivity(intent);
        finish();

    }//final else

}
