package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPersona {

    static Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao persona ";
    private ResultSet rs;
    private PreparedStatement ps;

    public boolean createPersone(Persona persona){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into InformacionPersonal (ID, nombre, ApellidoPaterno, ApellidoMaterno, FechaNacimiento, Biografia) values (?,?,?,?,?,?)");
            ps.setString(1, persona.getIDPersona());
            ps.setString(2, persona.getNombre());
            ps.setString(3, persona.getPaterno());
            ps.setString(4, persona.getMaterno());
            ps.setDate(5, Date.valueOf(persona.getfNacimiento().toString()));
            ps.setString(6, persona.getBiografia());
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

    public boolean deletePersonne(String id){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("delete from InformacionPersonal where InformacionPersonal.ID = ?");
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
                ps.close();
                rs.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }


    public List getPersonas(){
        ArrayList<Persona> personaArray = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from InformacionPersonal");
            rs = ps.executeQuery();
            Persona persona;
            while (rs.next()){
                persona = new Persona();
                persona.setIDPersona(rs.getString(1));
                persona.setNombre(rs.getString(2));
                persona.setPaterno(rs.getString(3));
                persona.setMaterno(rs.getString(4));
                persona.setfNacimiento(rs.getDate(5));
                persona.setfDeceso(rs.getDate(6));
                persona.setBiografia(rs.getString(7));
                personaArray.add(persona);
            }
            return personaArray;
        }catch(SQLException e){
            System.out.println(msj + e.getMessage());
            return null;
        }catch (Exception e){
            System.out.println(msj + e.getMessage());
            return null;
        }finally {
            try{
                connection.close();
                ps.close();
                rs.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }

    public String lastID(){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("SELECT ID FROM InformacionPersonal ORDER BY ID DESC LIMIT 1");
            rs = ps.executeQuery();
            rs.next();
            return rs.getString("ID");
        }catch (Exception e){
            System.out.println("Error al obtener last ID");
            return "";
        }
    }

    public Persona searchPersona(String id){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from informacionpersonal as p where p.id = ?");
            ps.setString(1, id);
            rs = ps.executeQuery();
            Persona persona;
            if (rs.next()){
                persona = new Persona();
                persona.setIDPersona(rs.getString(1));
                persona.setNombre(rs.getString(2));
                persona.setPaterno(rs.getString(3));
                persona.setMaterno(rs.getString(4));
                persona.setfNacimiento(rs.getDate(5));
                persona.setfDeceso(rs.getDate(6));
                persona.setBiografia(rs.getString(7));
                return  persona;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try {
                connection.close();
                ps.close();
                rs.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean updatePersona(Persona persona){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("update informacionpersonal as p set Nombre=?, ApellidoPaterno=?, ApellidoMaterno=?, Biografia=? where p.id = ?");
            ps.setString(1, persona.getNombre());
            ps.setString(2, persona.getPaterno());
            ps.setString(3, persona.getMaterno());
            ps.setString(4, persona.getBiografia());
            ps.setString(5, persona.getIDPersona());
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
                ps.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean updatePersonaBiografia(String biografia, String IDPersona){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement(" UPDATE informacionpersonal SET Biografia = ? WHERE ID IN (SELECT i.ID FROM (SELECT ID FROM informacionpersonal) AS i JOIN usuario AS u ON i.ID = u.IDPersona WHERE u.IDUsuario = ? ); ");
            ps.setString(1, biografia);
            ps.setString(2, IDPersona);
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
                ps.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean uploadImage(String persona, String IDFoto){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("update InformacionPersonal set Foto = ? where ID = ?");
            ps.setString(1, IDFoto);
            ps.setString(2, persona);
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }


    public String getBiografy(String idUsuario) {
        Connection connection1 = null;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try{
            connection1 = conexion.getConnection();
            preparedStatement = connection1.prepareStatement("select i.biografia from informacionpersonal as i, usuario as u where i.ID = u.IDPersona and u.idusuario = ?;");
            preparedStatement.setString(1, idUsuario);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return resultSet.getString(1);
            }else{
                return "";
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "";
        }finally {
            try {
                connection1.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }



    }
}