package resenas.dao;

import resenas.conexion.Conexion;
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


}
