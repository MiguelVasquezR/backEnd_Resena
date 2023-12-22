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
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from genero where Nombre = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            Genero genero;
            if (rs.next()){
                genero = new Genero();
                genero.setIDGenero(rs.getString(1));
                genero.setNombre(rs.getString(2));
                genero.setDescripcion(rs.getString(3));
                return genero;
            }else{
                return null;
            }
        }catch(SQLException e){
            System.out.println(msj + e.getMessage());
            return null;
        }catch (Exception e){
            System.out.println(msj + e.getMessage());
            return null;
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
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
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }




}
