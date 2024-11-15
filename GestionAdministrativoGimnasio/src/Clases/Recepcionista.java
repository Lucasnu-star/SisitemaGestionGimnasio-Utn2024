package Clases;

import Excepciones.ExcepcionMembresiaExpirada;
import Interfaces.iReportarMaquina;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Scanner;

/**
 *Clase Recepcionista, esta clase...
 */
public final class Recepcionista extends Empleado {


    //Constructor

    public Recepcionista(String nombre, String apellido, String documento, LocalDate fechaNacimiento, int salario, String horario) {
        super(nombre, apellido, documento, fechaNacimiento, salario, horario);
    }
    public Recepcionista() {
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
    public static  <T> void agregarDeLista(GestionGenericaGimnasio<T> lista, String clave, T obj){
        lista.agregar(clave, obj);
    }

    public static <T> void eliminarDeLista(GestionGenericaGimnasio<T> lista, String clave){
       lista.eliminar(clave);
    }

    // Metodo para consultar un miembro por clave
    public static  <T> T consultar(GestionGenericaGimnasio<T> lista, String key) {
        T t=  lista.consultar(key);
        return t;
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

    public static <T> void mostrarElementosLista(GestionGenericaGimnasio<T> gestionEntrenadores) {
        System.out.println("Lista de elementos en GestionGym:");
        for (Map.Entry<String, T> rec : gestionEntrenadores.getGestionUsuario().entrySet()) {
            String clave = rec.getKey();  // Obtiene la clave del mapa
            T valor = rec.getValue();     // Obtiene el valor del mapa
            System.out.println("Clave: " + clave + ", Valor: " + valor);
        }
    }

    //modificcar entrenador
    public static void modificarEntrenador(String dni, GestionGenericaGimnasio<Entrenador> lista) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresa el nuevo nombre:");
        String nuevoNombre = scanner.nextLine();

        boolean entrenadorEncontrado = false;

        for (Map.Entry<String, Entrenador> rec : lista.getGestionUsuario().entrySet()) {
            if (rec.getKey().equals(dni)) {
                // Obtener el entrenador actual
                Entrenador entrenador = rec.getValue();
                entrenador.setNombre(nuevoNombre); // Modificar el nombre del entrenador
                entrenadorEncontrado = true;
                System.out.println("Nombre del entrenador actualizado: " + entrenador);
                break;
            }
        }

        if (!entrenadorEncontrado) {
            System.out.println("No se encontró un entrenador con el documento: " + dni);
        }
    }

    //modificar miembro


    public static void modificarMiembro(String dni, GestionGenericaGimnasio<Miembro> lista) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar el nuevo nombre
        System.out.println("Ingresa el nuevo nombre:");
        String nuevoNombre = scanner.nextLine();

        // Solicitar la nueva fecha de nacimiento (formato: yyyy-MM-dd)
        System.out.println("Ingresa la nueva fecha de nacimiento (formato: yyyy-MM-dd):");
        String nuevaFechaNacimientoStr = scanner.nextLine();

        // Convertir la cadena de texto a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate nuevaFechaNacimiento = LocalDate.parse(nuevaFechaNacimientoStr, formatter);

        boolean miembroEncontrado = false;

        // Buscar al miembro en la lista por su DNI
        for (Map.Entry<String, Miembro> entry : lista.getGestionUsuario().entrySet()) {
            if (entry.getKey().equals(dni)) {

                Miembro miembro = entry.getValue();
                miembro.setNombre(nuevoNombre); // Modificar el nombre del miembro
                miembro.setFechaNacimiento(nuevaFechaNacimiento); // Modificar la fecha de nacimiento
                miembroEncontrado = true;
                System.out.println("Miembro actualizado: " + miembro);
                break;
            }
        }

        if (!miembroEncontrado) {
            System.out.println("No se encontró un miembro con el documento: " + dni);
        }
    }

}
