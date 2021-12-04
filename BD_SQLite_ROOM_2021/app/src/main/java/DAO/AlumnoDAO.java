package DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entidades.Alumno;

@Dao
public interface AlumnoDAO {

    //Altas
    @Insert
    public void insertarAlumno(Alumno alum);

    //Bajas
    @Query("DELETE FROM Alumno WHERE numControl=:nc")
    public void eliminarPorNumControl(String nc);

    @Query("UPDATE Alumno SET nombre=:x,primerAp=:y,segundoAp=:z,edad=:e,semestre=:s,carrera=:c WHERE numControl=:n")
    public void actualizarProNoControl(String n,String x,String y,String z,byte e,byte s,String c);

    //Consultas
    @Query("SELECT * FROM Alumno")
    public List<Alumno> optenerTodos();

    @Query("SELECT * FROM Alumno WHERE nombre LIKE :n")
    public List<Alumno> buscarPorNombre(String n);

    @Query("SELECT * FROM Alumno WHERE numControl LIKE :c")
    public List<Alumno> optenerFiltrando(String c);

    @Query("SELECT * FROM Alumno WHERE numControl =:c")
    public Alumno optenerUno(String c);


}
