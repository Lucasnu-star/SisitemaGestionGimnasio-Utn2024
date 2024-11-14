package Clases;

import java.time.LocalDate;
import java.util.*;

/**
 * Clase Entrenador, esta clase...
 */


public final class Entrenador extends Empleado {

    //Atributos
    private Especialidad especialidad;
    private HashSet<String> certificados;
    private List<Miembro> miembrosAsignados;

    //Constuctor
    public Entrenador(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, String horario, Especialidad especialidad) {
        super(nombre, apellido, documento, fechaNacimiento, salario, horario);
        this.certificados = new HashSet<>(); // Ver
        this.especialidad = especialidad;
        this.miembrosAsignados = new ArrayList<>();
    }
    public Entrenador() {

    }


    //Getters

    public List<Miembro> getMiembrosAsignados() {
        return miembrosAsignados;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public HashSet<String> getCertificados() {
        return certificados;
    }

    //Setters

    public void setMiembrosAsignados(List<Miembro> miembrosAsignados) {
        this.miembrosAsignados = miembrosAsignados;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public void setCertificados(HashSet<String> certificados) {
        this.certificados = certificados;
    }

    //Equals && HashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Entrenador that = (Entrenador) o;
        return Objects.equals(especialidad, that.especialidad) && Objects.equals(certificados, that.certificados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), especialidad, certificados);
    }

    //ToString

    @Override
    public String toString() {
        return super.toString() +
                " Entrenador " +
                "especialidad=" + especialidad +
                ", certificados=" + certificados;
    }

    // Método para asignar un miembro al entrenador
    public void asignarMiembro(Miembro miembro) {
        miembrosAsignados.add(miembro);
        System.out.println("Miembro " + miembro.getNombre() + " asignado al entrenador " + getNombre());
    }

    // Metodo para consultar los meimbros de un entreandor
    public void consultarMiembros() {
        if (miembrosAsignados.isEmpty()) {
            System.out.println("No hay miembros asignados a este entrenador.");
        } else {
            System.out.println("Lista de miembros asignados al entrenador " + getNombre() + ":");
            for (Miembro miembro : miembrosAsignados) {
                System.out.println("- Nombre: " + miembro.getNombre() + ", Estado Membresía: "
                        + (miembro.isEstadoMembresia()));
            }
        }
    }
    // Metodo para agregar un certificado
    public void agregarCertificado(String certificado) {
        if (certificado != null) {
            certificados.add(certificado);
            System.out.println("Certificado \"" + certificado + "\" agregado al entrenador " + getNombre());
        } else {
            System.out.println("El certificado no puede ser nulo o vacío.");
        }
    }

    public void eliminarMiembro(Miembro miembro)
    {
        if (miembrosAsignados.contains(miembro))
        {
            miembrosAsignados.remove(miembro);
        }else
        {
            System.out.println("El miembro no fue encontrado en la lista de miembros del entrenador");
        }
    }

    //calcular la cantidad de miembros por entrenador
    public int cantMiembrosxEntrenador(){return miembrosAsignados.size();}
}



