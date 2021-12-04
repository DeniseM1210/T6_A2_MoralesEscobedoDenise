package com.example.app1_clase;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import BaseDatos.EscuelaBD;
import Entidades.Alumno;

public class Activity_Altas extends AppCompatActivity {
    EditText noControl,nombre,primerap,segundaAp,carrera;
    EditText edad=null;
    EditText semestre=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);
        noControl=findViewById(R.id.caja_numero_control);
        nombre=findViewById(R.id.Caja_nombre);
        primerap=findViewById(R.id.caja_primerAp);
        segundaAp=findViewById(R.id.caja_segundoAp);
        edad=findViewById(R.id.caja_edad);
        semestre=findViewById(R.id.caja_semestre);
        carrera=findViewById(R.id.caja_carrera);
    }
    public void agregarAlumno(View v){

        EscuelaBD conexionBD=EscuelaBD.gettAppDatabase(getBaseContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                String cad=edad.getText().toString();
                int edad=Integer.parseInt(cad);
                cad="";
                cad=semestre.getText().toString();
                int semestre =Integer.parseInt(cad);
                Alumno alu=new Alumno(noControl.getText().toString(),nombre.getText().toString(),primerap.getText().toString(),segundaAp.getText().toString(),(byte)edad,(byte)semestre,carrera.getText().toString());

                conexionBD.alumnoDAO().insertarAlumno(alu);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(),"Agregado con exito",Toast.LENGTH_LONG).show();

                    }
                });
            }
        }).start();


    }
}
