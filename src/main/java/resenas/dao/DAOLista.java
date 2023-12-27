package resenas.dao;

import com.google.gson.JsonObject;
import resenas.conexion.Conexion;
import resenas.modelo.LibroLista;
import resenas.modelo.Lista;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

public class DAOLista {

    private Conexion conexion = new Conexion();
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;

    public boolean agregarLista(Lista lista){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert  into Lista (IDLista, Privacidad, Nombre, Descripcion, IDUsuario, CantidadLibros, FOTO) values  (?,?,?,?,?,?,?)");
            ps.setString(1, lista.getID());
            ps.setString(2, lista.getPrivacidad());
            ps.setString(3, lista.getNombre());
            ps.setString(4, lista.getDescripcion());
            ps.setString(5, lista.getIDUsuario());
            ps.setInt(6, lista.getCantidad());
            ps.setString(7, lista.getIDImagen());
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return false;
        }finally {
            try{
                connection.close();
                ps.close();
            }catch (Exception e){
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public ArrayList obtenerListas(String IDUsuario){
        ArrayList<Lista> listas = new ArrayList<>();
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        try{
            connection = conexion.getConnection();
            preparedStatement = connection.prepareStatement("select * from Lista as L where L.IDUsuario = ? ");
            preparedStatement.setString(1, IDUsuario);
            resultSet = preparedStatement.executeQuery();
            Lista lista;
            while(resultSet.next()){
                lista = new Lista();
                lista.setID(resultSet.getString(1));
                lista.setCantidad(resultSet.getInt(2));
                lista.setPrivacidad(resultSet.getString(3));
                lista.setNombre(resultSet.getString(4));
                lista.setDescripcion(resultSet.getString(5));
                lista.setIDUsuario(resultSet.getString(6));
                lista.setIDImagen(resultSet.getString(7));
                listas.add((lista));
            }
            return listas;
        }catch (Exception e){
            System.out.println("Error primer catch: " + e.getMessage());
            return null;
        }
    }

    public boolean eliminarLista(String id){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("delete from Lista where IDLista = ?");
            ps.setString(1, id);
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


    public boolean agregarLibroLista(LibroLista ll){
        Connection connection1 = null;
        PreparedStatement psGet = null;
        try{
            connection1 = conexion.getConnection();
            psGet = connection1.prepareStatement("insert into LibroEnLista(IDLibroLista, IDLista, IDLibro) values (?, ?, ?)");
            psGet.setString(1, ll.getIDLibroLista());
            psGet.setString(2, ll.getIDLista());
            psGet.setString(3, ll.getIDLibro());
            int res = psGet.executeUpdate();
            if (res  > 0){
                return true;
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            try{
                psGet.close();
                connection1.close();
            }catch (Exception e) {System.out.println(e.getMessage());}
        }
    }


    public boolean eliminarLibroLista(String idLista, String idLibro) {
        Connection connection1 = null;
        PreparedStatement preparedStatement = null;
        try{
            connection1 = conexion.getConnection();
            preparedStatement = connection1.prepareStatement("delete from LibroEnLista where IDLista = ? and IDLibro = ?");
            preparedStatement.setString(1, idLista);
            preparedStatement.setString(2, idLibro);
            int res = preparedStatement.executeUpdate();
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
                preparedStatement.close();
                connection1.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    public Lista searchLista(String id) {
        Connection connection1 = null;
        PreparedStatement ps1;
        ResultSet rs1;

        try{
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("select * from lista where IDLista = ?");
            ps1.setString(1, id);
            rs1 = ps1.executeQuery();
            Lista lista;
            if (rs1.next()){
                lista = new Lista();
                lista.setID(rs1.getString(1));
                lista.setCantidad(rs1.getInt(2));
                lista.setPrivacidad(rs1.getString(3));
                lista.setNombre(rs1.getString(4));
                lista.setDescripcion(rs1.getString(5));
                lista.setIDUsuario(rs1.getString(6));
                lista.setIDImagen(rs1.getString(7));
                return lista;
            }else{
                return null;
            }
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

    public ArrayList getOptionsBook(String id) {
        ArrayList<JsonObject> list = new ArrayList();

        Connection connection1 = null;
        PreparedStatement ps1;
        ResultSet rs1;
        try{
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("SELECT l.IDLibro, l.Titulo,l.Foto,l.NumPag,i.Nombre,i.ApellidoPaterno,i.ApellidoMaterno FROM libro AS l JOIN libroenlista AS lel ON l.IDLibro = lel.IDLibro " +
                    "JOIN autor AS a ON l.IDAutor = a.IDAutor \n JOIN informacionpersonal AS i ON a.IDPersona = i.ID WHERE a.IDAutor = l.IDAutor\n" +
                    "AND lel.IDLista = ?");
            ps1.setString(1, id);
            rs1 = ps1.executeQuery();
            JsonObject jsonObject;
            while (rs1.next()){
                jsonObject = new JsonObject();
                jsonObject.addProperty("IDLibro", rs1.getString(1));
                jsonObject.addProperty("Titulo", rs1.getString(2));
                jsonObject.addProperty("Foto", rs1.getString(3));
                jsonObject.addProperty("NumPag", rs1.getString(4));
                jsonObject.addProperty("Nombre", rs1.getString(5));
                jsonObject.addProperty("Paterno", rs1.getString(6));
                jsonObject.addProperty("Materno", rs1.getString(7));
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

    public boolean actCantidad(int cantidad, String id){
        Connection connection1 = null;
        PreparedStatement ps1;
        ResultSet rs1;
        System.out.println(cantidad);
        try {
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("update lista set cantidadLibros = ? where IDLista = ?");
            ps1.setInt(1, cantidad);
            ps1.setString(2, id);
            int res = ps1.executeUpdate();
            if (res>0){
                return true;
            }else{
                return true;
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }finally {
            try{
                connection1.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }

    public int getCantidad(String id) {
        Connection connection1 = null;
        PreparedStatement ps1;
        ResultSet rs1;
        try {
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("select count(IDLista) as cantidad from libroenlista where IDLista = ?;");
            ps1.setString(1, id);
            rs1 = ps1.executeQuery();
            if (rs1.next()){
                return rs1.getInt("cantidad");
            }else{
                return 0;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            try {
                connection1.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
