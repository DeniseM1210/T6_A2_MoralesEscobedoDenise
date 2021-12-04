package Entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Alumno {
    @NonNull
    @PrimaryKey
    private String numControl;

    @NonNull
    @ColumnInfo(name="nombre")
    private String nombre;
    @NonNull
    @ColumnInfo(name="primerAp")
    private String primer_Ap;
    @NonNull
    @ColumnInfo(name="segundoAp")
    private String segundo_ap;
    @NonNull
    @ColumnInfo(name="edad")
    private byte edad;
    @NonNull
    @ColumnInfo(name="semestre")
    private byte semestre;
    @NonNull
    @ColumnInfo(name="carrera")
    private String carrera;



    public Alumno(@NonNull String numControl, @NonNull String nombre, @NonNull String primer_Ap, @NonNull String segundo_ap, byte edad, byte semestre, @NonNull String carrera) {
        this.numControl = numControl;
        this.nombre = nombre;
        this.primer_Ap = primer_Ap;
        this.segundo_ap = segundo_ap;
        this.edad = edad;
        this.semestre = semestre;
        this.carrera = carrera;
    }

    @NonNull
    public String getNumControl() {
        return numControl;
    }

    public void setNumControl(@NonNull String numControl) {
        this.numControl = numControl;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }

    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @NonNull
    public String getPrimer_Ap() {
        return primer_Ap;
    }

    public void setPrimer_Ap(@NonNull String primer_Ap) {
        this.primer_Ap = primer_Ap;
    }

    @NonNull
    public String getSegundo_ap() {
        return segundo_ap;
    }

    public void setSegundo_ap(@NonNull String segundo_ap) {
        this.segundo_ap = segundo_ap;
    }

    @NonNull
    public byte getEdad() {
        return edad;
    }

    public void setEdad(@NonNull byte edad) {
        this.edad = edad;
    }

    @NonNull
    public byte getSemestre() {
        return semestre;
    }

    public void setSemestre(@NonNull byte semestre) {
        this.semestre = semestre;
    }

    @NonNull
    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(@NonNull String carrera) {
        this.carrera = carrera;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numControl='" + numControl + '\'' +
                ", nombre='" + nombre + '\'' +
                ", primer_Ap='" + primer_Ap + '\'' +
                ", segundo_ap='" + segundo_ap + '\'' +
                ", edad='" + edad + '\'' +
                ", semestre='" + semestre + '\'' +
                ", carrera='" + carrera + '\'' +
                '}';
    }
}
