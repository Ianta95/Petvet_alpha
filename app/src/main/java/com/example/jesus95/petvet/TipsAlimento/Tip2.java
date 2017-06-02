package com.example.jesus95.petvet.TipsAlimento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jesus95.petvet.R;

public class Tip2 extends AppCompatActivity {
    View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip2);
        getSupportActionBar().hide();

        layout = (View) findViewById(R.id.layout_platoagua);

        layout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                finish();
            }

        });

    }
}
