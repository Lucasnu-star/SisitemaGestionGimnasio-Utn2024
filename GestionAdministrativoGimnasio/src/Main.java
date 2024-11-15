import Clases.*;
import Enums.eEspecialidad;
import Enums.eTIPOMEMBRESIA;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class
Main {
    public static void main(String[] args) {
//Creacion instancia Gimnasio
        Gimnasio GimnasioUTN = new Gimnasio("GimnasioUTN", 50, "Av. Dorrego 281");


        //Creacion instancias Recepcionistas
        Recepcionista recepcionista1 = new Recepcionista("Carlos", "Pérez", "12345678", LocalDate.of(1990, 5, 15), 5700, "08:00 a 12:00");
        Recepcionista recepcionista2 = new Recepcionista("Ana", "González", "87654321", LocalDate.of(1985, 12, 5), 4500, "12:00 a 16:00");
        Recepcionista recepcionista3 = new Recepcionista("Luis", "Martínez", "11223344", LocalDate.of(2000, 7, 22), 3900, "16:00 a 20:00");

        //Creacion instancias Especialidades
        Especialidad especialidadFuncional = new Especialidad("Entrenamiento funcional", eEspecialidad.FUNCIONAL);
        Especialidad especialidadMusculacion = new Especialidad("Entrenamiento de musculación", eEspecialidad.MUSCULACICION);
        Especialidad especialidadBoxeo = new Especialidad("Entrenamiento de boxeo", eEspecialidad.BOXEO);

        //Creacion instancias Tipos de membresia
        Membresia membresiaBasica = new Membresia("Membresía básica con acceso limitado", eTIPOMEMBRESIA.membresiaBasica, 1500);
        Membresia membresiaPremium = new Membresia("Membresía Premium con acceso completo", eTIPOMEMBRESIA.membresiaPremium, 3000);

        //Creacion instancias Entrenadores
        Entrenador entrenador1 = new Entrenador("Julian", "Sánchez", "11122333", LocalDate.of(1983, 3, 25), 5200, "09:00 - 17:00", especialidadFuncional);
        Entrenador entrenador2 = new Entrenador("Valeria", "López", "44556677", LocalDate.of(1987, 8, 14), 4600, "10:00 - 18:00", especialidadMusculacion);
        Entrenador entrenador3 = new Entrenador("Ricardo", "Martín", "88990011", LocalDate.of(1991, 2, 10), 4800, "08:00 - 16:00", especialidadMusculacion);
        Entrenador entrenador4 = new Entrenador("Eduardo", "Ramírez", "33445566", LocalDate.of(1982, 4, 12), 5000, "07:00 - 15:00", especialidadBoxeo);

        // Instancias de Miembro
        Miembro miembro1 = new Miembro("Carlos", "Lopez", "11111111", LocalDate.of(1995, 1, 10), membresiaBasica, true, LocalDate.of(2023, 1, 1));
        Miembro miembro2 = new Miembro("Ana", "Martinez", "22222222", LocalDate.of(1992, 2, 15), membresiaPremium, false, LocalDate.of(2023, 2, 15));
        Miembro miembro3 = new Miembro("Luis", "Garcia", "33333333", LocalDate.of(1998, 3, 20), membresiaBasica, true, LocalDate.of(2023, 3, 5));
        Miembro miembro4 = new Miembro("Lucia", "Fernandez", "44444444", LocalDate.of(1993, 4, 25), membresiaBasica, true, LocalDate.of(2023, 4, 10));
        Miembro miembro5 = new Miembro("Miguel", "Diaz", "55555555", LocalDate.of(1997, 5, 30), membresiaBasica, false, LocalDate.of(2023, 5, 20));
        Miembro miembro6 = new Miembro("Sofia", "Sanchez", "66666666", LocalDate.of(1994, 6, 5), membresiaBasica, true, LocalDate.of(2023, 6, 15));
        Miembro miembro7 = new Miembro("Juan", "Ruiz", "77777777", LocalDate.of(1996, 7, 10), membresiaPremium, false, LocalDate.of(2023, 7, 5));
        Miembro miembro8 = new Miembro("Elena", "Molina", "88888888", LocalDate.of(1999, 8, 15), membresiaPremium, true, LocalDate.of(2023, 8, 25));
        Miembro miembro9 = new Miembro("Fernando", "Romero", "99999999", LocalDate.of(1995, 9, 20), membresiaBasica, true, LocalDate.of(2023, 9, 30));
        Miembro miembro10 = new Miembro("Patricia", "Herrera", "10101010", LocalDate.of(1991, 10, 25), membresiaPremium, false, LocalDate.of(2023, 10, 15));

        //Creacion instancias Personal de Mantenimiento
        PersonalMantenimiento mantenimiento1 = new PersonalMantenimiento("Juan", "Gómez", "100112233", LocalDate.of(1980, 3, 14), 2500, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento2 = new PersonalMantenimiento("Laura", "Martínez", "223344556", LocalDate.of(1985, 7, 22), 2700, "10:00 - 18:00");



        System.out.println(GimnasioUTN.getGestionEntrenadores());

        Menu.MenuPrincipal(GimnasioUTN);







    }
}


