package com.example.jesus95.petvet.Guias;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.jesus95.petvet.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuGuias extends Fragment {

    Button btnalimentacion, btnsalud, btnpopo, btnpaseo;
    MaterialDialog materialDialog;



    public MenuGuias() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu_guias, container, false);

        btnalimentacion = (Button) view.findViewById(R.id.btn_alimentacion);
        btnsalud = (Button) view.findViewById(R.id.btn_salud);
        btnpopo = (Button) view.findViewById(R.id.btn_necesidades);
        btnpaseo = (Button) view.findViewById(R.id.btn_paseo);

        btnalimentacion.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Intent intent = new Intent(getActivity(), SeccionAlimentos.class);
                startActivity(intent);
            }

        });

        btnpaseo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                mostrarbloqueado();
            }

        });

        btnsalud.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                mostrarbloqueado();
            }

        });

        btnpopo.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                mostrarbloqueado();
            }

        });

        // Inflate the layout for this fragment
        return view;
    }


    public void mostrarbloqueado(){
        materialDialog = new MaterialDialog.Builder(getContext())
                .title("!UPS¡")
                .content("Esta seccion esta bloqueada! inicia con alimentacion")
                .positiveText("OK")


                .iconRes(R.drawable.perrito_triste)
                .limitIconToDefaultSize()
                .show();
    }

}
