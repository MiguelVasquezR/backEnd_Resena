package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Autor;
import resenas.modelo.Usuario;

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

    public List getAutores(){
        ArrayList<Autor> autors = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from Autor");
            rs = ps.executeQuery();
            Autor autor;
            while (rs.next()){
                autor = new Autor();
                autor.setIDAutor(rs.getString(1));
                autor.setNacionalidad(rs.getString(2));
                autor.setIDPersona(rs.getString(3));
                autors.add(autor);
            }
            return autors;
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

}