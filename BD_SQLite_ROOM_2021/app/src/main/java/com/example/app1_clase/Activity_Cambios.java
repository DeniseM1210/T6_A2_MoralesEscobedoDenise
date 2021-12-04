package com.example.app1_clase;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import BaseDatos.EscuelaBD;
import Entidades.Alumno;

public class Activity_Cambios extends Activity {
    EditText oControl,nombre,primerap,segundaAp,carrera,edad,semestre;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cambios);
        oControl=findViewById(R.id.caja_no_comtrol_cambios);
        nombre=findViewById(R.id.caja_nombre_cambios);
        primerap=findViewById(R.id.caja_primer_ap_cambios);
        segundaAp=findViewById(R.id.Segundo_ap_cambios);
        carrera=findViewById(R.id.caja_carrera_cambios);
        edad=findViewById(R.id.caja_edad_cambios);
        semestre=findViewById(R.id.caja_semestre_cambios);
    }
    public void buscar_cambios(View v){
        if(oControl.getText().toString().isEmpty()==false){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Alumno alu=null;
                    EscuelaBD conexionBD=EscuelaBD.gettAppDatabase(getBaseContext());
                    alu = conexionBD.alumnoDAO().optenerUno(oControl.getText().toString());
                    if(alu!=null){
                        oControl.setText(alu.getNombre().toString());
                    }else{

                    }
                }
            }).start();
        }
    }
    public void cambiar_alumno(View v){
        if(oControl.getText().toString().isEmpty()==false){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Alumno alu=null;
                    EscuelaBD conexionBD=EscuelaBD.gettAppDatabase(getBaseContext());
                    alu=conexionBD.alumnoDAO().optenerUno(oControl.getText().toString());
                    if(alu!=null){
                        String cad=edad.getText().toString();
                        byte edad=Byte.parseByte(cad);
                        String cad2=semestre.getText().toString();
                        byte semetre=Byte.parseByte(cad);
                        conexionBD.alumnoDAO().actualizarProNoControl(oControl.getText().toString(),nombre.getText().toString(),primerap.getText().toString(),segundaAp.getText().toString(),edad,semetre,carrera.getText().toString());
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getBaseContext(),"El registro se actualizo ",Toast.LENGTH_LONG).show();

                            }
                        });
                    }
                }
            }).start();
        }
    }
}
