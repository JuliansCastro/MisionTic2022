/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ContenidoModel;

/**
 *
 * @author daniel davila
 */
public class ContenidoDAO implements IContenidoDAO {

    //Atributes
    private Connection conn;
    private ArrayList<ContenidoModel> contenidos = new ArrayList<>();

    //Constructor
    public ContenidoDAO(Connection conn) {
        this.conn = conn;
        contenidos = this.obtenerTodosContenidos();
    }

    //Methods
    @Override
    public final ArrayList<ContenidoModel> obtenerTodosContenidos() {
        //contenidos = new ArrayList<>();
        try {
            if (conn != null) {
                //conn = controller.IngresoController.eventoBotonConectarDB(); //Abrir la conexion con DB
                System.out.println(conn);
                //Query de consulta para el objeto contenido
                String sql = "SELECT con_id,con_titulo,con_descripcion \n"
                        + "FROM  contenido;";
                //Generar la consulta
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Crear los objetos de consulta y añadirlos a la lista contenidos
                while (result.next()) {
                    ContenidoModel contenido = new ContenidoModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3));
                    contenidos.add(contenido);
                }
                //conn.close();
            }
        } catch (SQLException ex) {
        }
        return contenidos;
    }

    

    @Override
    public ArrayList<String> obtenerTitulos() {
        ArrayList<String> titulos = new ArrayList<>();
        try {
            for (int i = 0; i < contenidos.size(); i++) {
                titulos.add(contenidos.get(i).getContenidoTitulo());
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return titulos;
    }

    public ArrayList<ContenidoModel> getContenidos() {
        return contenidos;
    }
}
