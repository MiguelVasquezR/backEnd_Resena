package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Genero;
import resenas.modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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




}
