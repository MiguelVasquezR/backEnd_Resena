package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Foro;
import resenas.modelo.Publicacion;

import java.sql.*;
import java.util.ArrayList;

public class DAOPublicacion {
    Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao publicacion";
    private ResultSet rs;
    private PreparedStatement ps;

    public boolean createPublicacion(Publicacion publicacion){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into publicacion (IDUsuario, IDForo, Comentario, ReaccionLike, ReaccionDislike) values (?,?,?,?,?)");
            ps.setString(1, publicacion.getIDUsuario());
            ps.setString(2, publicacion.getIDForo());
            ps.setString(3, publicacion.getComentario());
            ps.setInt(4, publicacion.getReaccionLike());
            ps.setInt(5, publicacion.getReaccionDislike());
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        } catch(SQLException e){
            System.out.println(msj + e.getMessage());
            return false;
        } catch(Exception e){
            System.out.println(msj + e.getMessage());
            return false;
        } finally{
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }
}
