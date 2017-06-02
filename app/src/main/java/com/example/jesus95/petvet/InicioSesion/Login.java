package com.example.jesus95.petvet.InicioSesion;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jesus95.petvet.MenuPrincipal;
import com.example.jesus95.petvet.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Login extends AppCompatActivity {
    @BindView(R.id.btn_logindos)
    Button btn_logindos;
    private FirebaseAuth mAuth;
    private EditText textEmail;
    private EditText texPass;
    private Button btnRegister;
    private ProgressDialog progressDialog;
    private FirebaseAuth.AuthStateListener mAuthListener;

    public Login() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        btn_logindos.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, MenuPrincipal.class);
                startActivity(intent);
            }

        });


        /*progressDialog = new ProgressDialog(this);
        textEmail = (EditText) findViewById(R.id.et_email);
        texPass = (EditText) findViewById(R.id.et_password);
        btnRegister = (Button) findViewById(R.id.btn_logindos);
        mAuth = FirebaseAuth.getInstance();



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doLogin();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    Toast.makeText(Login.this, "Bienvenido a Petvet", Toast.LENGTH_SHORT).show();
                    mAuth.signOut();

                }
            }
        };

    }

    @Override
    protected void onStart(){
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void doLogin(){
        String email = textEmail.getText().toString().trim();
        String password = texPass.getText().toString().trim();

        if (!TextUtils.isEmpty(email) && !TextUtils.isEmpty(password)){
            progressDialog.setMessage("Espere un momento");
            progressDialog.show();
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener (new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()){
                                Intent intent = new Intent(Login.this, MenuPrincipal.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(Login.this, "Verifica tu email y contraseña", Toast.LENGTH_SHORT).show();

                            }
                        }
                    });
        }*/
    }

}
