/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import model.DatosConexionModel;
import utils.ConexionDB;
import view.IngresoView;
import view.VistaRegistrosView;

/**
 *
 * @author daniel davila
 */
public class IngresoController implements ActionListener{   
    //Atrtibutes
    private final   IngresoView         ingresoVentana;
    private         ConexionDB          conexionDB;
    private         Connection          conn;
    private         DatosConexionModel  datos;
    
    //Constructor
    IngresoController(IngresoView ingresoVentana){
        this.ingresoVentana = ingresoVentana;
        
        this.ingresoVentana.setVisible(true);
        this.ingresoVentana.setLocationRelativeTo(null);
        agregarEventos();
    }

    //Methods
    public final void agregarEventos() { //AgregarEventos
        //Accion para 'botonConectarDB'
        this.ingresoVentana.getBotonConectarDB().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonConectarDBActionPerformed(evt);
            }
        });
        
        this.ingresoVentana.getButtonSalir().addActionListener(this); // Salir
        
    }
    
 
    private void botonConectarDBActionPerformed(ActionEvent evt) {
        //System.out.println("Acción para 'botonConectarDB'");        
        conn = eventoBotonConectarDB();
        if (null != conn){
            this.ingresoVentana.setVisible(false); //Ocultar ventana actual
            
            VistaRegistrosView ventanaRegistros = new VistaRegistrosView();
            VistaRegistrosController vistaRegistrosController;
            vistaRegistrosController = new VistaRegistrosController(ventanaRegistros, conn);
        }
        else {
            this.ingresoVentana.getLabelEstadoConexion().setText("Datos incorrectos intente de nuevo*");      
        }
    }
    
    /**
     *
     * @return Obtiene los datos necesarios para conectarse con la Base de datos para realizar transacciones (Crear,Leer,Actualizar,Borrar)
     */   
    public Connection eventoBotonConectarDB() {  
        String host = this.ingresoVentana.getTxtHost().getText();
        String port = ingresoVentana.getTxtPuerto().getText();
        String username = ingresoVentana.getTxtUsuario().getText();
        String password = ingresoVentana.getTxtContrasena().getText();
        String nameDB = ingresoVentana.getTxtDB().getText();
        datos= new DatosConexionModel(host,port,username,password,nameDB);
        conexionDB = new ConexionDB(datos);
        return conexionDB.getConnection();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
