import Clases.*;
import Enums.eEspecialidad;
import Enums.eTIPOMEMBRESIA;
import Enums.eTIPOMAQUINA;
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
        Recepcionista recepcionista4 = new Recepcionista("Marta", "Díaz", "22334455", LocalDate.of(1992, 10, 15), 4600, "08:00 a 12:00");
        Recepcionista recepcionista5 = new Recepcionista("Javier", "Lopez", "33445566", LocalDate.of(1994, 3, 3), 4800, "12:00 a 16:00");
        Recepcionista recepcionista6 = new Recepcionista("Lucía", "Sánchez", "44556677", LocalDate.of(1991, 11, 20), 5000, "16:00 a 20:00");
        Recepcionista recepcionista7 = new Recepcionista("Pedro", "Martínez", "55667788", LocalDate.of(1989, 8, 10), 5200, "08:00 a 12:00");
        Recepcionista recepcionista8 = new Recepcionista("Sofía", "García", "66778899", LocalDate.of(1993, 9, 5), 5400, "12:00 a 16:00");
        Recepcionista recepcionista9 = new Recepcionista("Raúl", "Fernández", "77889900", LocalDate.of(1995, 6, 25), 5500, "16:00 a 20:00");
        Recepcionista recepcionista10 = new Recepcionista("Patricia", "Jiménez", "88990011", LocalDate.of(1996, 4, 30), 5700, "08:00 a 12:00");

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
        Entrenador entrenador5 = new Entrenador("Carlos", "Pérez", "11223344", LocalDate.of(1990, 1, 5), 5100, "09:00 - 17:00", especialidadFuncional);
        Entrenador entrenador6 = new Entrenador("Ana", "Martínez", "22334455", LocalDate.of(1992, 5, 18), 4700, "10:00 - 18:00", especialidadMusculacion);
        Entrenador entrenador7 = new Entrenador("Luis", "Gómez", "55667788", LocalDate.of(1990, 3, 22), 4900, "08:00 - 16:00", especialidadBoxeo);
        Entrenador entrenador8 = new Entrenador("Sofía", "Ruiz", "77889900", LocalDate.of(1988, 9, 12), 4700, "07:00 - 15:00", especialidadFuncional);
        Entrenador entrenador9 = new Entrenador("José", "Hernández", "99001122", LocalDate.of(1985, 6, 10), 4600, "09:00 - 17:00", especialidadMusculacion);
        Entrenador entrenador10 = new Entrenador("Martín", "Vega", "11223344", LocalDate.of(1989, 12, 5), 4800, "08:00 - 16:00", especialidadBoxeo);

        GimnasioUTN.getGestionEntrenadores().agregar(entrenador1.getDocumento(), entrenador1);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador2.getDocumento(), entrenador2);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador3.getDocumento(), entrenador3);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador4.getDocumento(), entrenador4);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador5.getDocumento(), entrenador5);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador6.getDocumento(), entrenador6);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador7.getDocumento(), entrenador7);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador8.getDocumento(), entrenador8);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador9.getDocumento(), entrenador9);
        GimnasioUTN.getGestionEntrenadores().agregar(entrenador10.getDocumento(), entrenador10);


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

        GimnasioUTN.getGestionMiembros().agregar(miembro1.getDocumento(), miembro1);
        GimnasioUTN.getGestionMiembros().agregar(miembro2.getDocumento(), miembro2);
        GimnasioUTN.getGestionMiembros().agregar(miembro3.getDocumento(), miembro3);
        GimnasioUTN.getGestionMiembros().agregar(miembro4.getDocumento(), miembro4);
        GimnasioUTN.getGestionMiembros().agregar(miembro5.getDocumento(), miembro5);
        GimnasioUTN.getGestionMiembros().agregar(miembro6.getDocumento(), miembro6);
        GimnasioUTN.getGestionMiembros().agregar(miembro7.getDocumento(), miembro7);
        GimnasioUTN.getGestionMiembros().agregar(miembro8.getDocumento(), miembro8);
        GimnasioUTN.getGestionMiembros().agregar(miembro9.getDocumento(), miembro9);
        GimnasioUTN.getGestionMiembros().agregar(miembro10.getDocumento(), miembro10);


        //Creacion instancias Personal de Mantenimiento

        PersonalMantenimiento mantenimiento1 = new PersonalMantenimiento("Juan", "Gómez", "100112233", LocalDate.of(1980, 3, 14), 2500, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento2 = new PersonalMantenimiento("Laura", "Pérez", "100223344", LocalDate.of(1985, 6, 10), 2600, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento3 = new PersonalMantenimiento("Pedro", "Martínez", "100334455", LocalDate.of(1990, 7, 1), 2700, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento4 = new PersonalMantenimiento("Sandra", "López", "100445566", LocalDate.of(1982, 4, 23), 2800, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento5 = new PersonalMantenimiento("Javier", "Ramírez", "100556677", LocalDate.of(1988, 8, 15), 2900, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento6 = new PersonalMantenimiento("Esteban", "Hernández", "100667788", LocalDate.of(1992, 2, 20), 3000, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento7 = new PersonalMantenimiento("María", "García", "100778899", LocalDate.of(1989, 5, 17), 3100, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento8 = new PersonalMantenimiento("Clara", "Sánchez", "100889900", LocalDate.of(1991, 10, 2), 3200, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento9 = new PersonalMantenimiento("Raúl", "Fernández", "100990011", LocalDate.of(1986, 12, 14), 3300, "08:00 - 16:00");
        PersonalMantenimiento mantenimiento10 = new PersonalMantenimiento("Elena", "Jiménez", "101001122", LocalDate.of(1993, 9, 9), 3400, "08:00 - 16:00");

        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento1.getDocumento(), mantenimiento1);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento2.getDocumento(), mantenimiento2);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento3.getDocumento(), mantenimiento3);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento4.getDocumento(), mantenimiento4);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento5.getDocumento(), mantenimiento5);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento6.getDocumento(), mantenimiento6);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento7.getDocumento(), mantenimiento7);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento8.getDocumento(), mantenimiento8);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento9.getDocumento(), mantenimiento9);
        GimnasioUTN.getGestionPersonalMantenimiento().agregar(mantenimiento10.getDocumento(), mantenimiento10);

        // añadir maquinas al gimnasio
        Maquina maquina1 = new Maquina("Press de Banca", eTIPOMAQUINA.pecho, true);
        Maquina maquina2 = new Maquina("Máquina de Remo", eTIPOMAQUINA.espalda, false);
        Maquina maquina3 = new Maquina("Press de Piernas", eTIPOMAQUINA.brazo, true);
        Maquina maquina4 = new Maquina("Bicicleta Estática", eTIPOMAQUINA.piernas, true);
        Maquina maquina5 = new Maquina("Curl de Bíceps", eTIPOMAQUINA.brazo, false);
        Maquina maquina6 = new Maquina("Máquina de Tríceps", eTIPOMAQUINA.brazo, true);
        Maquina maquina7 = new Maquina("Máquina de Pectorales", eTIPOMAQUINA.pecho, true);
        Maquina maquina8 = new Maquina("Extensiones de Piernas", eTIPOMAQUINA.piernas, false);
        Maquina maquina9 = new Maquina("Máquina de Espalda Alta", eTIPOMAQUINA.espalda, true);
        Maquina maquina10 = new Maquina("Máquina de Abdominales", eTIPOMAQUINA.pecho, true);

        // Añadir maquinas al gimnasio
        GimnasioUTN.getGestionMaquinas().agregar(maquina1.getNombre(), maquina1);
        GimnasioUTN.getGestionMaquinas().agregar(maquina2.getNombre(), maquina2);
        GimnasioUTN.getGestionMaquinas().agregar(maquina3.getNombre(), maquina3);
        GimnasioUTN.getGestionMaquinas().agregar(maquina4.getNombre(), maquina4);
        GimnasioUTN.getGestionMaquinas().agregar(maquina5.getNombre(), maquina5);
        GimnasioUTN.getGestionMaquinas().agregar(maquina6.getNombre(), maquina6);
        GimnasioUTN.getGestionMaquinas().agregar(maquina7.getNombre(), maquina7);
        GimnasioUTN.getGestionMaquinas().agregar(maquina8.getNombre(), maquina8);
        GimnasioUTN.getGestionMaquinas().agregar(maquina9.getNombre(), maquina9);
        GimnasioUTN.getGestionMaquinas().agregar(maquina10.getNombre(), maquina10);

        Menu.MenuPrincipal(GimnasioUTN);







    }
}


