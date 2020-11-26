package modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class conexion {
    private static final String base = "tienda";
    private static final String URL = "jdbc:mysql://localhost:3306/"+ base;
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private Connection con = null;
    public Connection getConexion(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        con = (Connection)DriverManager.getConnection(this.URL,this.USERNAME,this.PASSWORD);
    }catch(SQLException e){
        System.out.println(e);    
    }   catch (ClassNotFoundException ex) {
            Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
