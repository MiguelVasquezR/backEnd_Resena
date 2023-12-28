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
    static DAOParticipanteForo daoParticipanteForo = new DAOParticipanteForo();
    static DAOUsuario daoUsuario = new DAOUsuario();
    static DAOSeguidor daoSeguidor = new DAOSeguidor();
    static DAOForo daoForo = new DAOForo();

    static DAOPublicacion daoPublicacion = new DAOPublicacion();

    static DAOAutor daoAutor = new DAOAutor();
    static DAOGeneroUsuario daoGeneroUsuario = new DAOGeneroUsuario();
    static DAOGeneros daoGeneros = new DAOGeneros();
    static DAOLista daoLista = new DAOLista();
    static DAOLibro daoLibro = new DAOLibro();
    static DAOResena daoResena = new DAOResena();
    static String idPersona;
    static String idUsuario;

    static String idForo;

    public static void main(String[] args) {

        port(getHerokuAssignedPort());

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

        get("/get-biografia", (request, response) -> {
            String id = request.queryParams("IDPersona");
            JsonObject jsonObject = new JsonObject();
            String bio = daoPersona.getBiografy(id);
            String msj = "";
            if (bio != null){
                if (bio.length() > 0){
                    msj = bio;
                }else{
                    msj = "nada";
                }
            }
            jsonObject.addProperty("bio", msj);
            return jsonObject;
        });



        // ----------------------------------------------------- Usuarios
            post("/usuario", (request, response) -> {
            Usuario usuario = gson.fromJson(request.body(), Usuario.class);
            Usuario usuario1 = daoUsuario.searchUser(usuario.getUsuario());
            return gson.toJson(usuario1);
        });

        get("/usuarioUpload", (request, response) -> {
            String IDPersona = request.queryParams("IDPersona");
            return gson.toJson(daoUsuario.getByIDPersona(IDPersona));
        });

        get("/usuarioById", (request, response) -> {
            String IDUsuario = request.queryParams("IDUsuario");
            return gson.toJson(daoUsuario.searchUserById(IDUsuario));
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
            System.out.println(datos);
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

        get("/getUsuarios", (request, response) -> {
            String usuario = request.queryParams("usuario");
            return gson.toJson(daoUsuario.searchByUser(usuario));
        });

        put("/foto-usuario", (request, response) -> {
            String IDUsuario = request.queryParams("IDUsuario");
            String IDImagen = request.queryParams("Foto");
            if (daoUsuario.uploadPhoto(IDUsuario, IDImagen)){
                return gson.toJson(daoUsuario.usuarioByID(IDUsuario));
            }else{
                return "";
            }
        });

        post("/get-perfil-user", (request, response) -> {
            String id = request.queryParams("IDuser");
            return daoUsuario.getPerfilUser(id);
        });

        get("/getRedes", (request, response) -> {
            return gson.toJson(daoUsuario.getRedSocial(request.queryParams("id")));
        });

        // ----------------------------------------------------- Autores
        get("/nombre-autores", (request, response) -> {
            String id = request.queryParams("id");
            return gson.toJson(daoAutor.getNombreAutores(id));
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


        post("/crear-publicacion", (request, response) -> {
            String datos = request.body();
            Publicacion publicacion = gson.fromJson(datos, Publicacion.class);
            if (daoPublicacion.createPublicacion(publicacion)) {
                System.out.println("Se guardo la publicacion");
            }
            return "";
        });

        get("/publicaciones", (request, response) -> {
            String id = request.queryParams("IDForo");
            return gson.toJson(daoPublicacion.getPub(id));
        });

        get("/participantes", (request, response) -> {
            String id = request.queryParams("IDForo");
            return gson.toJson(daoParticipanteForo.getParticipante(id));
        });


        post("/foro-crear", (request, response) -> {
            String datos = request.body();
            System.out.println(datos);
            Foro foro = gson.fromJson(datos, Foro.class);
            idForo = randomID();
            foro.setIDForo(idForo);
            if (daoForo.createForo(foro)) {
                System.out.println("Se guardo el foro");
            }
            return "";
        });

        get("/foros", (request, response) -> {
            return gson.toJson(daoForo.getForos());
        });

        post("/agregar-participante", (request, response) -> {
            String IDForo = request.queryParams("IDForo");
            String IDUser = request.queryParams("IDUser");
            ParticipanteFoto participanteFoto = new ParticipanteFoto();
            participanteFoto.setIDPF(randomID());
            participanteFoto.setIDForo(IDForo);
            participanteFoto.setIDUsuario(IDUser);
            JsonObject jsonObject = new JsonObject();
            String msj;
            if (daoParticipanteForo.comprobar(participanteFoto)){
                msj = "Ya en grupo";
            }else{
                if (daoParticipanteForo.addParticipanteForo(participanteFoto)){
                    msj = "Agregado al grupo";
                }else{
                    msj = "No se ha agregado";
                }
            }
            jsonObject.addProperty("MSJ", msj);
            return jsonObject;
        });

        delete("/delete-participante", (request, response) -> {
            String IDForo = request.queryParams("IDForo");
            String IDUser = request.queryParams("IDUser");

            ParticipanteFoto participanteFoto = new ParticipanteFoto();
            participanteFoto.setIDPF(randomID());
            participanteFoto.setIDForo(IDForo);
            participanteFoto.setIDUsuario(IDUser);

            JsonObject jsonObject = new JsonObject();
            String msj;
                if (daoParticipanteForo.deleteParticipanteForo(participanteFoto)){
                    msj = "Eliminado del grupo";
                }else{
                    msj = "No se ha Eliminado";
                }
            jsonObject.addProperty("MSJ", msj);
            return jsonObject;
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
                 jsonObject.addProperty("ID", lista.getID());
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

        post("/agregar-libros", (request, response) -> {
            String IDLista = request.queryParams("idlista");
            String IDLibro = request.queryParams("idLibro");
            String id = randomID();
            LibroLista ll = new LibroLista(id, IDLista, IDLibro);
            if (daoLista.agregarLibroLista(ll)){
                int cantidad = daoLista.getCantidad(IDLista);
                System.out.println(cantidad);
                daoLista.actCantidad(cantidad + 1, IDLista);
            }
            return "";
        });

        delete("/eliminar-libros", (request, response) -> {
            String IDLista = request.queryParams("idlista");
            String IDLibro = request.queryParams("idLibro");
            if (daoLista.eliminarLibroLista(IDLista, IDLibro)) {
                int cantidad = daoLista.getCantidad(IDLista);
                daoLista.actCantidad(cantidad - 1, IDLista);
            }
            return "";
        });

        get("/libros-lista", (request, response) -> {
            String id = request.queryParams("IDLista");
            return gson.toJson(daoLibro.getLibrosLista(id));
        });

        get("/get-lista-info", (request, response) -> {
            String id = request.queryParams("id");
            return gson.toJson(daoLista.searchLista(id));
        });

        //---------------------------------------------------------------- libros
        get("/libros", (request, response) -> {
            return gson.toJson(daoLibro.getLibros());
        });

        get("/libros/genero", (request, response) -> {
            String genero = request.queryParams("genero");
            Genero idGenero = daoGeneros.getGenero(genero);
            return gson.toJson(daoLibro.getLibrosByGenero(idGenero.getIDGenero()));
        });

        get("/libros/autor", (request, response) -> {
            String idautor = request.queryParams("autor");
            return gson.toJson(daoLibro.getLibrosByAutor(idautor));
        });

        get("/libros/id", (request, response) -> {
            String idautor = request.queryParams("id");
            return gson.toJson(daoLibro.getLibroByID(idautor));
        });

        get("/libros/idLibro", (request, response) -> {
            String idautor = request.queryParams("id");
            return gson.toJson(daoLibro.getOneLibroByID(idautor));
        });

        get("/optionBook", (request, response) -> {
            String id = request.queryParams("id");
            return gson.toJson(daoLista.getOptionsBook(id));
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

        //------------------------------------------------------------- Follow

        post("/follow", (request, response) -> {
            Seguidor seguidor = gson.fromJson(request.body(), Seguidor.class);
            seguidor.setIDSeguidor(randomID());
            String msj;
            if (daoSeguidor.follow(seguidor)){
                msj = "Nuevo Seguidor";
            }else{
                msj = "No se puedo agregar" ;
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("MSJ", msj);
            return jsonObject;
        });

        get("/count1", (request, response) -> {
            String id = request.queryParams("id");
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("Seguidores", daoSeguidor.countFollow1(id));
            jsonObject.addProperty("Seguidos", daoSeguidor.countFollow2(id));
            return jsonObject;
        });

        get("/seguidores", (request, response) -> {
            String id = request.queryParams("id");
            return gson.toJson(daoSeguidor.seguidores(id));
        });

        get("/seguidos", (request, response) -> {
            String id = request.queryParams("id");
            return gson.toJson(daoSeguidor.seguidos(id));
        });

        delete("/delete-follow", (request, response) -> {
            String origen = request.queryParams("IDOrigen");
            String IDDes = request.queryParams("IDDes");
            JsonObject jsonObject = new JsonObject();
            String msj = "";
            if (daoSeguidor.unFollow(origen, IDDes)){
                msj = "UnFollow";
            }else{
                msj = "Not UnFollow";
            }
            jsonObject.addProperty("msj", msj);
            return jsonObject;
        });

        delete("/delete-follows", (request, response) -> {
            String origen = request.queryParams("IDOrigen");
            String IDDes = request.queryParams("IDDes");
            JsonObject jsonObject = new JsonObject();
            String msj = "";
            if (daoSeguidor.unFollows(origen, IDDes)){
                msj = "UnFollow";
            }else{
                msj = "Not UnFollow";
            }
            jsonObject.addProperty("msj", msj);
            return jsonObject;
        });

        get("/getFollow", (request, response) -> {
           String id = request.queryParams("id");
           return gson.toJson(daoSeguidor.getFollow(id));
        });


        //_------------------------------------------------------------------- Publicacion
        get("/resenas-follow", (request, response) -> {
           String idO = request.queryParams("id");
            return  gson.toJson(daoResena.getResenasFollows(idO));
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


    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

}