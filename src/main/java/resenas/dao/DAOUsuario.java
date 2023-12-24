package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.RedSocial;
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

    public boolean updateUser(Usuario usuario){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("update usuario set NombreUsuario=?, Correo=?, Contrasena=? where usuario.IDUsuario = ?");
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getCorreo());
            ps.setString(3, usuario.getPassword());
            ps.setString(4, usuario.getIDUsuario());
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

    public Usuario searchUser(String nomUsuario){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from usuario as u where u.NombreUsuario = ?");
            ps.setString(1, nomUsuario);
            rs = ps.executeQuery();
            Usuario usuario;
            if (rs.next()){
                usuario = new Usuario();
                usuario.setIDUsuario(rs.getString(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setPassword(rs.getString(4));
                usuario.setIDPersona(rs.getString(5));
                usuario.setFoto(rs.getString(6));
                return usuario;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection.close();
                ps.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean addRedSocial(RedSocial redSocial){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into REDSOCIAL (IDRed, URL, IDUsuario) values  (?,?,?)");
            ps.setString(1, redSocial.getIDRed());
            ps.setString(2, redSocial.getURL());
            ps.setString(3, redSocial.getIDUsuario());
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

    public ArrayList getRedSocial(String IDUsuario){
        ArrayList<RedSocial> redSocials = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement(" select * from REDSOCIAL as rd where rd.IDUsuario = ? ");
            ps.setString(1, IDUsuario);
            rs = ps.executeQuery();
            RedSocial redSocial;
            while (rs.next()){
                redSocial = new RedSocial();
                redSocial.setIDRed(rs.getString(1));
                redSocial.setURL(rs.getString(2));
                redSocial.setIDUsuario(rs.getString(3));
                redSocials.add(redSocial);
            }
            return redSocials;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection.close();
                ps.close();
                rs.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public ArrayList searchByUser(String usuario) {
        ArrayList<Usuario> list = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from usuario where NombreUsuario like  ?");
            ps.setString(1, "%" + usuario + "%");
            rs = ps.executeQuery();
            Usuario user;
            while(rs.next()){
                user = new Usuario();
                user.setIDUsuario(rs.getString(1));
                user.setUsuario(rs.getString(2));
                user.setIDPersona(rs.getString(5));
                list.add(user);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean uploadPhoto(String idUsuario, String idImagen) {
        PreparedStatement psU = null;
        try{
            connection = conexion.getConnection();
            psU = connection.prepareStatement("update usuario set Foto = ?  where IDUsuario = ?");
            psU.setString(1, idImagen);
            psU.setString(2, idUsuario);
            int res = psU.executeUpdate();
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

    public Usuario getByIDPersona(String p) {
        PreparedStatement psID = null;
        ResultSet rsID=null;
        try{
            connection = conexion.getConnection();
            psID = connection.prepareStatement("select * from usuario where IDPersona = ?");
            psID.setString(1, p);
            rsID = psID.executeQuery();
            Usuario usuario;
            if (rsID.next()){
                usuario = new Usuario();
                usuario.setIDUsuario(rs.getString(1));
                usuario.setUsuario(rs.getString(2));
                usuario.setCorreo(rs.getString(3));
                usuario.setPassword(rs.getString(4));
                usuario.setIDPersona(rs.getString(5));
                usuario.setFoto(rs.getString(6));
                return usuario;
            }else{
                return null;
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


    public Usuario usuarioByID(String ID){
        PreparedStatement psID = null;
        ResultSet rsID = null;
        try{
            connection = conexion.getConnection();
            psID = connection.prepareStatement("select * from usuario where IDUsuario = ?");
            psID.setString(1, ID);
            rsID = psID.executeQuery();
            Usuario usuario;
            if (rsID.next()){
                usuario = new Usuario();
                usuario.setIDUsuario(rsID.getString(1));
                usuario.setUsuario(rsID.getString(2));
                usuario.setCorreo(rsID.getString(3));
                usuario.setPassword(rsID.getString(4));
                usuario.setIDPersona(rsID.getString(5));
                usuario.setFoto(rsID.getString(6));
                return usuario;
            }else{
                return null;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }


}