package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Libro;
import resenas.modelo.LibroLista;

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
                libro.setIDGenero(rs.getString(9));
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

    public ArrayList getLibrosByAutor(String id){
        Connection connection1 = null;
        ResultSet rs1;
        PreparedStatement ps1;
        ArrayList<Libro> libros = new ArrayList<>();
        try{
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("select * from libro where IDAutor = ?;");
            ps1.setString(1, id);
            rs1 = ps1.executeQuery();
            Libro libro;
            while (rs1.next()){
                libro = new Libro();
                libro.setIDLibro(rs1.getString(1));
                libro.setTitulo(rs1.getString(2));
                libro.setFoto(rs1.getString(3));
                libro.setNumPag(rs1.getInt(4));
                libro.setFechaPublicacion(rs1.getDate(5));
                libro.setIdioma(rs1.getString(6));
                libro.setEditorial(rs1.getString(7));
                libro.setIDAutor(rs1.getString(8));
                libro.setIDGenero(rs1.getString(9));
                libros.add(libro);
            }
            return libros;
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

    public Object getLibrosLista(String id) {
        ArrayList<LibroLista> listas = new ArrayList<>();
        Connection connection1 = null;
        PreparedStatement psG = null;
        ResultSet rsG = null;
        try{
            connection1 = conexion.getConnection();
            psG = connection1.prepareStatement("select * from LibroEnLista where IDLista = ?");
            psG.setString(1, id);
            rsG = psG.executeQuery();
            LibroLista lista;
            while (rsG.next()){
                lista = new LibroLista(rsG.getString(1), rsG.getString(2), rsG.getString(3));
                listas.add(lista);
            }
            return listas;
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

    public ArrayList getLibroByID(String idautor) {
        ArrayList<Libro> list = new ArrayList<>();
        Connection connection1 = null;
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        try{
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("select * from libro where IDLibro = ?;");
            ps1.setString(1, idautor);
            rs1 = ps1.executeQuery();
            Libro libro;
            if(rs1.next()){
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
                list.add(libro);
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

    public Libro getOneLibroByID(String idLibro){
        Connection connection1 = null;
        PreparedStatement ps1 = null;
        ResultSet rs1 = null;
        try{
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("select * from libro where IDLibro = ?;");
            ps1.setString(1, idLibro);
            rs1 = ps1.executeQuery();
            Libro libro;
            if(rs1.next()){
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
                return  libro;
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



}
