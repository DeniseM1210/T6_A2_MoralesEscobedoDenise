package com.example.app1_clase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity_menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void abirmenu_Altas(View v){
        Intent i=new Intent(this,Activity_Altas.class);
        startActivity(i);
    }
    public void abrir_Activitis(View v){
        Intent i=null;
        switch (v.getId()){
            case R.id.id_boton_agregar:
                i=new Intent(this,Activity_Altas.class);
                break;
            case R.id.btn_eliminar:
                i=new Intent(this,Activity_Bajas.class);
                break;
            case R.id.btn_modificar:
                i=new Intent(this,Activity_Cambios.class);
                break;
            case R.id.btn_consultas:
                System.err.println("Entre");
                i=new Intent(this,AtiviConsultas.class);
                break;
        }
        startActivity(i);
    }

}
