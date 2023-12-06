package resenas.dao;

import resenas.conexion.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOGeneroUsuario {

    Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao usuario ";
    private ResultSet rs;
    private PreparedStatement ps;

    public String searchGenero(String nombre){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select IDGenero from Genero where Genero.Nombre = ?");
            ps.setString(1, nombre);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString(1);
            }else{
                return "";
            }
        }catch(SQLException e){
            System.out.println(msj + e.getMessage());
            return "";
        }catch (Exception e){
            System.out.println(msj + e.getMessage());
            return "";
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }



    public boolean addGeneros(String id, String idUsuario, String idGenero){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into GenerosUsuario (ID, IDUsuario, IDGenero) values (?,?,?)");
            ps.setString(1, id);
            ps.setString(2, idUsuario);
            ps.setString(3, idGenero);
            int res = ps.executeUpdate();
            if (res > 0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            System.out.println(msj + e.getMessage());
            return false;
        }catch (Exception e){
            System.out.println(msj + e.getMessage());
            return false;
        }finally {
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }





}
