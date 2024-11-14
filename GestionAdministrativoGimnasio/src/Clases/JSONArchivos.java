package Clases;
import Enums.eTIPOMAQUINA;
import Enums.eTIPOMEMBRESIA;
import Enums.eEspecialidad;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
            FileWriter fileWriter = new FileWriter(nombreArchivo);
            fileWriter.write(jsonObject.toString());
            fileWriter.close();
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
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre", miembro.getNombre());
            jsonObject.put("apellido", miembro.getApellido());
            jsonObject.put("documento", miembro.getDocumento());
            jsonObject.put("fechaNacimiento", miembro.getFechaNacimiento().toString());
            jsonObject.put("membresia", membresiaToJsonObject(miembro.getMembresia()));
            jsonObject.put("estadoMembresia", miembro.isEstadoMembresia());
            jsonObject.put("fechaIncripcion", miembro.getFechaIncripcion());
            jsonArray.put(jsonObject);
        }
        return jsonArray;
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

    public static JSONArray exportarEntrenadoresAJson(Gimnasio gimnasio ) {
        JSONArray jsonArray = new JSONArray();
        for (Entrenador entrenador : gimnasio.getGestionEntrenadores().gestionUsuario.values()) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("nombre", entrenador.getNombre());
            jsonObject.put("apellido", entrenador.getApellido());
            jsonObject.put("documento", entrenador.getDocumento());
            jsonObject.put("salario", entrenador.getSalario());
            jsonObject.put("especialidad", toJsonObject(entrenador.getEspecialidad())); // Guarda el nombre del enum como string

            jsonArray.put(jsonObject);
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
        JSONArray jsonArray = JSONArchivos.exportarMaquinasAJson(gimnasio);
        JSONArchivos.EscribirArchivoArray("Maquinas.json", jsonArray);
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
        }

        return gimnasio;
    }


    public static void importarMiembrosDesdeJson(Gimnasio gimnasio) {
        try {

            JSONTokener tokener = leerArchivoTokener("Miembros.json");
            if (tokener == null) return;


            JSONArray jsonArray = new JSONArray(tokener);


            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String documento = jsonObject.getString("documento");
                LocalDate fechaNacimiento = LocalDate.parse(jsonObject.getString("fechaNacimiento"));
                Membresia membresia = importarMembresiaDesdeJson(jsonObject.getJSONObject("membresia"));
                boolean estadoMembresia = jsonObject.getBoolean("estadoMembresia");
                LocalDate fechaIncripcion = LocalDate.parse(jsonObject.getString("fechaIncripcion"));


                Miembro miembro = new Miembro(nombre, apellido, documento, fechaNacimiento, membresia, estadoMembresia, fechaIncripcion);

                gimnasio.getGestionMiembros().agregar(documento, miembro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Membresia importarMembresiaDesdeJson(JSONObject jsonObject){
        Membresia membresia = new Membresia();
        try {
            membresia.setDescripcion(jsonObject.getString("descripcion"));
            String tipo = jsonObject.getString("tipoMembresia");
            eTIPOMEMBRESIA tipomembresia = eTIPOMEMBRESIA.valueOf(tipo);
            membresia.setTipomembresia(tipomembresia);
            membresia.setCostoMensual(jsonObject.getInt("costoMensual"));
        }catch (IllegalArgumentException e){
            e.printStackTrace();
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

            JSONArray jsonArray = new JSONArray(tokener);
            if (jsonArray.length() == 0) {
                System.out.println("El archivo JSON está vacío.");
                return;
            }

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                // Imprimir el objeto actual para verificar su contenido
                System.out.println("Entrenador JSON: " + jsonObject);

                String nombre = jsonObject.getString("nombre");
                String apellido = jsonObject.getString("apellido");
                String documento = jsonObject.getString("documento");
                int salario = jsonObject.getInt("salario");
                Especialidad especialidad  =  Especialidad.fromJSONObject(jsonObject.getJSONObject("especialidad"));




                Entrenador entrenador = new Entrenador(nombre, apellido, documento, LocalDate.now(), salario, "", especialidad );

                // Agregar entrenador al gimnasio
                gimnasio.getGestionEntrenadores().agregar(documento, entrenador);

                System.out.println("Entrenador agregado: " + entrenador);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al importar entrenadores: " + e.getMessage());
        }
    }



    // Importar Personal de Mantenimiento desde archivo JSON
    public static void importarPersonalMantenimientoDesdeJson(Gimnasio gimnasio) {
        try {

            JSONTokener tokener = leerArchivoTokener("PersonalMantenimiento.json");
            if (tokener == null) return;


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



}


