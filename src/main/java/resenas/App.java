package resenas;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import resenas.dao.*;
import resenas.modelo.Persona;
import resenas.modelo.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;
import static spark.Spark.*;

public class App {

    static Gson gson = new Gson();
    static DAOPersona daoPersona = new DAOPersona();
    static DAOUsuario daoUsuario = new DAOUsuario();
    static DAOAutor daoAutor = new DAOAutor();
    static DAOGeneroUsuario daoGeneroUsuario = new DAOGeneroUsuario();
    static DAOGeneros daoGeneros = new DAOGeneros();
    static String idPersona;
    static String idUsuario;

    public static void main( String[] args ) {

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

        //  ----------------------------------------------------- Personas
        get("/personas", (request, response) -> {
            return gson.toJson(daoPersona.getPersonas());
        });

        //  ----------------------------------------------------- Usuarios
        get("/usuario", (request, response) -> {
            return gson.toJson(daoUsuario.getUsuarios());
        });

        post("/usuario-personales", (request, response) -> {
            idPersona = randomID();
            Persona persona = gson.fromJson(request.body(), Persona.class);
            persona.setIDPersona(idPersona);
            persona.setfNacimiento(parseDate(request.body()));
            if (daoPersona.createPersone(persona)){
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
            if (daoUsuario.createUser(usuario)){
                System.out.println("Se guardo Usuario");
            }
            return "";
        });

        post("/usuario-genero", (request, response) -> {
            String datos = request.body();
            String soloTexto = datos.replaceAll("[\\[\\]\"]", "");
            String[] textosSeparados = soloTexto.split(",");
            for (int i=0; i<textosSeparados.length; i++){
                String idGen = daoGeneroUsuario.searchGenero(textosSeparados[i]);
                daoGeneroUsuario.addGeneros(randomID(), idUsuario, idGen);
            }
            return "";
        });

        put("/usuario", (request, response) -> {
            return gson.toJson(daoUsuario.getUsuarios());
        });

        delete("/usuario", (request, response) -> {
            return gson.toJson(daoUsuario.getUsuarios());
        });


        //  ----------------------------------------------------- Autores
        get("/autor", (request, response) -> {
            return gson.toJson(daoAutor.getCompletAutor());
        });

        post("/autor", (request, response) -> {
            return gson.toJson(daoAutor.getCompletAutor());
        });

        put("/autor", (request, response) -> {
            return gson.toJson(daoAutor.getCompletAutor());
        });

        delete("/autor", (request, response) -> {
            return gson.toJson(daoAutor.getCompletAutor());
        });


        // --------------------------------------------------------- Géneros
        get("/genero", (request, response) -> {
            String nombre = request.queryParams("Nombre").toString();
            return gson.toJson(daoGeneros.getGenero(nombre));
        });

    }

    private static Date parseDate(String datos){
        try{
            JsonObject jsonObject = JsonParser.parseString(datos).getAsJsonObject();
            String fecha = jsonObject.get("nacimiento").getAsString();
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(fecha, formato);
            return  java.sql.Date.valueOf(localDate);
        }catch (Exception e){
            System.out.println("Error en fecha: " + e.getMessage());
            return null;
        }
    }

    private static String randomID(){
        return  UUID.randomUUID().toString();
    }

}