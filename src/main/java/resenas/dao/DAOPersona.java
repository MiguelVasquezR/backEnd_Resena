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


}