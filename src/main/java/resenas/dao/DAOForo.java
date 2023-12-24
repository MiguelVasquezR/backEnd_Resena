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
            ps = connection.prepareStatement("insert into foro (IDForo, Opcion, Descripcion, Nombre) values (?,?,?,?)");
            ps.setString(1, foro.getIDForo());
            ps.setString(2, foro.getOpcion());
            ps.setString(3, foro.getDescripcion());
            ps.setString(4, foro.getNombre());
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
        ArrayList<Foro> foros = new ArrayList<>();
        try{
            connection1 = conexion.getConnection();
            ps = connection1.prepareStatement("select * from foro");
            rs = ps.executeQuery();
            Foro foro;
            while (rs.next()){
                foro = new Foro();
                foro.setIDForo(rs.getString(1));
                foro.setOpcion(rs.getString(2));
                foro.setDescripcion(rs.getString(3));
                foro.setNombre(rs.getString(5));
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