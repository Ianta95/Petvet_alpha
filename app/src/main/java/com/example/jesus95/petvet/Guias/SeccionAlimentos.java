package com.example.jesus95.petvet.Guias;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.jesus95.petvet.R;
import com.marcok.stepprogressbar.StepProgressBar;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SeccionAlimentos extends AppCompatActivity {

    StepProgressBar mStepProgressBar;
    Button mback, mcachorros, madultos;
    int mProgreso = -1;
    String leermedallaalimento;
    MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seccion_alimentos);
        getSupportActionBar().hide();

        try
        {
            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("medallasalimento.txt")));

            leermedallaalimento = fin.readLine();
            fin.close();
            Log.e("Mylog", "Exito al leer fichero medallasalimento.txt");
        }
        catch (Exception ex)
        {
            Log.e("Mylog", "Error al leer fichero medallasalimento.txt");
        }

        mProgreso = Integer.parseInt(leermedallaalimento);

        //controlmenu();


        mStepProgressBar = (StepProgressBar) findViewById(R.id.stepProgressBar);
        mStepProgressBar.setCurrentProgressDot(mProgreso);

        mback = (Button) findViewById(R.id.btn_back);
        mcachorros = (Button) findViewById(R.id.btn_cachorros);
        madultos = (Button) findViewById(R.id.btn_adultos);

        controlmenu();

        mback.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                finish();
            }

        });


        madultos.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if(mProgreso==-1){
                    mostrarbloqueado();
                }else{
                    Intent intent = new Intent(SeccionAlimentos.this, GuiaInteractivaAdultos.class);
                    startActivity(intent);
                }
            }

        });


        mcachorros.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(SeccionAlimentos.this, GuiaInteractivaCachorros.class);
                startActivity(intent);
                //leer registro
                try
                {
                    BufferedReader fin =
                            new BufferedReader(
                                    new InputStreamReader(
                                            openFileInput("medallasalimento.txt")));

                    leermedallaalimento = fin.readLine();
                    fin.close();
                    Log.e("Mylog", "Exito al leer fichero medallasalimento.txt");
                }
                catch (Exception ex)
                {
                    Log.e("Mylog", "Error al leer fichero medallasalimento.txt");
                }
                //asignar
                mStepProgressBar.setCurrentProgressDot(mProgreso);
            }



        });



    }

    public void controlmenu(){
        switch (mProgreso){
            case 0:
                mcachorros.setBackgroundColor(Color.RED);
                mcachorros.setText("COMPLETADO CACHORROS");
                break;
            case -1:
                madultos.setBackgroundColor(Color.parseColor("#b9b8b8"));
                madultos.setText("BLOQUEADO");
                break;
            case 1:
                mcachorros.setBackgroundColor(Color.RED);
                mcachorros.setText("COMPLETADO CACHORROS");
                madultos.setBackgroundColor(Color.RED);
                madultos.setText("COMPLETADO ADULTOS");

        }
    }

    public void mostrarbloqueado(){
        materialDialog = new MaterialDialog.Builder(this)
                .title("!UPS¡")
                .content(R.string.bloqueadoadulto)
                .positiveText("OK")


                .iconRes(R.drawable.perrito_triste)
                .limitIconToDefaultSize()
                .show();
    }
}
