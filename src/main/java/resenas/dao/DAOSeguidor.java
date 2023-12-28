package resenas.dao;

import com.google.gson.JsonObject;
import resenas.conexion.Conexion;
import resenas.modelo.Seguidor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOSeguidor {

    static Conexion conexion = new Conexion();


    public boolean follow(Seguidor seguidor){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into SEGUIDOR(IDSeguidor, IDUserOrigin, IDUserFollow) value (?,?,?)");
            ps.setString(1, seguidor.getIDSeguidor());
            ps.setString(2, seguidor.getIDUserOrigin());
            ps.setString(3, seguidor.getIDUserFollow());
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int countFollow1(String ID){ //Contar seguidores
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select count(IDSeguidor) as cantidad from seguidor where IDUserFollow = ?");
            ps.setString(1, ID);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("cantidad");
            }else{
                return 0;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int countFollow2(String ID){ //Contar seguidores
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select count(IDSeguidor) as cantidad from seguidor where IDUserOrigin = ?");
            ps.setString(1, ID);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getInt("cantidad");
            }else{
                return 0;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return 0;
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public ArrayList seguidores(String id) {
        ArrayList<JsonObject> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("SELECT u.IDUsuario, u.NombreUsuario, ip.nombre, ip.apellidopaterno, ip.apellidomaterno, u.Foto\n" +
                    "FROM usuario AS u INNER JOIN informacionpersonal AS ip ON u.IDPersona = ip.ID WHERE u.IDUsuario IN (SELECT DISTINCT s.IDUserFollow\n" +
                    "FROM usuario AS u2 INNER JOIN seguidor AS s ON u2.IDUsuario = s.IDUserFollow WHERE s.IDUserOrigin = ?" +
                    ");");
            ps.setString(1, id);
            rs = ps.executeQuery();
            JsonObject jsonObject;
            while (rs.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("IDUsuario", rs.getString(1));
                jsonObject.addProperty("usuario", rs.getString(2));
                jsonObject.addProperty("nombre", rs.getString(3));
                jsonObject.addProperty("paterno", rs.getString(4));
                jsonObject.addProperty("materno", rs.getString(5));
                jsonObject.addProperty("foto", rs.getString(6));
                list.add(jsonObject);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList seguidos(String id) {
        ArrayList<JsonObject> list = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("SELECT u.IDUsuario, u.NombreUsuario, ip.nombre, ip.apellidopaterno, ip.apellidomaterno, u.Foto\n" +
                    "FROM usuario AS u INNER JOIN informacionpersonal AS ip ON u.IDPersona = ip.ID WHERE u.IDUsuario IN (SELECT DISTINCT s.IDUserOrigin\n" +
                    "FROM usuario AS u2 INNER JOIN seguidor AS s ON u2.IDUsuario = s.IDUserFollow WHERE s.IDUserFollow = ?" +
                    ");");
            ps.setString(1, id);
            rs = ps.executeQuery();
            JsonObject jsonObject;
            while (rs.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("IDUsuario", rs.getString(1));
                jsonObject.addProperty("usuario", rs.getString(2));
                jsonObject.addProperty("nombre", rs.getString(3));
                jsonObject.addProperty("paterno", rs.getString(4));
                jsonObject.addProperty("materno", rs.getString(5));
                jsonObject.addProperty("foto", rs.getString(6));
                list.add(jsonObject);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean unFollow(String origen, String idDes) {
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("delete from seguidor where IDUserOrigin = ? AND IDUserFollow = ?");
            ps.setString(1, origen);
            ps.setString(2, idDes);
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            try{
            connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean unFollows(String origen, String idDes) {
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("delete from seguidor where IDUserOrigin = ? AND IDUserFollow = ?");
            ps.setString(1, idDes);
            ps.setString(2, origen);
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public ArrayList getFollow(String id){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<Seguidor> list = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from seguidor where IDUserOrigin = ?;");
            ps.setString(1, id);
            rs = ps.executeQuery();
            Seguidor seguidor;
            while (rs.next()){
                seguidor = new Seguidor();
                seguidor.setIDSeguidor(rs.getString(1));
                seguidor.setIDUserOrigin(rs.getString(2));
                seguidor.setIDUserFollow(rs.getString(3));
                list.add(seguidor);
            }
            return  list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
             connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }



}
