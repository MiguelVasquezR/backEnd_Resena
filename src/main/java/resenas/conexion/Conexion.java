package resenas.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection connection;
    private String user = "root";
    private String password = "ad";
    private String ulr = "jdbc:mysql://localhost:3306/resenas";

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(ulr, user, password);
        }catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void closeConnection(){
        try{
            connection.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
