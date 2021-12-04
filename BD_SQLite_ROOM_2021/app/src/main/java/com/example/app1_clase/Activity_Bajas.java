package com.example.app1_clase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import BaseDatos.EscuelaBD;
import Entidades.Alumno;

public class Activity_Bajas extends Activity {
    EditText noControl,nombre,primerap,segundaAp,carrera;
    EditText edad=null;
    EditText semestre=null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bajas);
        noControl=findViewById(R.id.caja_num_comtrol_bajas);
    }
    public void busquedaBajas(View v){
        if(noControl.getText().toString().isEmpty()==false) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Alumno alu=null;
                    EscuelaBD conexionBD=EscuelaBD.gettAppDatabase(getBaseContext());
                    alu = conexionBD.alumnoDAO().optenerUno(noControl.getText().toString());
                    if(alu!=null){
                        System.out.println(alu.getNombre().toString());

                    }else{
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"El registro NO existe",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                }
            }).start();
        }
    }
    public void borrar(View v){
        if(noControl.getText().toString().isEmpty()==false) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    EscuelaBD conexionBD=EscuelaBD.gettAppDatabase(getBaseContext());
                    conexionBD.alumnoDAO().eliminarPorNumControl(noControl.getText().toString());
                }
            }).start();
        }
    }
}
