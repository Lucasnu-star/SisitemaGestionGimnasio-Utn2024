package Clases;
import org.json.JSONArray;

import java.util.Scanner;
public class Menu {


/*
    public static void MenuPrincipal(){
    Scanner scanner = new Scanner(System.in);
    int opcion;


        do

    {
        // Mostrar el menú principal
        System.out.println("\nMenú Principal:");
        System.out.println("1. Entrenadores");
        System.out.println("2. Miembros");
        System.out.println("3. Máquinas");
        System.out.println("4. Personal de Mantenimiento");
        System.out.println("0. Salir del Programa");
        System.out.print("Ingrese una opción: ");
        opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                // Llamar entrenadores
                mostrarMenuEntrenadores(scanner);
                break;
            case 2:
                // Llamar miembros
                mostrarMenuMiembros(scanner);
                break;
            case 3:
                // Llamar maquinas
                mostrarMenuMaquinas(scanner);
                break;
            case 4:
                // Llamar personal de mantenimiento
                mostrarMenuMantenimiento(scanner);
                break;
            case 0:
                System.out.println("¡Nos vemos! cerrando porgrama...");
                break;
            default:
                System.out.println("Opción no válida, por favor intente nuevamente.");
        }

    } while(opcion !=0); // Se cierra el programa cuando se ingrese 0
}


    // Submenú de entrenadores
    public static void mostrarMenuEntrenadores(Scanner scanner , Gimnasio gym) {
        int opcion;
        do {
            GestionGenericaGimnasio<Entrenador>recepcionista = new GestionGenericaGimnasio<>();
            System.out.println("\nMenú entrenadores:");
            System.out.println("1. Mostrar entrenadores");
            System.out.println("2. Consultar entrenador");
            System.out.println("3. Agregar entrenador");
            System.out.println("4. Modificar entrenador");
            System.out.println("5. Eliminar entrenador");
            System.out.println("6. Guardar en archivo");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Mostrar entrenadores...");
                    recepcionista.mostrarTodos();
                    break;
                case 2:
                    System.out.println("Consultar entrenador...");
                    System.out.println("ingrese DNI del entrenador a buscar...");
                    String dni = scanner.nextLine();
                    recepcionista.consultar(dni);
                    break;
                case 3:
                    System.out.println("Agregar entrenador...");
                    recepcionista.agregar(recepcionista.crearEntrenador().getDocumento(),recepcionista.crearEntrenador());
                    break;
                case 4:
                    System.out.println("Modificar entrenador...");
                    recepcionista.modificarEntrenador();
                    break;
                case 5:
                    System.out.println("Eliminar entrenador...");
                    System.out.println("ingrese documento del entrenador a eliminar");
                    recepcionista.eliminar(scanner.nextLine());
                    break;
                case 6:
                    System.out.println("Guardar en archivo...");
                    JSONArchivos.importarEntrenadoresDesdeJson(gym);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    Menu.MenuPrincipal();
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menu principal
    }

*/


     //Submenú de miembros
     public static void mostrarMenuMiembros(Gimnasio gym) {
         Scanner teclado = new Scanner(System.in);
         Recepcionista recepcionista = new Recepcionista();
         GestionGenericaGimnasio<Miembro> gestionMiembros = new GestionGenericaGimnasio<>();
         int opcion;

         do {


             System.out.println("\nMenú miembros:");
             System.out.println("1. Mostrar Miembros");
             System.out.println("2. Consultar Miembro");
             System.out.println("3. Agregar Miembro");
             System.out.println("4. Modificar Miembro");
             System.out.println("5. Eliminar Miembro");
             System.out.println("6. Ver lista");
             System.out.println("7. Guardar en archivo");

             System.out.println("0. Volver al Menú Principal");
             System.out.print("Ingrese una opción: ");
             opcion = teclado.nextInt();

             switch (opcion) {
                 case 1:
                     System.out.println("Mostrar miembros...");
                     Recepcionista.mostrarElementosLista(gym.getGestionMiembros());
                     break;
                 case 2:
                     System.out.println("Consultar miembro...");
                     Scanner tecladoMiembro = new Scanner(System.in);
                     System.out.println("Ingrese DNI del miembro a buscar...");
                     String dni = tecladoMiembro.nextLine();
                     Miembro miembroConsultado = recepcionista.consultar(gym.getGestionMiembros(), dni);
                     if (miembroConsultado != null) {
                         System.out.println(miembroConsultado);
                     } else {
                         System.out.println("Miembro no encontrado.");
                     }
                     break;
                 case 3:
                     System.out.println("Agregar miembro...");
                     Miembro nuevoMiembro = gestionMiembros.crearMiembro();
                     recepcionista.agregarDeLista(gym.getGestionMiembros(), nuevoMiembro.getDocumento(), nuevoMiembro);
                     JSONArchivos.exportarMiembroAJson(nuevoMiembro);
                     break;
                 case 4:
                     System.out.println("Modificar miembro...");
                     Scanner scan = new Scanner(System.in);
                     System.out.println("Ingrese el DNI del miembro a modificar:");
                     String documento = scan.nextLine();
                     Recepcionista.modificarMiembro(documento, gym.getGestionMiembros());
                     JSONArchivos.exportarMiembrosAJson(gym);
                     break;
                 case 5:
                     System.out.println("Eliminar miembro...");
                     Scanner scanEliminar = new Scanner(System.in);
                     System.out.println("Ingrese DNI del miembro a eliminar:");
                     String dniEliminar = scanEliminar.nextLine();
                     recepcionista.eliminarDeLista(gym.getGestionMiembros(), dniEliminar);
                     JSONArchivos.eliminarMiembroPorDni(dniEliminar, "Miembros.json");
                     break;
                 case 6:
                     System.out.println("Ver lista de miembros...");

                     break;
                 case 7:
                     System.out.println("Guardando en archivo...");
                     JSONArchivos.exportarMiembrosAJson(gym);
                     JSONArchivos.exportarListaMiembros(gym);
                     break;
                 case 0:
                     System.out.println("Volviendo al Menú Principal...");
                     break;
                 default:
                     System.out.println("Opción no válida, por favor intente nuevamente.");
             }
         } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menú principal
     }



     //Submenú de máquinas
     public static void mostrarMenuMaquinas(Gimnasio gym) {
         Scanner scanner = new Scanner(System.in);
         Recepcionista recepcionista1 = new Recepcionista();
         Scanner tecladoMaquina = new Scanner(System.in);
         GestionGenericaGimnasio<Maquina> recepcionistam = new GestionGenericaGimnasio<>();
         int opcion;
         do {
             System.out.println("\nMenú máquinas:");
             System.out.println("1. Mostrar máquinas");
             System.out.println("2. Consultar máquina");
             System.out.println("3. Agregar máquina");
             System.out.println("4. Modificar máquina");
             System.out.println("5. Eliminar máquina");
             System.out.println("6. Guardar en archivo");
             System.out.println("0. Volver al Menú Principal");
             System.out.print("Ingrese una opción: ");
             opcion = scanner.nextInt();

             switch (opcion) {
                 case 1:

                     System.out.println("Mostrar máquinas...");
                     Recepcionista.mostrarElementosLista(gym.getGestionMaquinas());
                     JSONArchivos.exportarMaquinasAJson(gym);

                     break;
                 case 2:
                     JSONArchivos.importarMaquinasDesdeJson(gym.getGestionMaquinas());
                     System.out.println("Consultar máquina...");
                     System.out.println("ingrese el nombre de la maquina a buscar...");
                     String id = tecladoMaquina.nextLine();
                     Maquina maq=Recepcionista.consultar(gym.getGestionMaquinas(),id);
                     System.out.println(maq.toString());
                     JSONArchivos.exportarMaquinasAJson(gym);
                     break;
                 case 3:
                     JSONArchivos.importarMaquinasDesdeJson(gym.getGestionMaquinas());
                     System.out.println("Agregar máquina...");
                     Maquina maquina=recepcionistam.crearMaquina();
                     Recepcionista.agregarDeLista(gym.getGestionMaquinas(),maquina.getId(),maquina);
                     JSONArchivos.exportarMaquinaAJson(maquina);
                     break;
                 case 4:
                     JSONArchivos.importarMaquinasDesdeJson(gym.getGestionMaquinas());
                     System.out.println("Modificar máquina...");
                     System.out.println("ingrese id a modificar...");
                     String idM = tecladoMaquina.nextLine();
                     Recepcionista.modificarMaquina(idM,gym.getGestionMaquinas());
                     JSONArchivos.exportarMaquinasAJson(gym);

                     break;
                 case 5:
                     JSONArchivos.importarMaquinasDesdeJson(gym.getGestionMaquinas());
                     System.out.println("Eliminar máquina...");
                     System.out.println("ingrese id a eliminar...");
                     String idma=tecladoMaquina.nextLine();
                     Recepcionista.eliminarDeLista(gym.getGestionMaquinas(),idma);
                     JSONArchivos.exportarListaMaquinas(gym);
                     break;
                 case 6:
                     System.out.println("Guardar en archivo...");
                     JSONArchivos.exportarMaquinasAJson(gym);
                     JSONArchivos.exportarListaMaquinas(gym);
                     break;
                 case 0:
                     System.out.println("Volviendo al Menú Principal...");
                     break;
                 default:
                     System.out.println("Opción no válida, por favor intente nuevamente.");
             }
         } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menu principal
     }

    // Submenú de recepcionistas
    public static void mostrarMenuRecepcionistas(Gimnasio gimnasio){
    Scanner scanner = new Scanner(System.in);
    int opcion;
        do {
            System.out.println("\nMenú recepcionistas:");
            System.out.println("1. Mostrar recepcionistas");
            System.out.println("2. Consultar recepcionista");
            System.out.println("3. Agregar recepcionista");
            System.out.println("4. Modificar recepcionista");
            System.out.println("5. Eliminar recepcionista");
            System.out.println("6. Guardar en archivo");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Mostrar recepcionistas...");
                    break;
                case 2:
                    System.out.println("Consultar recepcionista...");
                    break;
                case 3:
                    System.out.println("Agregar recepcionista...");
                    break;
                case 4:
                    System.out.println("Modificar recepcionista...");
                    break;
                case 5:
                    System.out.println("Eliminar recepcionista...");
                    break;
                case 6:
                    System.out.println("Guardar en archivo...");
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menu principal
    }

    //Submenu mantenimiento
    public static void mostrarMenuMantenimiento(Gimnasio gym) {
        Scanner scanner = new Scanner(System.in);
        GestionGenericaGimnasio<Entrenador> recepcionista = new GestionGenericaGimnasio<>();
        int opcion;
        do {
            System.out.println("\nMenú Personal de mantenimiento:");
            System.out.println("1. Mostrar Personal de mantenimiento");
            System.out.println("2. Consultar Personal de mantenimiento");
            System.out.println("3. Agregar Personal de mantenimiento");
            System.out.println("4. Modificar Personal de mantenimiento");
            System.out.println("5. Eliminar Personal de mantenimiento");
            System.out.println("6. Guardar en archivo");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Mostrar personal de mantenimiento...");
                    Recepcionista.mostrarElementosLista(gym.getGestionPersonalMantenimiento());
                    break;
                case 2:
                    Scanner tecladoMantenimiento = new Scanner(System.in);
                    System.out.println("Consultar personal de mantenimiento...");
                    System.out.println("ingrese DNI del personal de mantenimiento a buscar...");
                    String dni = tecladoMantenimiento.nextLine();
                    PersonalMantenimiento mantenimientoConsultado = Recepcionista.consultar(gym.getGestionPersonalMantenimiento(), dni);
                    System.out.println(mantenimientoConsultado);
                    break;
                case 3:
                    System.out.println("Agregar personal de mantenimiento...");
                    PersonalMantenimiento personalMantenimiento = recepcionista.crearPersonalMantenimiento();
                    Recepcionista.agregarDeLista(gym.getGestionPersonalMantenimiento(), personalMantenimiento.getDocumento(), personalMantenimiento);
                    JSONArchivos.exportarUnPersonalMantenimientoAJson(personalMantenimiento);
                    break;
                case 4:
                    System.out.println("Modificar personal de mantenimiento...");
                    Scanner scaner = new Scanner(System.in);
                    System.out.println("ingrese el dni del Personal de mantenimiento a cambiar");
                    String documento = scaner.nextLine();
                    Recepcionista.modificarPersonaldeMantenimiento(documento,gym.getGestionPersonalMantenimiento());
                    JSONArchivos.exportarPersonalMantenimientoAJson(gym);
                    break;
                case 5:
                    System.out.println("Eliminar personal de mantenimiento...");
                    System.out.println("Ingrese documento del personal de mantenimiento a eliminar");
                    Scanner scanerr = new Scanner(System.in);
                    String dnii =scanerr.nextLine();
                    Recepcionista.eliminarDeLista(gym.getGestionPersonalMantenimiento(),dnii);
                    JSONArchivos.eliminarPersonalPorDni(dnii, "PersonalMantenimiento.json");
                    break;
                case 6:
                    System.out.println("Guardar en archivo...");
                    JSONArchivos.exportarPersonalMantenimientoAJson(gym);
                    JSONArchivos.exportarListaPersonalMantenimiento(gym);
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menu principal
    }




    public static void MenuPrincipal(Gimnasio gym) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        JSONArchivos.importarEntrenadoresDesdeJson(gym);
        JSONArchivos.importarMiembrosDesdeJson(gym);


        do {

            // Mostrar el menú principal
            System.out.println("\nMenú Principal:");
            System.out.println("1. Entrenadores");
            System.out.println("2. Miembros");
            System.out.println("3. Máquinas");
            System.out.println("4. Personal de Mantenimiento");

            System.out.println("0. Salir del Programa");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Llamar entrenadores
                    Menu.mostrarMenuEntrenadores(gym);
                    break;
                case 2:
                    // Llamar miembros
                    Menu.mostrarMenuMiembros(gym);
                    break;
                case 3:
                    // Llamar maquinas
                    Menu.mostrarMenuMaquinas(gym);
                    break;
                case 4:
                    // Llamar personal de mantenimiento
                    Menu.mostrarMenuMantenimiento(gym);
                    break;
                case 0:
                    System.out.println("¡Nos vemos! cerrando programa...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 0); // Se cierra el programa cuando se ingrese 0
    }

        // Submenú de entrenadores
        public static void mostrarMenuEntrenadores(Gimnasio gym) {
            Scanner teclado = new Scanner(System.in);
            Recepcionista recepcionista1 = new Recepcionista();
            int opcion;
            GestionGenericaGimnasio<Entrenador> recepcionista = new GestionGenericaGimnasio<>();

            do {
                System.out.println("\nMenú entrenadores:");
                System.out.println("1. Mostrar entrenadores");
                System.out.println("2. Consultar entrenador");
                System.out.println("3. Agregar entrenador");
                System.out.println("4. Modificar entrenador");
                System.out.println("5. Eliminar entrenador");
                System.out.println("6. Asignar miembro a entrenador");
                System.out.println("7. Cantidad de miembros x entrenador");
                System.out.println("8. Calcular salario");
                System.out.println("9. Guardar en archivo");
                System.out.println("0. Volver al Menú Principal");
                System.out.print("Ingrese una opción: ");
                opcion = teclado.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Mostrar entrenadores...");
                        Recepcionista.mostrarElementosLista(gym.getGestionEntrenadores());
                        break;
                    case 2:
                        Scanner tecladoEntrenador = new Scanner(System.in);
                        System.out.println("Consultar entrenador...");
                        System.out.println("ingrese DNI del entrenador a buscar...");
                        String dni = tecladoEntrenador.nextLine();
                        Entrenador entrenadorConsultado = Recepcionista.consultar(gym.getGestionEntrenadores(), dni);
                        System.out.println(entrenadorConsultado);
                        break;
                    case 3:
                        System.out.println("Agregar entrenador...");
                        Entrenador entrenador = recepcionista.crearEntrenador();
                        Recepcionista.agregarDeLista(gym.getGestionEntrenadores(), entrenador.getDocumento(), entrenador);
                        JSONArchivos.exportarEntrenadorAJson(entrenador);

                        break;
                    case 4:
                        System.out.println("Modificar entrenador...");
                        Scanner scaner = new Scanner(System.in);
                        System.out.println("ingrese el dni del entrenador a cambiar");
                        String documento = scaner.nextLine();
                        Recepcionista.modificarEntrenador(documento,gym.getGestionEntrenadores());
                        JSONArchivos.exportarEntrenadoresAJson(gym);

                        break;
                    case 5:
                        System.out.println("Eliminar entrenador...");
                        System.out.println("Ingrese documento del entrenador a eliminar");
                        Scanner scanerr = new Scanner(System.in);
                        String dnii =scanerr.nextLine();
                        Recepcionista.eliminarDeLista(gym.getGestionEntrenadores(),dnii);
                        JSONArchivos.eliminarEntrenadorPorDni(dnii, "Entrenadores.json");
                        break;

                    case 6:
                        Scanner entrada = new Scanner(System.in);
                        System.out.println("Asignando miembro...");

                        // Mostrar entrenadores existentes
                        Recepcionista.mostrarElementosLista(gym.getGestionEntrenadores());

                        // Solicitar documento del entrenador
                        System.out.println("Ingrese el documento del entrenador al que desea asignar un miembro:");
                        String documento2 = entrada.nextLine();

                        // Consultar el entrenador existente en la lista
                        Entrenador entrenadorExistente = gym.getGestionEntrenadores().consultar(documento2);

                        if (entrenadorExistente != null) {
                            // Crear y asignar un nuevo miembro al entrenador existente
                            Miembro nuevoMiembro = recepcionista.crearMiembro();
                            entrenadorExistente.asignarMiembro(nuevoMiembro);
                            System.out.println("Miembro asignado correctamente.");
                        } else {
                            System.out.println("No se encontró un entrenador con el documento proporcionado.");
                        }
                        JSONArchivos.exportarListaEntrenadores(gym);
                        break;

                    case 7:
                        Scanner entradaa = new Scanner(System.in);
                        System.out.println("Mostrar miembros asignados a un entrenador...");

                        // Mostrar entrenadores disponibles
                        Recepcionista.mostrarElementosLista(gym.getGestionEntrenadores());

                        // Solicitar el documento del entrenador
                        System.out.println("Ingrese el documento del entrenador para ver sus miembros asignados:");
                        String documentoEntrenador = entradaa.nextLine();

                        // Buscar al entrenador
                        Entrenador entrenadorParaConsultar = gym.getGestionEntrenadores().consultar(documentoEntrenador);

                        if (entrenadorParaConsultar != null) {
                            // Llamar al método para consultar y mostrar los miembros asignados
                            entrenadorParaConsultar.consultarMiembros();
                        } else {
                            System.out.println("No se encontró un entrenador con el documento proporcionado.");
                        }
                        break;
                    case 8:
                        Scanner tecla = new Scanner(System.in);
                        System.out.println("Calculando salario..");
                        System.out.println("Ingrese dni ");

                        Recepcionista.calcularSalario(gym.getGestionEntrenadores(), tecla.nextLine() );

                        break;
                    case 9:
                        System.out.println("Guardando en archivo...");
                        JSONArchivos.exportarEntrenadoresAJson(gym);
                        JSONArchivos.exportarListaEntrenadores(gym);
                        break;
                    case 0:
                        System.out.println("Volviendo al Menú Principal...");
                        break;
                    default:
                        System.out.println("Opción no válida, por favor intente nuevamente.");
                }
            } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menú principal
        }
    }