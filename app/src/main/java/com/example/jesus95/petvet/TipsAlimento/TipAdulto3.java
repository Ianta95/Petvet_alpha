package com.example.jesus95.petvet.TipsAlimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jesus95.petvet.R;

public class TipAdulto3 extends AppCompatActivity {
    View layout;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_adulto3);
        getSupportActionBar().hide();

        layout = (View) findViewById(R.id.layout_platoyhueso);

        layout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                intent = new Intent(TipAdulto3.this, TipAdulto4.class);
                startActivity(intent);
                finish();
            }

        });
    }
}
