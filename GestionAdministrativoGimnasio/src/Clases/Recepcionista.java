package Clases;

import Excepciones.ExcepcionMembresiaExpirada;
import Interfaces.iReportarMaquina;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 *Clase Recepcionista, esta clase...
 */
public final class Recepcionista extends Empleado {


    //Constructor

    public Recepcionista(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, String horario) {
        super(nombre, apellido, documento, fechaNacimiento, salario, horario);
    }

    //ToString
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(super.toString());
        return sb.toString();
    }

    // Verificando membresia del miembro.
    public String verificarMembresia(Miembro miembro) throws ExcepcionMembresiaExpirada {
        if (miembro == null) {
            throw new IllegalArgumentException("El miembro no puede ser nulo.");
        }

        if (!miembro.isEstadoMembresia()) {
            throw new ExcepcionMembresiaExpirada("La membresía del miembro " + miembro.getNombre() + " ha expirado.");
        }

        return  "La membresía del miembro " + miembro.getNombre() + " está activa.";
    }

    //Metodos
    public <T> void agregarDeLista(GestionGenericaGimnasio<T> lista, String clave, T obj){
        lista.agregar(clave, obj);

    }

    public <T> void eliminarDeLista(GestionGenericaGimnasio<T> lista, String clave){
       lista.eliminar(clave);
    }

    // Metodo para consultar un miembro por clave
    public <T> void consultar(GestionGenericaGimnasio<T> listaMiembro, String key) {
        T miembro =  listaMiembro.consultar(key);
        System.out.println("Miembro: " + miembro);
    }

    // Metodo para calcular salario por entrenador:cada 5 miembros asignados se le suma un porcentaje

    public void calcularSalario(GestionGenericaGimnasio<Entrenador> gestionEntrenadores, Entrenador entrenador) {
        double salarioBase = entrenador.getSalario();
        int cantidadMiembros = entrenador.getMiembrosAsignados().size();

        int incrementos = cantidadMiembros / 5;
        double salarioFinal = salarioBase * (1 + (0.10 * incrementos));

        System.out.println("Salario del entrenador después de bonificación: " + salarioFinal);
    }


    // Metodo para asignar un miembro a un entrenador
    public void agregarMiembroAEntrenador(GestionGenericaGimnasio<Entrenador> listaEntrenadores, Miembro miembro, String dniEntrenador) {
        Entrenador entrenador = listaEntrenadores.consultar(dniEntrenador);
        if (entrenador != null) {
            entrenador.asignarMiembro(miembro);
            System.out.println("Miembro asignado al entrenador con DNI: " + dniEntrenador);
        } else {
            System.out.println("Entrenador no encontrado.");
        }
    }


    // Metodo para reportar una maquina
    public void reportarMaquina(GestionGenericaGimnasio<? extends iReportarMaquina> gestionMaquinas, String desc, String idMaquina, String dni) {
        iReportarMaquina maquina = gestionMaquinas.consultar(idMaquina);
        if (maquina != null) {
            Reporte reporte = new Reporte(desc, idMaquina, dni);
            maquina.reportarMaquina();
            System.out.println("Reporte generado para la máquina: " + idMaquina);
        } else {
            System.out.println("Máquina no encontrada.");
        }
    }
}
