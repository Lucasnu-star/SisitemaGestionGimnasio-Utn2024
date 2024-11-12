package Clases;

import Enums.eTIPOMEMBRESIA;

import java.util.Objects;

/**
 * Clase Membresia, esta clase...
 */

public final class Membresia {

    //Atributos
    private String descripcion;
    private eTIPOMEMBRESIA eTipomembresia;
    private long costoMensual;

    //Constuctor
    public Membresia(String descripcion, eTIPOMEMBRESIA eTipomembresia, long constoMensual) {
        this.descripcion = descripcion;
        this.eTipomembresia = eTipomembresia;
        this.costoMensual = constoMensual;
    }

    //Getters

    public String getDescripcion() {
        return descripcion;
    }

    public eTIPOMEMBRESIA getTipomembresia() {
        return eTipomembresia;
    }

    public long getConstoMensual() {
        return costoMensual;
    }

    //Setters

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setTipomembresia(eTIPOMEMBRESIA eTipomembresia) {
        this.eTipomembresia = eTipomembresia;
    }

    //Equals && HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Membresia membresia = (Membresia) o;
        return costoMensual == membresia.costoMensual && Objects.equals(descripcion, membresia.descripcion) && Objects.equals(eTipomembresia, membresia.eTipomembresia);
    }
    @Override
    public int hashCode() {
        return Objects.hash(descripcion, eTipomembresia, costoMensual);
    }

    //ToString
    @Override
    public String toString() {
        return "Membresia " +
                "descripcion='" + descripcion + '\'' +
                ", tipomembresia=" + eTipomembresia +
                ", constoMensual=" + costoMensual;
    }
}
