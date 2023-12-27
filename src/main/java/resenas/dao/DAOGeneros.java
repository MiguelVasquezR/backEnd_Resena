package resenas.dao;

import com.google.gson.JsonObject;
import resenas.conexion.Conexion;
import resenas.modelo.Genero;
import resenas.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOGeneros {
    Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao de género";
    private ResultSet rs;
    private PreparedStatement ps;

    public Genero getGenero(String nombre){
        PreparedStatement psGet = null;
        ResultSet rsGet = null;
        try{
            connection = conexion.getConnection();
            psGet = connection.prepareStatement("select * from genero where Nombre = ?");
            psGet.setString(1, nombre);
            rsGet = psGet.executeQuery();
            Genero genero;
            if (rsGet.next()){
                genero = new Genero();
                genero.setIDGenero(rsGet.getString(1));
                genero.setNombre(rsGet.getString(2));
                genero.setDescripcion(rsGet.getString(3));
                return genero;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println("Segundo catch");
            System.out.println(msj + e.getMessage());
            return null;
        }
    }

    public ArrayList getGeneroU(String id){
        ArrayList<JsonObject> list = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from generosUsuario where IDUsuario = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            JsonObject jsonObject;
            while(rs.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("ID", rs.getString(1));
                jsonObject.addProperty("IDUsuario", rs.getString(2));
                jsonObject.addProperty("IDGenero", rs.getString(3));
                list.add(jsonObject);
            }
            return list;
        }catch(SQLException e){
            System.out.println(msj + e.getMessage());
            return null;
        }catch (Exception e){
            System.out.println(msj + e.getMessage());
            return null;
        }
    }




}
