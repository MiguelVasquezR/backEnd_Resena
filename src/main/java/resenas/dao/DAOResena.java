package resenas.dao;

import com.google.gson.JsonObject;
import resenas.conexion.Conexion;
import resenas.modelo.Resena;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOResena {

    static Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao persona ";
    private ResultSet rs;
    private PreparedStatement ps;


    public boolean crearResena(Resena resena){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into Resena(IDResena, FechaPublicada, Puntuacion, Contenido, NombreLibro, NombreAutor, Idioma, Editorial, FotoID, IDUsuario) values (?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, resena.getID());
            ps.setDate(2, resena.getFecha());
            ps.setInt(3, resena.getCalificacion());
            ps.setString(4, resena.getContenido());
            ps.setString(5, resena.getNombreLibro());
            ps.setString(6, resena.getNombreAutor());
            ps.setString(7, resena.getIdioma());
            ps.setString(8, resena.getEditorial());
            ps.setString(9, resena.getFotoID());
            ps.setString(10, resena.getIDUsuario());
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public ArrayList getResenas(String id){
        ArrayList<Resena> arrayList = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from resena where IDUsuario = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            Resena resena;
            while (rs.next()){
                resena =  new Resena();
                resena.setID(rs.getString(1));
                resena.setFecha(rs.getDate(2));
                resena.setCalificacion(rs.getInt(3));
                resena.setContenido(rs.getString(4));
                resena.setNombreLibro(rs.getString(5));
                resena.setNombreAutor(rs.getString(6));
                resena.setIdioma(rs.getString(7));
                resena.setEditorial(rs.getString(8));
                resena.setFotoID(rs.getString(9));
                resena.setIDUsuario(rs.getString(10));
                arrayList.add(resena);
            }
            return arrayList;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public ArrayList getResenasFollows(String idO) {
        ArrayList<JsonObject> list = new ArrayList<>();
        Connection connection1 = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try{
            connection1 = conexion.getConnection();
            preparedStatement = connection1.prepareStatement("SELECT Puntuacion, contenido, nombreLibro, nombreAutor, Idioma, editorial, fotoID, usuario.IDUsuario FROM Resena JOIN usuario ON Resena.IDUsuario = usuario.IDUsuario JOIN informacionPersonal AS i ON i.ID = usuario.IDPersona WHERE usuario.IDUsuario IN (SELECT IDUserFollow FROM seguidor WHERE IDUserOrigin = ?);");
            preparedStatement.setString(1, idO);
            resultSet = preparedStatement.executeQuery();
            JsonObject jsonObject;
            while (resultSet.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("puntuacion", resultSet.getInt(1));
                jsonObject.addProperty("contenido", resultSet.getString(2));
                jsonObject.addProperty("nombreLibro", resultSet.getString(3));
                jsonObject.addProperty("nombreAutor", resultSet.getString(4));
                jsonObject.addProperty("idioma", resultSet.getString(5));
                jsonObject.addProperty("editorial", resultSet.getString(6));
                jsonObject.addProperty("fotoID", resultSet.getString(7));
                jsonObject.addProperty("IDUsuario", resultSet.getString(8));
                list.add(jsonObject);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection1.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }


    }
}
