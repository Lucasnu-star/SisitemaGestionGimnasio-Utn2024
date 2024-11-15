package Clases;

import Enums.eTIPOMEMBRESIA;

import java.time.LocalDate;
import java.util.Objects;

/**
 *  Clase Miembro, esta clase es...
 */

//Clase Usuario
public final class Miembro extends Usuario{

    //Atributos
    private Membresia membresia;
    private boolean estadoMembresia; // True o False
    private LocalDate fechaIncripcion;

    //Constructor
    public Miembro(String nombre, String apellido, String documento, LocalDate fechaNacimiento, Membresia membresia, boolean estadoMembresia, LocalDate fechaIncripcion) {
        super(nombre, apellido, documento, fechaNacimiento);
        this.membresia = membresia;
        this.estadoMembresia = estadoMembresia;
        this.fechaIncripcion = fechaIncripcion;
    }
    public Miembro(){
    }

    //Getters

    public Membresia getMembresia() {
        return membresia;
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
        return estadoMembresia == miembro.estadoMembresia && Objects.equals(membresia, miembro.membresia) && Objects.equals(fechaIncripcion, miembro.fechaIncripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), membresia, estadoMembresia, fechaIncripcion);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Miembro{");
        sb.append("membresia=").append(membresia);
        sb.append(", estadoMembresia=").append(estadoMembresia);
        sb.append(", fechaIncripcion=").append(fechaIncripcion);
        sb.append('}');
        return sb.toString();
    }
}
