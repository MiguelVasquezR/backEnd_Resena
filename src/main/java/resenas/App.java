package resenas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import resenas.dao.*;
import resenas.modelo.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static spark.Spark.*;

public class App {

    static Gson gson = new Gson();
    static DAOPersona daoPersona = new DAOPersona();
    static DAOUsuario daoUsuario = new DAOUsuario();
    static DAOAutor daoAutor = new DAOAutor();
    static DAOGeneroUsuario daoGeneroUsuario = new DAOGeneroUsuario();
    static DAOGeneros daoGeneros = new DAOGeneros();
    static DAOLista daoLista = new DAOLista();
    static DAOLibro daoLibro = new DAOLibro();
    static DAOResena daoResena = new DAOResena();
    static String idPersona;
    static String idUsuario;

    public static void main(String[] args) {

        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        // ----------------------------------------------------- Personas
        get("/persona", (request, response) -> {
            String id = request.queryParams("id");
            Persona p = daoPersona.searchPersona(id);
            return gson.toJson(p);
        });

        put("/persona", (request, response) -> {
            JsonObject jsonObject = JsonParser.parseString(request.body()).getAsJsonObject();
            String id = jsonObject.get("id").getAsString();
            Persona persona = gson.fromJson(request.body(), Persona.class);
            persona.setIDPersona(id);
            persona.setfNacimiento(parseDate(request.body()));

            if (daoPersona.updatePersona(persona)) {
                System.out.println("Listo");
            } else {
                System.out.println("Error");
            }

            return "";
        });

        post("/add-biografia", (request, response) -> {
            String biografia = request.queryParams("biografia");
            String IDPersona = request.queryParams("IDPersona");
            JsonObject jsonObject = new JsonObject();
            if (daoPersona.updatePersonaBiografia(biografia, IDPersona)){
                jsonObject.addProperty("MSJ", "Se ha actualizado");
            }else{
                jsonObject.addProperty("MSJ", "No se ha actualizado");
            }
            System.out.println(jsonObject);
            return jsonObject;
        });

        // ----------------------------------------------------- Usuarios
        post("/usuario", (request, response) -> {
            Usuario usuario = gson.fromJson(request.body(), Usuario.class);
            Usuario usuario1 = daoUsuario.searchUser(usuario.getUsuario());
            return gson.toJson(usuario1);
        });

        post("/usuario-personales", (request, response) -> {
            idPersona = randomID();
            Persona persona = gson.fromJson(request.body(), Persona.class);
            persona.setIDPersona(idPersona);
            persona.setfNacimiento(parseDate(request.body()));
            if (daoPersona.createPersone(persona)) {
                System.out.println("Se guardo Persona");
            }
            return "";
        });

        post("/usuario-cuenta", (request, response) -> {
            String datos = request.body();
            Usuario usuario = gson.fromJson(datos, Usuario.class);
            idUsuario = randomID();
            usuario.setIDUsuario(idUsuario);
            usuario.setIDPersona(idPersona);
            if (daoUsuario.createUser(usuario)) {
                System.out.println("Se guardo Usuario");
            }
            return "";
        });

        post("/usuario-genero", (request, response) -> {
            String datos = request.body();
            if (!datos.equals("Sin genero")) {
                String soloTexto = datos.replaceAll("[\\[\\]\"]", "");
                String[] textosSeparados = soloTexto.split(",");
                for (int i = 0; i < textosSeparados.length; i++) {
                    String idGen = daoGeneroUsuario.searchGenero(textosSeparados[i]);
                    daoGeneroUsuario.addGeneros(randomID(), idUsuario, idGen);
                }
            }
            return "";
        });

        put("/usuario", (request, response) -> {
            JsonObject jsonObject = JsonParser.parseString(request.body()).getAsJsonObject();
            String idUsuario = jsonObject.get("idUsuario").getAsString();
            String idPersona = jsonObject.get("idPersona").getAsString();
            Usuario usuario = gson.fromJson(request.body(), Usuario.class);
            usuario.setIDUsuario(idUsuario);
            usuario.setIDPersona(idPersona);
            if (daoUsuario.updateUser(usuario)) {
                System.out.println("Listo");
            } else {
                System.out.println("Usuario error");
            }
            return "";
        });

        post("/red-social", (request, response) -> {
            System.out.println(request.body());
            RedSocial redSocial = gson.fromJson(request.body(), RedSocial.class);
            redSocial.setIDRed(randomID());
            String msj;
            if (daoUsuario.addRedSocial(redSocial)) {
                msj = "Agregado";
            } else {
                msj = "Error al agregar";
            }
            System.out.println(msj);
            return msj;
        });

        get("/red-social", (request, response) -> {
            return gson.toJson(daoUsuario.getRedSocial(request.queryParams("IDUsuario")));
        });

        // ----------------------------------------------------- Autores
        get("/nombre-autores", (request, response) -> {
            String id = request.queryParams("id");

            //return gson.toJson(jsonObject);
            return "";
        });

        post("/autor-datos", (request, response) -> {
            String nombre = request.queryParams("nombre");
            String[] nombreDiv = nombre.split(" ");


            JsonObject jsonObject = daoAutor.getNombreAutores(nombreDiv[0], nombreDiv[1]);
            if ( jsonObject != null){
                return jsonObject;
            }else {
                return "";
            }
        });


        // --------------------------------------------------------- Géneros
        get("/genero", (request, response) -> {
            String nombre = request.queryParams("Nombre").toString();
            return gson.toJson(daoGeneros.getGenero(nombre));
        });


        get("/generos-usuario", (request, response) -> {
            String idUsuario = request.queryParams("IDUsuario");
            return gson.toJson(daoGeneros.getGeneroU(idUsuario));
        });

        // ------------------------------------------------------------ Lista

        post("/crear-lista", (request, response) -> {
            Lista lista = gson.fromJson(request.body(), Lista.class);
            lista.setID(randomID());
            JsonObject jsonObject = new JsonObject();;
            if (daoLista.agregarLista(lista)){
                 jsonObject.addProperty("MSJ", "Guardado");
            }else{
                jsonObject.addProperty("MSJ", "Error");
            }
            return jsonObject;
        });

        post("/get-listas", (request, response) -> {
            String id = request.queryParams("IDUsuario");
            return gson.toJson(daoLista.obtenerListas(id));
        });

        delete("/eliminar-lista", (request, response) -> {
            String id = request.queryParams("id");
            JsonObject jsonObject = new JsonObject();
            String msj;
            if (daoLista.eliminarLista(id)){
                msj = "Eliminado";
            }else{
                msj = "No Eliminado";
            }
            jsonObject.addProperty("Msj", msj);
            return jsonObject;
        });

        //---------------------------------------------------------------- libros
        get("libros", (request, response) -> {
            return gson.toJson(daoLibro.getLibros());
        });

        get("/libros/genero", (request, response) -> {
            String genero = request.queryParams("genero");
            Genero idGenero = daoGeneros.getGenero(genero);
            return gson.toJson(daoLibro.getLibrosByGenero(idGenero.getIDGenero()));
        });

        get("/libros/autor", (request, response) -> {
            String idautor = request.queryParams("autor");
            System.out.println(idautor);
            return gson.toJson(daoLibro.getLibrosByAutor(idautor));
        });


        //---------------------------------------------------------------------- Resenas

        post("/crear-resena", (request, response) -> {
            String IDUsuario = request.queryParams("IDUsuario");
            Resena resena = gson.fromJson(request.body(), Resena.class);
            resena.setID(randomID());
            resena.setIDUsuario(IDUsuario);
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            resena.setFecha(sqlDate);
            String msj;
            if (daoResena.crearResena(resena)){
                msj = "Guardado";
            }else{
                msj = "Error";
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Msj", msj);
            return jsonObject;
        });

        get("/get-resenas", (request, response) -> {
            String id = request.queryParams("IDUsuario");
            return gson.toJson(daoResena.getResenas(id));
        });

    }

    private String getDateString(Date date){
        Date fechaActual = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        String fechaFormateada = formatoFecha.format(fechaActual);
        return fechaFormateada;
    }

    private static Date parseDate(String datos) {
        try {
            JsonObject jsonObject = JsonParser.parseString(datos).getAsJsonObject();
            String fecha = jsonObject.get("nacimiento").getAsString();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(fecha, formato);
            return java.sql.Date.valueOf(localDate);
        } catch (Exception e) {
            System.out.println("Error en fecha: " + e.getMessage());
            return null;
        }
    }

    private static String randomID() {
        return UUID.randomUUID().toString();
    }

}