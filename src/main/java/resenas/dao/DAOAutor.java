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
    private String msj = "Error en dao Autor ";
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
        Connection connection1 = null;
        PreparedStatement psGet = null;
        ResultSet rsGet = null;
        try{
            connection1 = conexion.getConnection();
            psGet = connection1.prepareStatement("select ID, Nombre, ApellidoPaterno, ApellidoMaterno from InformacionPersonal as i, Autor as a  where i.ID = a.IDPersona and IDAutor = ?");
            psGet.setString(1, id);
            rsGet = psGet.executeQuery();
            Persona persona;
            if(rsGet.next()){
                persona = new Persona();
                persona.setIDPersona(rsGet.getString(1));
                persona.setNombre(rsGet.getString(2));
                persona.setPaterno(rsGet.getString(3));
                persona.setMaterno(rsGet.getString(4));
                return persona;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(msj + e.getMessage());
            return null;
        }finally {
            try{
                connection1.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public JsonObject getNombreAutores(String nombre, String apellido){
        PreparedStatement psGet = null;
        ResultSet rsGet = null;
        try{
            connection = conexion.getConnection();
            psGet = connection.prepareStatement("select i.Nombre, i.ApellidoPaterno, i.ApellidoMaterno, a.IDAutor, i.FechaNacimiento, i.FechaDeceso, i.Biografia, a.nacionalidad from InformacionPersonal as i, Autor as a where i.Nombre = ? and i.ApellidoPaterno = ? and i.ID = a.IDPersona");
            psGet.setString(1, nombre);
            psGet.setString(2, apellido);
            rsGet = psGet.executeQuery();
            JsonObject jsonObject;
            if(rsGet.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("nombre", rsGet.getString(1));
                jsonObject.addProperty("paterno", rsGet.getString(2));
                jsonObject.addProperty("materno", rsGet.getString(3));
                jsonObject.addProperty("IDAutor", rsGet.getString(4));
                jsonObject.addProperty("nacimiento", rsGet.getString(5));
                jsonObject.addProperty("deceso", rsGet.getString(6));
                jsonObject.addProperty("biografia", rsGet.getString(7));
                jsonObject.addProperty("nacionalidad", rsGet.getString(8));
                return jsonObject;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(msj + e.getMessage());
            return null;
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