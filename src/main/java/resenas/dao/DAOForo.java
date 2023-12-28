package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.Foro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOForo {
    Conexion conexion = new Conexion();
    Connection connection;
    private String msj = "Error en dao foro ";
    private ResultSet rs;
    private PreparedStatement ps;

    public boolean createForo(Foro foro){
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into foro (IDForo, Opcion, Descripcion, Nombre, IDFoto, IDUsuario) values (?, ?, ?, ?, ?, ?)");
            ps.setString(1, foro.getIDForo());
            ps.setString(2, foro.getOpcion());
            ps.setString(3, foro.getDescripcion());
            ps.setString(4, foro.getNombre());
            ps.setString(5, foro.getFoto());
            ps.setString(6, foro.getIDUsuario());
            int res = ps.executeUpdate();
            if (res>0){
                return true;
            }else{
                return false;
            }
        } catch(SQLException e){
            System.out.println(msj + e.getMessage());
            return false;
        } catch(Exception e){
            System.out.println(msj + e.getMessage());
            return false;
        } finally{
            try{
                connection.close();
            }catch (SQLException e){
                System.out.println(msj + e.getMessage());
            }
        }
    }

    public ArrayList getForos(){
        Connection connection1 = null;
        PreparedStatement ps1;
        ResultSet rs1;
        ArrayList<Foro> foros = new ArrayList<>();
        try{
            connection1 = conexion.getConnection();
            ps1 = connection1.prepareStatement("select IDForo, Descripcion, Nombre, IDFoto from foro;");
            rs1 = ps1.executeQuery();
            Foro foro;
            while (rs1.next()){
                foro = new Foro();
                foro.setIDForo(rs1.getString(1));
                foro.setDescripcion(rs1.getString(2));
                foro.setNombre(rs1.getString(3));
                foro.setFoto(rs1.getString(4));
                foros.add(foro);
            }
            return foros;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection1.close();
            }catch (Exception e){e.getMessage();}
        }
    }

}