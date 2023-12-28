package resenas.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private Connection connection;

    String url ="jdbc:mysql://resenas.mysql.database.azure.com:3306/resenas?useSSL=true&requireSSL=false";
    String user = "daniel@resenas";
    String password = "pepito*89";

    public Connection getConnection(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection1 = DriverManager.getConnection(url, user, password);
            return connection1;
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
