package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOLibro {


    private Conexion conexion = new Conexion();
    private Connection connection;
    private ResultSet rs;
    private PreparedStatement ps;


    public ArrayList getLibros(){
        ArrayList<Libro> libros = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from libro");
            rs = ps.executeQuery();
            Libro libro;
            while (rs.next()){
                libro = new Libro();
                libro.setIDLibro(rs.getString(1));
                libro.setTitulo(rs.getString(2));
                libro.setFoto(rs.getString(3));
                libro.setNumPag(rs.getInt(4));
                libro.setFechaPublicacion(rs.getDate(5));
                libro.setIdioma(rs.getString(6));
                libro.setEditorial(rs.getString(7));
                libro.setIDAutor(rs.getString(8));
                libro.setIDLibro(rs.getString(9));
                libros.add(libro);
            }
            return libros;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public ArrayList getLibrosByGenero(String genero){
        ArrayList<Libro> libros = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select * from Libro where IDGenero = ?");
            ps.setString(1, genero);
            rs = ps.executeQuery();
            Libro libro;
            while (rs.next()){
                libro = new Libro();
                libro.setIDLibro(rs.getString(1));
                libro.setTitulo(rs.getString(2));
                libro.setFoto(rs.getString(3));
                libro.setNumPag(rs.getInt(4));
                libro.setFechaPublicacion(rs.getDate(5));
                libro.setIdioma(rs.getString(6));
                libro.setEditorial(rs.getString(7));
                libro.setIDAutor(rs.getString(8));
                libro.setIDGenero(rs.getString(9));
                libros.add(libro);
            }
            return libros;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

}
