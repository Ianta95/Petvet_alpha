package com.example.jesus95.petvet.TipsAlimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jesus95.petvet.PreguntasMultiples.MultipleAdulto2;
import com.example.jesus95.petvet.R;

public class TipAdulto4 extends AppCompatActivity {
    View layout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_adulto4);
            getSupportActionBar().hide();

            layout = (View) findViewById(R.id.layout_correconperro);

            layout.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view){
                    intent = new Intent(TipAdulto4.this, MultipleAdulto2.class);
                    startActivity(intent);
                    finish();
                }

            });
        }
}
