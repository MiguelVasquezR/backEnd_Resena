package resenas.dao;

import com.google.gson.JsonObject;
import resenas.conexion.Conexion;
import resenas.modelo.Autor;
import resenas.modelo.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOAutor {

    Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao usuario ";
    private ResultSet rs;
    private PreparedStatement ps;

    public boolean createAutor(Autor autor){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into autor (IDAutor, Nacionalidad, IDPersona) values (?,?,?)");
            ps.setString(1, autor.getIDAutor());
            ps.setString(2, autor.getNacionalidad());
            ps.setString(3, autor.getIDPersona());
            int res = ps.executeUpdate();
            if (res>0){
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

    public boolean deleteAutor(String id){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("delete from autor where autor.id = ?");
            ps.setString(1, id);
            int res = ps.executeUpdate();
            if (res>0){
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

    public Persona getNombreAutores(String id){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("SELECT I.ID, I.Nombre, I.ApellidoPaterno, I.ApellidoMaterno FROM INFORMACIONPERSONAL AS I, AUTOR AS A WHERE I.ID = A.IDPersona and A.IDAutor = ?;");
            ps.setString(1, id);
            rs = ps.executeQuery();
            Persona persona;
            if(rs.next()){
                persona = new Persona();
                persona.setIDPersona(rs.getString(1));
                persona.setNombre(rs.getString(2));
                persona.setPaterno(rs.getString(3));
                persona.setMaterno(rs.getString(4));
                System.out.println(persona.toString());
                return persona;
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

    public JsonObject getNombreAutores(String nombre, String apellido){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select i.Nombre, i.ApellidoPaterno, i.ApellidoMaterno, a.IDAutor, i.FechaNacimiento, i.FechaDeceso, i.Biografia, a.nacionalidad from InformacionPersonal as i, Autor as a where i.Nombre = ? and i.ApellidoPaterno = ? and i.ID = a.IDPersona");
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            rs = ps.executeQuery();
            JsonObject jsonObject;
            if(rs.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("nombre", rs.getString(1));
                jsonObject.addProperty("paterno", rs.getString(2));
                jsonObject.addProperty("materno", rs.getString(3));
                jsonObject.addProperty("IDAutor", rs.getString(4));
                jsonObject.addProperty("nacimiento", rs.getString(5));
                jsonObject.addProperty("deceso", rs.getString(6));
                jsonObject.addProperty("biografia", rs.getString(7));
                jsonObject.addProperty("nacionalidad", rs.getString(8));

                return jsonObject;
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

    public String getCompletAutor(){
        ArrayList<Autor> autors = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from autor as a, InformacionPersonal as p where a.IDPersona = p.ID;");
            rs = ps.executeQuery();
            rs.next();
            return rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " " + rs.getString(8) + " " + rs.getString(2);
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

    public String getID(String persona) {
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select IDAutor from autor where IDPersona = ?");
            ps.setString(1, persona);
            rs = ps.executeQuery();
            if (rs.next()){
                return rs.getString(1);
            }else{
                return "";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }finally{
            try{
                connection.close();
                ps.close();
                rs.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }
}