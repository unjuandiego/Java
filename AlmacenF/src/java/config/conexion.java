/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author workj
 */
public class conexion {
        private static final String base = "almacen";
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
