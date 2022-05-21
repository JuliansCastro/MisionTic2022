/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author JULIAN C
 */
import model.DatosConexionModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    private DatosConexionModel datos;
    
    //Constructor
    public ConexionDB (DatosConexionModel datos){
        this.datos = datos;
    }

    // Methods
    public Connection getConnection() {
        Connection conn = null;
        // conectar
        try {
            String dbURL = "jdbc:mysql://" + this.datos.getHost() + ":" 
                           + datos.getPort() + "/" + datos.getNameDB(); //generar la conexion            
            conn = DriverManager.getConnection(dbURL, datos.getUsername(), datos.getPassword());

            if (conn != null) {
                System.out.println("Conectado a '" + datos.getNameDB() + "' exitoso");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return conn;
    }

    public void setDatos(DatosConexionModel datos) {
        this.datos = datos;
    }
    
    
}
