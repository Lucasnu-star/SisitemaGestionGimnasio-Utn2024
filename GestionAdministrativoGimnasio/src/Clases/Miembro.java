package Clases;

import java.time.LocalDate;
import java.util.Objects;

/**
 *  Clase Miembro, esta clase es...
 */

//Clase Usuario
public class Miembro extends Usuario{

    //Atributos
    private Membresia membresia;
    private Entrenador entrenadorAsingado;
    private boolean estadoMembresia; // True o False
    private LocalDate fechaIncripcion;

    //Constructor
    public Miembro(String nombre, String apellido, String documento, LocalDate fechaNacimiento, Membresia membresia, Entrenador entrenadorAsingado, boolean estadoMembresia, LocalDate fechaIncripcion) {
        super(nombre, apellido, documento, fechaNacimiento);
        this.membresia = membresia;
        this.entrenadorAsingado = entrenadorAsingado;
        this.estadoMembresia = estadoMembresia;
        this.fechaIncripcion = fechaIncripcion;
    }

    //Getters

    public Membresia getMembresia() {
        return membresia;
    }

    public Entrenador getEntrenadorAsingado() {
        return entrenadorAsingado;
    }

    public boolean isEstadoMembresia() {
        return estadoMembresia;
    }

    public LocalDate getFechaIncripcion() {
        return fechaIncripcion;
    }

    //Setters

    public void setMembresia(Membresia membresia) {
        this.membresia = membresia;
    }

    public void setEntrenadorAsingado(Entrenador entrenadorAsingado) {
        this.entrenadorAsingado = entrenadorAsingado;
    }

    public void setEstadoMembresia(boolean estadoMembresia) {
        this.estadoMembresia = estadoMembresia;
    }

    public void setFechaIncripcion(LocalDate fechaIncripcion) {
        this.fechaIncripcion = fechaIncripcion;
    }

    //Equals && HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Miembro miembro = (Miembro) o;
        return estadoMembresia == miembro.estadoMembresia && Objects.equals(membresia, miembro.membresia) && Objects.equals(entrenadorAsingado, miembro.entrenadorAsingado) && Objects.equals(fechaIncripcion, miembro.fechaIncripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), membresia, entrenadorAsingado, estadoMembresia, fechaIncripcion);
    }

    //ToString
    @Override
    public String toString() {
        return super.toString()+
                " Miembro " +
                "membresia=" + membresia +
                ", entrenadorAsingado=" + entrenadorAsingado +
                ", estadoMembresia=" + estadoMembresia +
                ", fechaIncripcion=" + fechaIncripcion ;
    }
}
