package Clases;
import java.util.Scanner;
public class Menu{

    public Menu()
    {

    }

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
        System.out.println("4. Recepcionistas");
        System.out.println("5. Personal de Mantenimiento");
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
                // Llamar recepcionistas
                mostrarMenuRecepcionistas(scanner);
                break;

            case 5:
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
    public static void mostrarMenuEntrenadores(Scanner scanner) {
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
                    JSONArchivos.importarEntrenadoresDesdeJson();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menu principal
    }

    // Submenú de miembros
    public static void mostrarMenuMiembros(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\nMenú miembros:");
            System.out.println("1. Mostrar miembros");
            System.out.println("2. Consultar miembro");
            System.out.println("3. Agregar miembro");
            System.out.println("4. Modificar miembro");
            System.out.println("5. Eliminar miembro");
            System.out.println("6. Guardar en archivo");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Mostrar miembros...");
                    break;
                case 2:
                    System.out.println("Consultar miembro...");
                    break;
                case 3:
                    System.out.println("Agregar miembro...");
                    break;
                case 4:
                    System.out.println("Modificar miembro...");
                    break;
                case 5:
                    System.out.println("Eliminar miembro...");
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

    // Submenú de máquinas
    public static void mostrarMenuMaquinas(Scanner scanner) {
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
                    break;
                case 2:
                    System.out.println("Consultar máquina...");
                    break;
                case 3:
                    System.out.println("Agregar máquina...");
                    break;
                case 4:
                    System.out.println("Modificar máquina...");
                    break;
                case 5:
                    System.out.println("Eliminar máquina...");
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

    // Submenú de recepcionistas
    public static void mostrarMenuRecepcionistas(Scanner scanner) {
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
    public static void mostrarMenuMantenimiento(Scanner scanner) {
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
                    break;
                case 2:
                    System.out.println("Consultar personal de mantenimiento...");
                    break;
                case 3:
                    System.out.println("Agregar personal de mantenimiento...");
                    break;
                case 4:
                    System.out.println("Modificar personal de mantenimiento...");
                    break;
                case 5:
                    System.out.println("Eliminar personal de mantenimiento...");
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
}