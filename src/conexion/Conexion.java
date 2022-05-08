package conexion;

import javax.swing.plaf.nimbus.State;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Conexion {

    private static Connection conexion=null;
    public Conexion() {}

    public static Connection getConexion() throws FileNotFoundException, IOException, SQLException, ClassNotFoundException {

        if(conexion == null) {
            Properties properties = new Properties();
            properties.load(new FileReader("config.properties"));
            String servidor = properties.getProperty("HOSTNAME");
            String puerto = properties.getProperty("PORT");
            String driver = properties.getProperty("DRIVER");
            String url = driver+"@"+servidor+":"+puerto+":xe";
            String username = properties.getProperty("USERNAME");
            String password = properties.getProperty("PASSWORD");

            conexion = DriverManager.getConnection(url,username,password);
        }
        return conexion;
    }

    public static void closeConexion() throws SQLException {
        if(conexion != null) {
            conexion.close();
        }
    }

    public static void main(String[] args) {
        try {
            Connection conexionDB = Conexion.getConexion();
            System.out.println(conexionDB);


        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Fallo en la lectura del fichero");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("Fallo en la base de datos");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }
}