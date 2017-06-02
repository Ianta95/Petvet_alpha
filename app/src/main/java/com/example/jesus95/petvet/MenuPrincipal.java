package com.example.jesus95.petvet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.afollestad.materialdialogs.MaterialDialog;
import com.example.jesus95.petvet.AgendarCita.BlankFragment;
import com.example.jesus95.petvet.Guias.MenuGuias;
import com.example.jesus95.petvet.Perfil.Perfil;

import java.io.OutputStreamWriter;
import java.lang.reflect.Field;

public class MenuPrincipal extends AppCompatActivity {
    //Asignas el propio ITEM
    MenuItem item;
    BlankFragment agendarCita = new BlankFragment();
    Perfil perfil = new Perfil();
    MenuGuias guiaMenu = new MenuGuias();
    int mProgresoGuia = 0, mNivelGuia = 0, mfaseguia = 0;
    MaterialDialog materialDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        getSupportActionBar().hide();





        //LLamar metodo y BottomNavigationView
        final BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        disableShiftMode(bottomNavigationView);

        // Crear nuevo fragment y su transaccion (No funciono)
        //final Fragment guiainteractiva = new BlankFragment();
        //FragmentTransaction transaction = getFragmentManager().beginTransaction();



        fGuiaMenu();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                        if (item != null) {
                            item.setEnabled(true);
                        }
                        item = menuItem;
                        item.setEnabled(false);


                        switch (item.getItemId()) {
                            case R.id.action_calendario:
                                fAgendarCita();
                                break;


                            case R.id.action_perfil:
                                fPerfil();
                                break;

                            case R.id.action_guias:
                                fGuiaMenu();

                                break;

                            case R.id.action_radar:
                                mostrarVariables();
                                //abrir medalla en -1
                                try
                                {
                                    OutputStreamWriter fout=
                                            new OutputStreamWriter(
                                                    openFileOutput("medallasalimento.txt", Context.MODE_PRIVATE));

                                    fout.write("-1");
                                    fout.close();
                                    Log.e("Mylog", "Se logro escribir");
                                }
                                catch (Exception e)
                                {
                                    Log.e("Mylog", "Error al escribir fichero a memoria interna");

                                }

                                break;

                        }
                        return true;
                    }
                });


    }


    //Desactivando animacion de la Buttom Navigation Bar
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    }




    public void fAgendarCita() {
        FragmentManager manager = getSupportFragmentManager();
        agendarCita = new BlankFragment();
        manager.beginTransaction().replace(R.id.contenedor1, agendarCita).commit();
    }

    public void fGuiaMenu() {
        FragmentManager manager = getSupportFragmentManager();
        guiaMenu = new MenuGuias();
        manager.beginTransaction().replace(R.id.contenedor1, guiaMenu).commit();
    }

    public void fPerfil() {
        FragmentManager manager = getSupportFragmentManager();
        perfil = new Perfil();
        manager.beginTransaction().replace(R.id.contenedor1, perfil).commit();
    }

    private void mostrarVariables(){
        materialDialog = new MaterialDialog.Builder(this)
                .title("Variables")
                .content("Las variables son: Nivel: "+mNivelGuia+" y Progreso: "+mProgresoGuia+" \nFaseguia: "+mfaseguia)
                .positiveText("OK")
                .show();
    }
}
