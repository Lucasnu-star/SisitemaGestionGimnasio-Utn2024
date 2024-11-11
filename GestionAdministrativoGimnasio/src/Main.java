import Clases.*;
import Enums.eEspecialidad;
import Enums.eTIPOMEMBRESIA;

import java.time.LocalDate;
import java.time.LocalDateTime;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Creacion instancia Gimnasio
        Gimnasio GimnasioUTN = new Gimnasio("GimnasioUTN" , 50 , "Av. Dorrego 281");
        //Creacion instancias Recepcionistas
        Recepcionista Recepcionista1 = new Recepcionista("Carlos", "Pérez", "12345678", LocalDate.of(1990 , 5 , 15) , 5700 , "08:00 a 12:00" );
        Recepcionista Recepcionista2 = new Recepcionista("Ana", "González", "87654321", LocalDate.of(1985, 12 , 5) , 4500 , "12:00 a 16:00");
        Recepcionista Recepcionista3 = new Recepcionista("Luis", "Martínez", "11223344", LocalDate.of(2000, 7 , 22) , 3900 , "16:00 a 20:00");
        //Creacion instancias Especialidades
        Especialidad especialidadFuncional = new Especialidad("Entrenamiento funcional", eEspecialidad.funcional);
        Especialidad especialidadMusculacion = new Especialidad("Entrenamiento de musculación", eEspecialidad.musculacion);
        Especialidad especialidadCardio = new Especialidad("Entrenamiento de cardio", eEspecialidad.cardio);
        Especialidad especialidadBoxeo = new Especialidad("Entrenamiento de boxeo" , eEspecialidad.boxeo);
        //Creacion instancias Entrenadores
        Entrenador entrenador1 = new Entrenador("Julian", "Sánchez", "11122333", LocalDate.of(1983, 3, 25), 5200, "09:00 - 17:00", especialidadFuncional);
        Entrenador entrenador2 = new Entrenador("Valeria", "López", "44556677", LocalDate.of(1987, 8, 14), 4600, "10:00 - 18:00", especialidadMusculacion);
        Entrenador entrenador3 = new Entrenador("Ricardo", "Martín", "88990011", LocalDate.of(1991, 2, 10), 4800, "08:00 - 16:00", especialidadCardio);
        Entrenador entrenador4 = new Entrenador("Eduardo", "Ramírez", "33445566", LocalDate.of(1982, 4, 12), 5000, "07:00 - 15:00", especialidadBoxeo);
        //Creacion instancias Personal de Mantenimiento
        PersonalMantenimiento mantenimiento1 = new PersonalMantenimiento("Juan", "Gómez", "100112233", LocalDate.of(1980, 3, 14), 2500, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento2 = new PersonalMantenimiento("Laura", "Martínez", "223344556", LocalDate.of(1985, 7, 22), 2700, "10:00 - 18:00");
        //Creacion instancias Tipos de membresia
        Membresia membresiaBasica = new Membresia("Membresía básica con acceso limitado", eTIPOMEMBRESIA.membresiaBasica, 1500);
        Membresia membresiaPremium = new Membresia("Membresía Premium con acceso completo", eTIPOMEMBRESIA.membresiaPremium, 3000);
}
}