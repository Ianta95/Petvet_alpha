package com.example.jesus95.petvet.Medallas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jesus95.petvet.R;

public class NoMedallaCachorro extends AppCompatActivity {
    View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_medalla_cachorro);
        getSupportActionBar().hide();

        layout = (View) findViewById(R.id.layout_principal);

        layout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                finish();
            }

        });

    }
}
