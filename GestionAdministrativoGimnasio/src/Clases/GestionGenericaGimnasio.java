package Clases;

import java.time.LocalDate;
import java.util.*;
import Enums.eEspecialidad;
import Enums.eTIPOMEMBRESIA;

/**
 * Clase GestionGimnasio, esta clase...
 *
 */
public class GestionGenericaGimnasio<T>  {
    //Atributo
    TreeMap<String, T> gestionUsuario;

    //Contructor
    public GestionGenericaGimnasio() {
        this.gestionUsuario = new TreeMap<>();
    }

    //Getter
    public TreeMap<String, T> getGestionUsuario() {
        return gestionUsuario;
    }

    //Setter


    //ToString
    @Override
    public String toString() {
        return "GestionGimnasio " +
                "gestionUsuario=" + gestionUsuario;
    }
    public void agregar(String clave, T obj) {
        gestionUsuario.put(clave, obj);
    }

    // Metdo para eliminar un elemento
    public void eliminar(String clave) {
        if (gestionUsuario.remove(clave) != null) {
            System.out.println("Elemento eliminado: " + clave);
        } else {
            System.out.println("El elemento no se encontró en la lista.");
        }
    }

    // Metodo para consultar los elementos de un tipo especifico
    public List<T> consultarPorClase(Class<T> clase) {
        List<T> result = new ArrayList<>();
        for (T obj : gestionUsuario.values()) {
            if (clase.isInstance(obj)) {
                result.add(obj);
            }
        }
        return result;
    }

    // Metodo para mostrar elementos de la lista

    // consultar por clave
    public T consultar (String clave){
        return gestionUsuario.get(clave);
    }

    // crea entrenador
    public Entrenador crearEntrenador(){
        Entrenador entrenador = new Entrenador();
        Scanner entrada = new Scanner(System.in);
        System.out.println("ingrese el nombre del entrenador");
        entrenador.setNombre(entrada.nextLine());
        System.out.println("ingrese apellido del entrenador");
        entrenador.setApellido(entrada.nextLine());
        System.out.println("ingrese documento del entrenador");
        entrenador.setDocumento(entrada.nextLine());
        System.out.println("ingrese fecha de nacimiento");
        entrenador.setFechaNacimiento(LocalDate.parse(entrada.nextLine()));
        // Mostrar las especialidades disponibles
        System.out.println("Seleccione la especialidad:");
        eEspecialidad[] especialidades = eEspecialidad.values();
        for (int i = 0; i < especialidades.length; i++) {
            System.out.println((i + 1) + ". " + especialidades[i].name());
        }

        int opcionEspecialidad = entrada.nextInt();
        while (opcionEspecialidad < 1 || opcionEspecialidad > especialidades.length) {
            System.out.println("Opción no válida. Por favor seleccione una especialidad válida.");
            opcionEspecialidad = entrada.nextInt();
        }
        entrenador.setEspecialidad(especialidades[opcionEspecialidad - 1]);

        return entrenador;
    }




///crear miembro
    public Miembro crearMiembro() {
        Miembro miembro = new Miembro();
        Membresia membresia = new Membresia();  // Crear instancia de Membresia
        Scanner entrada = new Scanner(System.in);

        // Solicitar datos del miembro
        System.out.println("Ingrese el nombre del miembro:");
        miembro.setNombre(entrada.nextLine());
        System.out.println("Ingrese apellido del miembro:");
        miembro.setApellido(entrada.nextLine());
        System.out.println("Ingrese documento del miembro:");
        miembro.setDocumento(entrada.nextLine());
        System.out.println("Ingrese fecha de nacimiento (YYYY-MM-DD):");
        miembro.setFechaNacimiento(LocalDate.parse(entrada.nextLine()));
        System.out.println("ingrese su fecha de inscripcion (YYYY-MM-DD):");
        miembro.setFechaIncripcion(LocalDate.parse(entrada.nextLine()));

        // Selección de membresía
        System.out.println("Seleccione su membresía:");
        eTIPOMEMBRESIA[] membresias = eTIPOMEMBRESIA.values();
        for (int i = 0; i < membresias.length; i++) {
            System.out.println((i + 1) + ". " + membresias[i].name());
        }

        int opcionMembresia = entrada.nextInt();
        while (opcionMembresia < 1 || opcionMembresia > membresias.length) {
            System.out.println("Opción no válida. Por favor seleccione una opción válida.");
            opcionMembresia = entrada.nextInt();
        }

        // Asignar el valor de membresía al objeto Membresia
        membresia.setTipomembresia(membresias[opcionMembresia - 1]); // Asignamos el tipo de membresía

        // Asignamos el costo mensual dependiendo del tipo de membresía
        switch (membresias[opcionMembresia - 1]) {
            case membresiaBasica:
                membresia.setCostoMensual(300);
                membresia.setDescripcion("Membresia de 3 dias a la semana con profesor personal");// Costo mensual para membresía anual
                break;
            case membresiaPremium:
                membresia.setCostoMensual(700);
                membresia.setDescripcion("Membresia libre con profesor personal y baños con ducha");// Costo mensual para membresía semestral
                break;
            default:
                System.out.println("Opción de membresía no válida.");
                break;
        }

        // Asignamos la membresía al miembro
        miembro.setMembresia(membresia);


        return miembro;
    }


}
