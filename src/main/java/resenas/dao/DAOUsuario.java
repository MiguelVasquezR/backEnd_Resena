package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario {
    Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao usuario ";
    private ResultSet rs;
    private PreparedStatement ps;

    public boolean createUser(Usuario usuario){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into usuario (IDUsuario, NombreUsuario, Correo, Contrasena, IDPersona) values (?,?,?,?,?)");
            ps.setString(1, usuario.getIDUsuario());
            ps.setString(2, usuario.getUsuario());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, usuario.getIDPersona());
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

    public boolean deleteUser(String id){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("delete from usuario where usuario.id = ?");
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

    public List getUsuarios(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from Usuario");
            rs = ps.executeQuery();
            Usuario usuario;
            while (rs.next()){
                usuario = new Usuario();
                usuario.setIDUsuario(rs.getString(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setPassword(rs.getString(4));
                usuario.setIDPersona(rs.getString(5));
                usuarios.add(usuario);
            }
            return usuarios;
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

    public String lastID(){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("SELECT IDUsuario FROM Usuario ORDER BY IDUsuario DESC LIMIT 1");
            rs = ps.executeQuery();
            rs.next();
            return rs.getString("IDUsuario");
        }catch (Exception e){
            System.out.println("Error al obtener last ID");
            return "";
        }
    }

}
