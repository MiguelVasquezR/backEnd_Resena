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

    public ArrayList getPublicaciones(){
        Connection connection1 = null;
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        try{
            connection1 = conexion.getConnection();
            ps = connection1.prepareStatement("select * from publicacion");
            rs = ps.executeQuery();
            Publicacion publicacion;
            while (rs.next()){
                publicacion = new Publicacion();
                publicacion.setComentario(rs.getString(1));
                publicacion.setReaccionLike(rs.getInt(2));
                publicacion.setReaccionDislike(rs.getInt(3));
                publicacion.setIDForo(rs.getString(4));
                publicacion.setIDUsuario(rs.getString(5));
                publicaciones.add(publicacion);
            }
            return publicaciones;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection1.close();
            }catch (Exception e){e.getMessage();}
        }
    }
}
