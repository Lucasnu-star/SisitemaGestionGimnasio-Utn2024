package Clases;

import Excepciones.ExcepcionMembresiaExpirada;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *Clase Recepcionista, esta clase...
 */
public class Recepcionista extends Empleado {

    //Atributos
    GestionGimnasio<Entrenador> gestionEntrenadores;
    GestionGimnasio<Miembro> gestionMiembros;
    GestionGimnasio<Maquina> gestionMaquinas;
    GestionGimnasio<PersonalMantenimiento> gestionPersonalMantenimiento;

    //Constructor
    public Recepcionista(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, Date horario) {
        super(nombre, apellido, documento, fechaNacimiento, salario, horario);
        this.gestionEntrenadores = new GestionGimnasio<>();
        this.gestionMiembros = new GestionGimnasio<>();
        this.gestionMaquinas =new GestionGimnasio<>();
        this.gestionPersonalMantenimiento = new GestionGimnasio<>();
    }

    //Getters

    public GestionGimnasio<Entrenador> getGestionEntrenadores() {
        return gestionEntrenadores;
    }

    public GestionGimnasio<Miembro> getGestionMiembros() {
        return gestionMiembros;
    }

    public GestionGimnasio<Maquina> getGestionMaquinas() {
        return gestionMaquinas;
    }

    public GestionGimnasio<PersonalMantenimiento> getGestionPersonalMantenimiento() {
        return gestionPersonalMantenimiento;
    }

    //Setters

    public void setGestionEntrenadores(GestionGimnasio<Entrenador> gestionEntrenadores) {
        this.gestionEntrenadores = gestionEntrenadores;
    }

    public void setGestionMiembros(GestionGimnasio<Miembro> gestionMiembros) {
        this.gestionMiembros = gestionMiembros;
    }

    public void setGestionMaquinas(GestionGimnasio<Maquina> gestionMaquinas) {
        this.gestionMaquinas = gestionMaquinas;
    }

    public void setGestionPersonalMantenimiento(GestionGimnasio<PersonalMantenimiento> gestionPersonalMantenimiento) {
        this.gestionPersonalMantenimiento = gestionPersonalMantenimiento;
    }

    //Equals && HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Recepcionista that = (Recepcionista) o;
        return Objects.equals(gestionEntrenadores, that.gestionEntrenadores) && Objects.equals(gestionMiembros, that.gestionMiembros) && Objects.equals(gestionMaquinas, that.gestionMaquinas) && Objects.equals(gestionPersonalMantenimiento, that.gestionPersonalMantenimiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), gestionEntrenadores, gestionMiembros, gestionMaquinas, gestionPersonalMantenimiento);
    }

    //ToString

    @Override
    public String toString() {
        return "Recepcionista " +super.toString() +
                " Gestion Recepcionista: " +
                "Gestion Entrenadores=" + gestionEntrenadores +
                ", Gestion Miembros=" + gestionMiembros +
                ", Gestion Maquinas=" + gestionMaquinas +
                ", Gestion Personal Mantenimiento=" + gestionPersonalMantenimiento;
    }
    // Verificando membresia del miembro.
    public void verificarMembresia(Miembro miembro) throws ExcepcionMembresiaExpirada {
        if (miembro == null) {
            throw new IllegalArgumentException("El miembro no puede ser nulo.");
        }

        if (!miembro.isEstadoMembresia()) {
            throw new ExcepcionMembresiaExpirada("La membresía del miembro " + miembro.getNombre() + " ha expirado.");
        }

        System.out.println("La membresía del miembro " + miembro.getNombre() + " está activa.");
    }

}
