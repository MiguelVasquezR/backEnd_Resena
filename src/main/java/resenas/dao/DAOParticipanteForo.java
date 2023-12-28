package resenas.dao;

import resenas.conexion.Conexion;
import resenas.modelo.ParticipanteFoto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOParticipanteForo {

    static Conexion conexion = new Conexion();
    public boolean addParticipanteForo(ParticipanteFoto participanteFoTo){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("insert into ParticipanteForo(IDParticipanteForo, IDUsuario, IDForo) values (?,?,?)");
            ps.setString(1, participanteFoTo.getIDPF());
            ps.setString(2, participanteFoTo.getIDUsuario());
            ps.setString(3, participanteFoTo.getIDForo());
            int res = ps.executeUpdate();
            if(res>0){
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
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean comprobar(ParticipanteFoto participanteFoTo){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("SELECT IDParticipanteForo FROM ParticipanteForo WHERE idusuario = ? and IDForo = ?;");
            ps.setString(1, participanteFoTo.getIDUsuario());
            ps.setString(2, participanteFoTo.getIDForo());
            rs = ps.executeQuery();
            if(rs.next()){
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
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public ArrayList getParticipante(String ID){
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<ParticipanteFoto> list = new ArrayList<>();
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("select IDUsuario from participanteforo where IDForo = ?;");
            ps.setString(1, ID);
            rs = ps.executeQuery();
            ParticipanteFoto participanteFoto;
            while(rs.next()){
                participanteFoto = new ParticipanteFoto();
                participanteFoto.setIDUsuario(rs.getString(1));
                list.add(participanteFoto);
            }
            return list;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }finally {
            try{
                connection.close();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }


    public boolean deleteParticipanteForo(ParticipanteFoto participanteFoto) {
        Connection connection = null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            connection = conexion.getConnection();
            ps = connection.prepareStatement("DELETE FROM ParticipanteForo WHERE idusuario = ? AND IDForo = ?;");
            ps.setString(1, participanteFoto.getIDUsuario());
            ps.setString(2, participanteFoto.getIDForo());
            int res = ps.executeUpdate();
            if(res>0){
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
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
