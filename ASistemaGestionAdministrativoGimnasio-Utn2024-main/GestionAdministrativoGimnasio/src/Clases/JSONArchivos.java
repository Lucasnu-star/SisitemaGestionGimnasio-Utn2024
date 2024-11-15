package Clases;
import Enums.eTIPOMAQUINA;
import Enums.eTIPOMEMBRESIA;
import Enums.eEspecialidad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.time.LocalDate;

public final class JSONArchivos {

    public JSONArchivos() {
    }

    public static void EscribirArchivoArray(String nombreArchivo, JSONArray nuevosEntrenadores) {
        try {

            JSONArray entrenadoresExistentes = new JSONArray();
            try (FileReader fileReader = new FileReader(nombreArchivo)) {
                int data = fileReader.read();
                StringBuilder fileContent = new StringBuilder();
                while (data != -1) {  // Verifica si aún quedan caracteres por leer en el archivo. El bucle while se detiene cuando data toma el valor -1, es decir, cuando se ha alcanzado el final del archivo.
                    fileContent.append((char) data);
                    data = fileReader.read();
                }
                if (!fileContent.toString().isEmpty()) {  //La condición if (!fileContent.toString().isEmpty()) garantiza que solo se intente convertir el contenido en un JSONArray cuando el archivo tiene datos, evitando errores en caso de que el archivo esté vacío.
                    entrenadoresExistentes = new JSONArray(fileContent.toString());
                }
            } catch (IOException e) {
                System.out.println("Archivo no encontrado. Se creará uno nuevo.");
            }


            for (int i = 0; i < nuevosEntrenadores.length(); i++) {
                entrenadoresExistentes.put(nuevosEntrenadores.getJSONObject(i));
            }


            try (FileWriter fileWriter = new FileWriter(nombreArchivo)) {
                fileWriter.write(entrenadoresExistentes.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void EscribirArchivoObjeto(String nombreArchivo, JSONObject jsonObject) {
        try {
            PrintWriter printWriter = new PrintWriter(new FileWriter(nombreArchivo,true));
            printWriter.write(jsonObject.toString());
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static JSONTokener leerArchivoTokener(String nombreArchivo) {
        JSONTokener jsonTokener = null;
        try {
            jsonTokener = new JSONTokener(new FileReader(nombreArchivo));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }catch(JSONException e){
            e.printStackTrace();
        }

        return jsonTokener;
    }

    public static JSONObject exportarDatosGimnasioAJson(Gimnasio gimnasio){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("nombre", gimnasio.getNombreGimnasio());
            jsonObject.put("direccion", gimnasio.getDireccionGimnasio());
            jsonObject.put("capacidad", gimnasio.getCapacidadGimnasio());
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONArray exportarMiembrosAJson(Gimnasio gimnasio) {
        JSONArray jsonArray = new JSONArray();
        for (Miembro miembro : gimnasio.getGestionMiembros().gestionUsuario.values()) {
            JSONObject jsonObject = miembroToJsonObject(miembro);
            jsonArray.put(jsonObject);
        }

        return jsonArray;
    }

    public static JSONObject miembroToJsonObject(Miembro miembro){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("nombre", miembro.getNombre());
            jsonObject.put("apellido", miembro.getApellido());
            jsonObject.put("documento", miembro.getDocumento());
            jsonObject.put("fechaNacimiento", miembro.getFechaNacimiento().toString());
            jsonObject.put("fechaIncripcion", miembro.getFechaIncripcion());
            jsonObject.put("membresia", membresiaToJsonObject(miembro.getMembresia()));
            jsonObject.put("estadoMembresia", miembro.isEstadoMembresia());
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }


    public static JSONObject membresiaToJsonObject(Membresia membresia){
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject();
            jsonObject.put("descripcion",membresia.getDescripcion());
            jsonObject.put("tipoMembresia", membresia.getTipomembresia());
            jsonObject.put("costoMensual", membresia.getConstoMensual());
        }catch (JSONException e){
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static JSONArray exportarMaquinasAJson(Gimnasio gimnasio) {
        JSONArray jsonArray = new JSONArray();
        for (Maquina maquina : gimnasio.getGestionMaquinas().gestionUsuario.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre", maquina.getNombre());
            jsonObject.put("tipoMaquina", maquina.getTipoMaquina().toString());
            jsonObject.put("estadoMaquina", maquina.isEstadoMaquina());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public static JSONArray exportarEntrenadoresAJson(Gimnasio gimnasio) {
        JSONArray jsonArray = null;
        try{
            jsonArray = new JSONArray();
            for (Entrenador entrenador : gimnasio.getGestionEntrenadores().gestionUsuario.values()) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("nombre", entrenador.getNombre());
                jsonObject.put("apellido", entrenador.getApellido());
                jsonObject.put("documento", entrenador.getDocumento());
                jsonObject.put("salario", entrenador.getSalario());
                jsonObject.put("especialidad", entrenador.getEspecialidad()); // Usar el nombre del enum como string

                JSONArray miembrosAsignadosArray = new JSONArray();
                if (entrenador.getMiembrosAsignados() != null) { // Verifica que la lista no sea nula
                    for (Miembro miembro : entrenador.getMiembrosAsignados()) {
                        JSONObject miembroJson = new JSONObject();
                        miembroJson.put("nombre", miembro.getNombre());
                        miembroJson.put("apellido", miembro.getApellido());
                        miembroJson.put("documento", miembro.getDocumento());
                        miembroJson.put("fechaNacimiento", miembro.getFechaNacimiento().toString());
                        miembroJson.put("estadoMembresia", miembro.isEstadoMembresia());
                        miembroJson.put("fechaIncripcion", miembro.getFechaIncripcion().toString());
                        miembrosAsignadosArray.put(miembroJson);
                    }
                }
                jsonObject.put("miembrosAsignados", miembrosAsignadosArray);
                jsonArray.put(jsonObject);
            }
        }catch (JSONException e){
            e.printStackTrace();
        }


        return jsonArray;
    }





    public static  JSONObject toJsonObject(Especialidad esp)
    {
        JSONObject jsonObject = null;
        try{
            jsonObject= new JSONObject();
            jsonObject.put("descripcion" , esp.getDescripcion());
            jsonObject.put("tipoEspecialidad", esp.getEspecialidad());


        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;

    }

    public static JSONArray exportarPersonalMantenimientoAJson(Gimnasio gimnasio) {
        JSONArray jsonArray = new JSONArray();
        for (PersonalMantenimiento personal : gimnasio.getGestionPersonalMantenimiento().gestionUsuario.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre", personal.getNombre());
            jsonObject.put("apellido", personal.getApellido());
            jsonObject.put("documento", personal.getDocumento());
            jsonObject.put("fechaNacimiento", personal.getFechaNacimiento().toString());
            jsonObject.put("salario", personal.getSalario());
            jsonObject.put("horario", personal.getHorario());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
    }

    public static void exportarDatosGimnasio(Gimnasio gimnasio){
        JSONObject jsonObject = JSONArchivos.exportarDatosGimnasioAJson(gimnasio);
        JSONArchivos.EscribirArchivoObjeto("DatosGimnasio.json", jsonObject);
    }

    public static void exportarListaMiembros(Gimnasio gimnasio) {
        JSONArray jsonArray = JSONArchivos.exportarMiembrosAJson(gimnasio);
        JSONArchivos.EscribirArchivoArray("Miembros.json", jsonArray);
    }

    public static void exportarListaMaquinas(Gimnasio gimnasio) {
        JSONArray jsonArray = exportarMaquinasAJson(gimnasio);
        EscribirArchivoArray("Maquinas.json", jsonArray);
    }

    public static void exportarListaEntrenadores(Gimnasio gimnasio) {
        JSONArray jsonArray = JSONArchivos.exportarEntrenadoresAJson(gimnasio);
        JSONArchivos.EscribirArchivoArray("Entrenadores.json", jsonArray);
    }
    public static void exportarListaPersonalMantenimiento(Gimnasio gimnasio) {
        JSONArray jsonArray = JSONArchivos.exportarPersonalMantenimientoAJson(gimnasio);
        JSONArchivos.EscribirArchivoArray("PersonalMantenimiento.json", jsonArray);
    }

    public static Gimnasio importarDatosGimnasioDesdeJson(){
        Gimnasio gimnasio = new Gimnasio();
        try {
            JSONTokener tokener = leerArchivoTokener("DatosGimnasio.json");
            if (tokener == null) return null;

            JSONObject jsonObject = new JSONObject(tokener);
            gimnasio.setNombreGimnasio(jsonObject.getString("nombre"));
            gimnasio.setDireccionGimnasio(jsonObject.getString("direccion"));
            gimnasio.setCapacidadGimnasio(jsonObject.getInt("capacidad"));
        }catch (JSONException e){
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

        return gimnasio;
    }




    public static void importarMiembrosDesdeJson(Gimnasio gimnasio) {
        try {
            JSONTokener tokener = leerArchivoTokener("Miembros.json");
            if (tokener == null) {
                System.out.println("El archivo no fue leído correctamente.");
                return;
            }

            JSONArray jsonArray = new JSONArray(tokener);
            if (jsonArray.length() == 0) {
                System.out.println("El archivo JSON está vacío.");
                return;
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Imprimir el objeto actual para verificar su contenido

                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String documento = jsonObject.getString("documento");
                LocalDate fechaNacimiento = LocalDate.parse(jsonObject.getString("fechaNacimiento"));
                Membresia membresia = importarMembresiaDesdeJson(jsonObject.getJSONObject("membresia"));
                boolean estadoMembresia = jsonObject.getBoolean("estadoMembresia");
                LocalDate fechaIncripcion = LocalDate.parse(jsonObject.getString("fechaIncripcion"));

                Miembro miembro = new Miembro(nombre, apellido, documento, fechaNacimiento, membresia, estadoMembresia, fechaIncripcion);

                // Agregar miembro al gimnasio
                gimnasio.getGestionMiembros().agregar(documento, miembro);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al importar miembros: " + e.getMessage());
        }
    }

    //Importar membresia desde archivo JSON

    public static Membresia importarMembresiaDesdeJson(JSONObject jsonObject) {
        Membresia membresia = new Membresia();
        try {

            if (jsonObject.has("descripcion")) {
                membresia.setDescripcion(jsonObject.getString("descripcion"));
            } else {
                System.out.println("Clave 'descripcion' no encontrada.");
                membresia.setDescripcion("Descripción predeterminada");
            }

            if (jsonObject.has("tipoMembresia")) {
                String tipo = jsonObject.getString("tipoMembresia");
                try {
                    eTIPOMEMBRESIA tipoMembresiaEnum = eTIPOMEMBRESIA.valueOf(tipo.toUpperCase());
                    membresia.setTipomembresia(tipoMembresiaEnum);
                } catch (IllegalArgumentException e) {

                }
            } else {
                System.out.println("Clave 'tipoMembresia' no encontrada.");
            }

            if (jsonObject.has("costoMensual")) {
                membresia.setCostoMensual(jsonObject.getInt("costoMensual"));
            } else {
                System.out.println("Clave 'costoMensual' no encontrada.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al deserializar membresía: " + e.getMessage());
        }
        return membresia;
    }



    // Importar Maquinas desde archivo JSON
    public static void importarMaquinasDesdeJson(Gimnasio gimnasio) {
        try {
            // Leer el archivo JSON
            JSONTokener tokener = leerArchivoTokener("Maquinas.json");
            if (tokener == null) return;


            JSONArray jsonArray = new JSONArray(tokener);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                eTIPOMAQUINA tipoMaquina = eTIPOMAQUINA.valueOf(jsonObject.getString("tipoMaquina"));
                boolean estadoMaquina = jsonObject.getBoolean("estadoMaquina");


                Maquina maquina = new Maquina(nombre, tipoMaquina, estadoMaquina);


                gimnasio.getGestionMaquinas().agregar(nombre, maquina);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Importar Entrenadores desde archivo JSON
    public static void importarEntrenadoresDesdeJson(Gimnasio gimnasio) {
        try {
            // Leer el archivo JSON
            JSONTokener tokener = leerArchivoTokener("Entrenadores.json");
            if (tokener == null) {
                System.out.println("El archivo no fue leído correctamente.");
                return;
            }

            // Verifica el contenido del archivo para ayudar a detectar errores de formato
            String contenido = tokener.toString();
            System.out.println("Contenido del archivo JSON: " + contenido);

            // Verificar que el archivo JSON comience con un arreglo '['
            if (!contenido.trim().startsWith("[")) {
                System.out.println("El archivo JSON no comienza con un arreglo, formato incorrecto.");
                return;
            }

            // Asegurarse de que el archivo JSON esté bien formado (debe ser un array de objetos)
            JSONArray jsonArray = new JSONArray(tokener);
            if (jsonArray.length() == 0) {
                System.out.println("El archivo JSON está vacío.");
                return;
            }

            // Iterar sobre los objetos del JSON
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Extraer los datos del entrenador desde el objeto JSON
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String documento = jsonObject.getString("documento");
                int salario = jsonObject.getInt("salario");

                // Ajuste para deserializar la especialidad como String y convertirlo a eEspecialidad
                eEspecialidad especialidadEnum = eEspecialidad.valueOf(jsonObject.getString("especialidad").toUpperCase());
                Especialidad especialidad = new Especialidad("Sin descripción", especialidadEnum);

                // Crear el objeto Entrenador
                Entrenador entrenador = new Entrenador(nombre, apellido, documento, LocalDate.now(), salario, "", especialidad);

                // Agregar el entrenador al gimnasio
                gimnasio.getGestionEntrenadores().agregar(documento, entrenador);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al importar entrenadores: " + e.getMessage());
        }
    }

    // Importar Personal de Mantenimiento desde archivo JSON
    public static void importarPersonalMantenimientoDesdeJson(Gimnasio gimnasio) {
        try {
            // Leer el archivo JSON
            JSONTokener tokener = leerArchivoTokener("PersonalMantenimiento.json");
            if (tokener == null) return;

            String contenidoArchivo = tokener.toString();
            // Verificar si el contenido del archivo comienza con '[' (arreglo)
            if (!contenidoArchivo.trim().startsWith("[")) {
                System.out.println("El archivo no comienza con un arreglo JSON. Formato incorrecto.");
                return;
            }

            JSONArray jsonArray = new JSONArray(tokener);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String documento = jsonObject.getString("documento");
                LocalDate fechaNacimiento = LocalDate.parse(jsonObject.getString("fechaNacimiento"));
                int salario = jsonObject.getInt("salario");
                String horario = jsonObject.getString("horario");

                PersonalMantenimiento personal = new PersonalMantenimiento(nombre, apellido, documento, fechaNacimiento, salario, horario);

                gimnasio.getGestionPersonalMantenimiento().agregar(documento, personal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //metodo que elimina entrenador por dni
    public static void eliminarEntrenadorPorDni(String dni, String archivoJson) {
        try {
            // Leer el archivo JSON
            FileReader reader = new FileReader(archivoJson);
            JSONTokener tokener = new JSONTokener(reader);
            JSONArray jsonArray = new JSONArray(tokener);

            boolean entrenadorEliminado = false;

            // Buscar el entrenador por dni
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject entrenador = jsonArray.getJSONObject(i);
                if (entrenador.getString("documento").equals(dni)) {
                    jsonArray.remove(i); // Eliminar el elemento en el índice i
                    entrenadorEliminado = true;
                    break;
                }
            }

            // Verificar si se eliminó el entrenador
            if (entrenadorEliminado) {
                // Sobrescribir el archivo JSON con los datos modificados
                FileWriter writer = new FileWriter(archivoJson);
                writer.write(jsonArray.toString());
                writer.flush();
                writer.close();
                System.out.println("Entrenador con dni " + dni + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un entrenador con el dni: " + dni);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }

    //eliminar de json miembro por dni
    public static void eliminarMiembroPorDni(String dni, String archivoJson) {
        try {
            // Leer el archivo JSON
            FileReader reader = new FileReader(archivoJson);
            JSONTokener tokener = new JSONTokener(reader);
            JSONArray jsonArray = new JSONArray(tokener);

            boolean miembroEliminado = false;

            // Buscar el miembro por dni
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject miembro = jsonArray.getJSONObject(i);
                if (miembro.getString("documento").equals(dni)) {
                    jsonArray.remove(i); // Eliminar el elemento en el índice i
                    miembroEliminado = true;
                    break;
                }
            }

            // Verificar si se eliminó el miembro
            if (miembroEliminado) {
                // Sobrescribir el archivo JSON con los datos modificados
                FileWriter writer = new FileWriter(archivoJson);
                writer.write(jsonArray.toString());
                writer.flush();
                writer.close();
                System.out.println("Miembro con dni " + dni + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un miembro con el dni: " + dni);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }

    //Eliminar personal de mantenimiento por dni
    public static void eliminarPersonalPorDni(String dni, String archivoJson) {
        try {
            // Leer el archivo JSON
            FileReader reader = new FileReader(archivoJson);
            JSONTokener tokener = new JSONTokener(reader);
            JSONArray jsonArray = new JSONArray(tokener);

            boolean personalEliminado = false;

            // Buscar el entrenador por dni
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject personal = jsonArray.getJSONObject(i);
                if (personal.getString("documento").equals(dni)) {
                    jsonArray.remove(i); // Eliminar el elemento en el índice i
                    personalEliminado = true;
                    break;
                }
            }

            // Verificar si se eliminó el entrenador
            if (personalEliminado) {
                // Sobrescribir el archivo JSON con los datos modificados
                FileWriter writer = new FileWriter(archivoJson);
                writer.write(jsonArray.toString());
                writer.flush();
                writer.close();
                System.out.println("Personal de mantenimiento con dni " + dni + " eliminado correctamente.");
            } else {
                System.out.println("No se encontró un personal de mantenimiento con el dni: " + dni);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al leer o escribir el archivo: " + e.getMessage());
        }
    }

    //Importar maquinas de JSON
    public static void importarMaquinasDesdeJson(GestionGenericaGimnasio<Maquina> gestionMaquinas) {
    }

    public static void exportarMaquinaAJson(Maquina maquina) {
        // Convertir el objeto Maquina a un JSONObject
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nombre", maquina.getNombre());
        jsonObject.put("tipoMaquina", maquina.getTipoMaquina().toString());
        jsonObject.put("estadoMaquina", maquina.isEstadoMaquina());

        // Escribir el objeto JSON en un archivo
        EscribirArchivoObjeto("Maquinas.json", jsonObject);
    }


    public static void exportarEntrenadorAJson(Entrenador entrenador) {
        // Crear un JSONObject para almacenar los datos del entrenador
        JSONObject jsonObject = new JSONObject();

        try {
            // Llenar el JSONObject con los atributos del entrenador
            jsonObject.put("nombre", entrenador.getNombre());
            jsonObject.put("apellido", entrenador.getApellido());
            jsonObject.put("documento", entrenador.getDocumento());
            jsonObject.put("salario", entrenador.getSalario());
            jsonObject.put("especialidad", entrenador.getEspecialidad().toString()); // Se asume que la especialidad está en el enum `eEspecialidad`

            // Si el entrenador tiene miembros asignados, también los agregamos
            JSONArray miembrosAsignadosArray = new JSONArray();
            if (entrenador.getMiembrosAsignados() != null) {
                for (Miembro miembro : entrenador.getMiembrosAsignados()) {
                    JSONObject miembroJson = new JSONObject();
                    miembroJson.put("nombre", miembro.getNombre());
                    miembroJson.put("apellido", miembro.getApellido());
                    miembroJson.put("documento", miembro.getDocumento());
                    miembroJson.put("fechaNacimiento", miembro.getFechaNacimiento().toString());
                    miembroJson.put("estadoMembresia", miembro.isEstadoMembresia());
                    miembroJson.put("fechaIncripcion", miembro.getFechaIncripcion().toString());
                    miembrosAsignadosArray.put(miembroJson);
                }
            }

            // Añadir el array de miembros asignados al objeto del entrenador
            jsonObject.put("miembrosAsignados", miembrosAsignadosArray);

            // Escribir el objeto JSON en un archivo
            EscribirArchivoObjeto("Entrenadores.json", jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Error al crear el JSON para el entrenador: " + e.getMessage());

        }
    }
    public static void exportarMiembroAJson(Miembro miembro) {
        // Crear un JSONObject para almacenar los datos del miembro
        JSONObject jsonObject = new JSONObject();

        try {
            // Llenar el JSONObject con los atributos del miembro
            jsonObject.put("nombre", miembro.getNombre());
            jsonObject.put("apellido", miembro.getApellido());
            jsonObject.put("documento", miembro.getDocumento());
            jsonObject.put("fechaNacimiento", miembro.getFechaNacimiento().toString());
            jsonObject.put("estadoMembresia", miembro.isEstadoMembresia());
            jsonObject.put("fechaIncripcion", miembro.getFechaIncripcion().toString());

            // Exportar la membresía del miembro (si está presente)
            if (miembro.getMembresia() != null) {
                JSONObject membresiaJson = new JSONObject();
                membresiaJson.put("descripcion", miembro.getMembresia().getDescripcion());
                membresiaJson.put("tipoMembresia", miembro.getMembresia().getTipomembresia().toString());  // asumiendo que es un enum
                membresiaJson.put("costoMensual", miembro.getMembresia().getConstoMensual());
                jsonObject.put("membresia", membresiaJson);
            }

            // Escribir el objeto JSON en un archivo
            EscribirArchivoObjeto("Miembros.json", jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Error al crear el JSON para el miembro: " + e.getMessage());
        }
    }

    public static void exportarUnPersonalMantenimientoAJson(PersonalMantenimiento personal) {
        // Crear un JSONObject para almacenar los datos del personal de mantenimiento
        JSONObject jsonObject = new JSONObject();

        try {
            // Llenar el JSONObject con los atributos del personal de mantenimiento
            jsonObject.put("nombre", personal.getNombre());
            jsonObject.put("apellido", personal.getApellido());
            jsonObject.put("documento", personal.getDocumento());
            jsonObject.put("fechaNacimiento", personal.getFechaNacimiento().toString());
            jsonObject.put("salario", personal.getSalario());
            jsonObject.put("horario", personal.getHorario());

            // Escribir el objeto JSON en un archivo
            EscribirArchivoObjeto("PersonalMantenimiento.json", jsonObject);

        } catch (JSONException e) {
            e.printStackTrace();
            System.out.println("Error al crear el JSON para el personal de mantenimiento: " + e.getMessage());
        }
    }


}