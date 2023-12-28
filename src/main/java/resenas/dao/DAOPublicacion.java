package resenas.dao;

import com.google.gson.JsonObject;
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

    public ArrayList getPub(String id){
        ArrayList<JsonObject> list = new ArrayList<>();
        Connection connection1=null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try{
            connection1 = conexion.getConnection();
            preparedStatement = connection1.prepareStatement("SELECT u.nombreUsuario, ip.nombre, ip.apellidopaterno, p.comentario, u.Foto FROM usuario AS u INNER JOIN informacionpersonal AS ip INNER JOIN publicacion as p ON u.IDPersona = ip.ID where p.IDUsuario = u.IDUsuario and p.IDForo = ?");
            preparedStatement.setString(1, id);
            resultSet = preparedStatement.executeQuery();
            JsonObject jsonObject;
            while (resultSet.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("usuario", resultSet.getString(1));
                jsonObject.addProperty("nombre", resultSet.getString(2));
                jsonObject.addProperty("paterno", resultSet.getString(3));
                jsonObject.addProperty("comentario", resultSet.getString(4));
                jsonObject.addProperty("foto", resultSet.getString(5));
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
