package Clases;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {

    //Menu principal
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
             System.out.println("8. Verificar membresia");
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
                     try
                     {
                         String dni = tecladoMiembro.nextLine();
                         Miembro miembroConsultado = recepcionista.consultar(gym.getGestionMiembros(), dni);
                         if (miembroConsultado != null) {
                             System.out.println(miembroConsultado);
                         } else {
                             System.out.println("Miembro no encontrado.");
                         }
                     }catch (InputMismatchException e)
                     {
                         e.printStackTrace();
                     }catch (Exception e)
                     {
                         e.printStackTrace();
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
                     try{
                         System.out.println("Ingrese el DNI del miembro a modificar:");
                         String documento = scan.nextLine();
                         Recepcionista.modificarMiembro(documento, gym.getGestionMiembros());
                         JSONArchivos.exportarMiembrosAJson(gym);
                     }catch (InputMismatchException e )
                     {
                         e.printStackTrace();
                     }catch (JSONException e)
                     {
                         e.printStackTrace();
                     }catch (Exception e)
                     {
                         e.printStackTrace();
                     }

                     break;
                 case 5:
                     System.out.println("Eliminar miembro...");
                     Scanner scanEliminar = new Scanner(System.in);
                     System.out.println("Ingrese DNI del miembro a eliminar:");
                     try{
                         String dniEliminar = scanEliminar.nextLine();
                         recepcionista.eliminarDeLista(gym.getGestionMiembros(), dniEliminar);
                         JSONArchivos.eliminarMiembroPorDni(dniEliminar, "Miembros.json");
                     }catch (InputMismatchException e)
                     {
                         e.printStackTrace();
                     }catch (JSONException e)
                     {
                         e.printStackTrace();
                     }catch (Exception e)
                     {
                         e.printStackTrace();
                     }

                     break;
                 case 6:
                     System.out.println("Ver archivo de miembros...");
                     JSONArchivos.importarMiembrosDesdeJson(gym);
                     Recepcionista.mostrarElementosLista(gym.getGestionMiembros());
                     break;
                 case 7:
                     System.out.println("Guardando en archivo...");
                     JSONArchivos.exportarMiembrosAJson(gym);
                     JSONArchivos.exportarListaMiembros(gym);
                     break;
                 case   8:
                     Scanner scanner = new Scanner(System.in);
                     System.out.println("Verificando membresia...");
                     Recepcionista.mostrarElementosLista(gym.getGestionMiembros());
                     System.out.println("Ingrese el dni del usuario a verificar la membresia");
                     try {
                         String dnii = scanner.nextLine();
                         recepcionista.verificarMembresia(gym,dnii);
                     }catch (InputMismatchException e)
                     {
                         e.printStackTrace();
                     }

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
                     try    {
                         String id = tecladoMaquina.nextLine();
                         Maquina maq=Recepcionista.consultar(gym.getGestionMaquinas(),id);
                         System.out.println(maq.toString());
                         JSONArchivos.exportarMaquinasAJson(gym);
                     }catch (InputMismatchException e)
                     {
                         e.printStackTrace();
                     }catch (Exception e){
                         e.printStackTrace();
                     }
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
                     try
                     {
                         String idM = tecladoMaquina.nextLine();
                         Recepcionista.modificarMaquina(idM,gym.getGestionMaquinas());
                         JSONArchivos.exportarMaquinasAJson(gym);
                     }catch (InputMismatchException e)
                     {
                         e.printStackTrace();
                     }catch (JSONException e)
                     {
                         e.printStackTrace();
                     }catch (Exception e)
                     {
                         e.printStackTrace();
                     }
                     break;

                 case 5:
                     JSONArchivos.importarMaquinasDesdeJson(gym.getGestionMaquinas());
                     System.out.println("Eliminar máquina...");
                     System.out.println("ingrese id a eliminar...");
                     try{
                         String idma=tecladoMaquina.nextLine();
                         Recepcionista.eliminarDeLista(gym.getGestionMaquinas(),idma);
                         JSONArchivos.exportarListaMaquinas(gym);
                     }catch (InputMismatchException e)
                     {
                         e.printStackTrace();
                     }catch (Exception e)
                     {
                         e.printStackTrace();
                     }

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
                    try {
                        String dni = tecladoMantenimiento.nextLine();
                        PersonalMantenimiento mantenimientoConsultado = Recepcionista.consultar(gym.getGestionPersonalMantenimiento(), dni);
                        System.out.println(mantenimientoConsultado);
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 3:
                    System.out.println("Agregar personal de mantenimiento...");
                    PersonalMantenimiento personalMantenimiento = recepcionista.crearPersonalMantenimiento();
                    Recepcionista.agregarDeLista(gym.getGestionPersonalMantenimiento(), personalMantenimiento.getDocumento(), personalMantenimiento);
                    JSONArchivos.exportarUnPersonalMantenimientoAJson(personalMantenimiento);
                    break;
                case 4:
                    System.out.println("Modificar personal de mantenimiento...");
                    System.out.println("ingrese el dni del Personal de mantenimiento a cambiar");
                    try {
                        String documento = scanner.nextLine();
                        Recepcionista.modificarPersonaldeMantenimiento(documento, gym.getGestionPersonalMantenimiento());
                        JSONArchivos.exportarPersonalMantenimientoAJson(gym);
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    break;
                case 5:
                    System.out.println("Eliminar personal de mantenimiento...");
                    System.out.println("Ingrese documento del personal de mantenimiento a eliminar");
                    try {
                        String dnii = scanner.nextLine();
                        Recepcionista.eliminarDeLista(gym.getGestionPersonalMantenimiento(), dnii);
                        JSONArchivos.eliminarPersonalPorDni(dnii, "PersonalMantenimiento.json");
                    } catch (InputMismatchException e) {
                        e.printStackTrace();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case 6:
                    System.out.println("Guardar en archivo...");
                    try {
                        JSONArchivos.exportarPersonalMantenimientoAJson(gym);
                        JSONArchivos.exportarListaPersonalMantenimiento(gym);
                    }catch (JSONException e)
                    {
                        e.printStackTrace();
                    }
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intente nuevamente.");
            }
        } while (opcion != 0);  // Cuando se ingresa 0 se vuelve al menu principal
    }

        // Submenú de entrenadores
        public static void mostrarMenuEntrenadores(Gimnasio gym) {
            Scanner scanner = new Scanner(System.in);
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
                opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Mostrar entrenadores...");
                        Recepcionista.mostrarElementosLista(gym.getGestionEntrenadores());
                        break;
                    case 2:
                        Scanner tecladoEntrenador = new Scanner(System.in);
                        System.out.println("Consultar entrenador...");
                        System.out.println("ingrese DNI del entrenador a buscar...");
                        try {
                            String dni = tecladoEntrenador.nextLine();
                            Entrenador entrenadorConsultado = Recepcionista.consultar(gym.getGestionEntrenadores(), dni);
                            System.out.println(entrenadorConsultado);
                        }catch (InputMismatchException e)
                        {
                            e.printStackTrace();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;

                    case 3:
                        System.out.println("Agregar entrenador...");
                        Entrenador entrenador = recepcionista.crearEntrenador();
                        Recepcionista.agregarDeLista(gym.getGestionEntrenadores(), entrenador.getDocumento(), entrenador);
                        JSONArchivos.exportarEntrenadorAJson(entrenador);
                        break;

                    case 4:
                        System.out.println("Modificar entrenador...");
                        System.out.println("ingrese el dni del entrenador a cambiar");
                        try {
                            String documento = scanner.nextLine();
                            Recepcionista.modificarEntrenador(documento,gym.getGestionEntrenadores());
                            JSONArchivos.exportarEntrenadoresAJson(gym);
                        }catch (InputMismatchException e)
                        {
                            e.printStackTrace();
                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }


                        break;
                    case 5:
                        System.out.println("Eliminar entrenador...");
                        System.out.println("Ingrese documento del entrenador a eliminar");
                        try {
                            String dnii =scanner.nextLine();
                            Recepcionista.eliminarDeLista(gym.getGestionEntrenadores(),dnii);
                            JSONArchivos.eliminarEntrenadorPorDni(dnii, "Entrenadores.json");
                        }catch (InputMismatchException e)
                        {
                            e.printStackTrace();
                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;

                    case 6:
                        System.out.println("Asignando miembro...");

                        // Mostrar entrenadores existentes
                        Recepcionista.mostrarElementosLista(gym.getGestionEntrenadores());

                        // Solicitar documento del entrenador
                        System.out.println("Ingrese el documento del entrenador al que desea asignar un miembro:");
                        String documento2 = scanner.nextLine();

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
                        try {
                            JSONArchivos.exportarListaEntrenadores(gym);
                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                        break;

                    case 7:
                        System.out.println("Mostrar miembros asignados a un entrenador...");

                        // Mostrar entrenadores disponibles
                        Recepcionista.mostrarElementosLista(gym.getGestionEntrenadores());

                        // Solicitar el documento del entrenador
                        System.out.println("Ingrese el documento del entrenador para ver sus miembros asignados:");
                        try {
                            String documentoEntrenador = scanner.nextLine();
                            // Buscar al entrenador
                            Entrenador entrenadorParaConsultar = gym.getGestionEntrenadores().consultar(documentoEntrenador);

                            if (entrenadorParaConsultar != null) {
                                // Llamar al método para consultar y mostrar los miembros asignados
                                entrenadorParaConsultar.consultarMiembros();
                            } else {
                                System.out.println("No se encontró un entrenador con el documento proporcionado.");
                            }
                        }catch (InputMismatchException e)
                        {
                            e.printStackTrace();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }

                        break;
                    case 8:
                        Scanner tecla = new Scanner(System.in);
                        System.out.println("Calculando salario..");
                        System.out.println("Ingrese dni ");
                        try {
                            Recepcionista.calcularSalario(gym.getGestionEntrenadores(), tecla.nextLine() );
                        }catch (InputMismatchException e)
                        {
                            e.printStackTrace();
                        }catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        break;
                    case 9:
                        System.out.println("Guardando en archivo...");
                        try{
                            JSONArchivos.exportarEntrenadoresAJson(gym);
                            JSONArchivos.exportarListaEntrenadores(gym);
                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
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
