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
import com.example.jesus95.petvet.PreguntasMultiples.MultipleCachorro1;
import com.example.jesus95.petvet.R;
import com.example.jesus95.petvet.TipsAlimento.Tip1;
import com.example.jesus95.petvet.TipsAlimento.Tip2;
import com.example.jesus95.petvet.models.PreguntasCachorro;
import com.example.jesus95.petvet.models.Tips;

import java.io.OutputStreamWriter;

public class GuiaInteractivaCachorros extends AppCompatActivity {

    Button respuesta1, respuesta2, respuesta3;
    TextView pregunta1;


    private PreguntasCachorro mPreguntas = new PreguntasCachorro();
    private Tips mTips = new Tips();
    private String mRespuestas, mMostrarTip;
    private int mScore = 0, numpregunta = 0, mfallos = 0;
    private int mQuestionsLenght = mPreguntas.mQuestions.length;
    MaterialDialog materialDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guia_interactiva_cachorros);
        getSupportActionBar().hide();

        respuesta1 = (Button) findViewById(R.id.btn_pregunta1);
        respuesta2 = (Button) findViewById(R.id.btn_pregunta2);
        respuesta3 = (Button) findViewById(R.id.btn_pregunta3);


        pregunta1 = (TextView) findViewById(R.id.texto_pregunta1);





        updateQuestion(numpregunta);


        respuesta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (respuesta1.getText() == mRespuestas) {
                    mostrarcorrecto(numpregunta);
                    mScore++;
                    numpregunta++;
                    updateQuestion(numpregunta);

                } else {
                    mostrarerror(numpregunta);
                    mfallos++;
                    numpregunta++;
                    updateQuestion(numpregunta);

                }

            }
        });

        respuesta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (respuesta2.getText() == mRespuestas) {
                    mostrarcorrecto(numpregunta);
                    mScore++;
                    numpregunta++;
                    updateQuestion(numpregunta);


                } else {
                    mostrarerror(numpregunta);
                    mfallos++;
                    numpregunta++;
                    updateQuestion(numpregunta);

                }

            }
        });

        respuesta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (respuesta3.getText() == mRespuestas) {
                    mostrarcorrecto(numpregunta);
                    mScore++;
                    numpregunta++;
                    updateQuestion(numpregunta);

                } else {
                    mostrarerror(numpregunta);
                    mfallos++;
                    numpregunta++;
                    updateQuestion(numpregunta);

                }

            }

        });


    }

    private void updateQuestion(int n) {
        if (n < (mQuestionsLenght)) {
            pregunta1.setText(mPreguntas.getQuestion(n));
            respuesta1.setText(mPreguntas.getChoice1(n));
            respuesta2.setText(mPreguntas.getChoice2(n));
            respuesta3.setText(mPreguntas.getChoice3(n));

            mRespuestas = mPreguntas.getCorrectAnswer(n);
            switch (n){
                case 2:
                    startActivity(new Intent(GuiaInteractivaCachorros.this, Tip1.class));
                    break;
                case 4:
                    startActivity(new Intent(GuiaInteractivaCachorros.this, Tip2.class));
                    break;
            }

        }else{
            mostrarfinal(n);
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

    private void mostrarfinal(int n){

        try
        {
            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            openFileOutput("preguntascachorro.txt", Context.MODE_PRIVATE));

            fout.write(""+mScore);
            fout.close();
            Log.e("Mylog", "Se logro guardar los aciertos, son: "+mScore);
        }
        catch (Exception e)
        {
            Log.e("Mylog", "Error al guardar aciertos");

        }




        Intent intent = new Intent(GuiaInteractivaCachorros.this, MultipleCachorro1.class);
        startActivity(intent);
        finish();

    }

}
