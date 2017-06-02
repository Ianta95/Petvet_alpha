package com.example.jesus95.petvet.Perfil;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jesus95.petvet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class Perfil extends Fragment {

    Button btn_edit_perfil;

    public Perfil() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        btn_edit_perfil = (Button) view.findViewById(R.id.btn_edit_perfil);

        btn_edit_perfil.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), FormarPerfil.class);
                startActivity(intent);
            }

        });

        // Inflate the layout for this fragment
        return view;
    }

}
