/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package access;

import model.BibliotecaModel;
import utils.ConnectionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author daniel davila
 */
public class BibliotecaDAO implements IBibliotecaDAO {

    private Connection conn = null;

    @Override
    public void agregarBiblioteca(BibliotecaModel biblioteca) {
//        try {
//            if (conn == null) {
//                conn = ConnectionDB.getConnection();
//                String sql = "INSERT INTO biblioteca(bib_id,bib_tag,bib_contenido,bib_fecha) VALUES(?,?,?,?);";
//                PreparedStatement statement = conn.prepareStatement(sql);
//                //Inyeccion de datos
//                statement.setInt(1, biblioteca.getBibliotecaId());
//                statement.setString(2, biblioteca.getBibliotecaTag());
//                statement.setInt(3, biblioteca.getBibliotecaContenidoId());
//                statement.setString(4, biblioteca.getBibliotecaFecha());
//                int filaInsertada = statement.executeUpdate();
//                if (filaInsertada > 0) {
//                    System.out.println("Registro agregado");
//                } else {
//                    System.out.println("No se agregó el registro");
//                }
//                conn.close();
//            }
//        } catch (SQLException ex) {
//            System.out.println("No se pudo agregar el registro");
//            ex.getStackTrace();
//        }

    }

    @Override
    public void eliminarBiblioteca(BibliotecaModel biblioteca) {
//        try {
//            if (conn == null) {
//                conn = ConnectionDB.getConnection();
//                String sql = "DELETE FROM biblioteca\n"
//                        + "WHERE (bib_id=?);";
//                PreparedStatement statement = conn.prepareStatement(sql);
//                //Inyeccion de datos
//                statement.setInt(1, biblioteca.getBibliotecaId());
//                int filaInsertada = statement.executeUpdate();
//                if (filaInsertada > 0) {
//                    System.out.println("Eliminacion exitosa!");
//                } else {
//                    System.out.println("No se pudo eliminar el registro");
//                }
//                conn.close();
//            }
//        } catch (SQLException ex) {
//            ex.getStackTrace();
//        }
    }
    

    /**
     * 
     * @return Todas las bibliotecas registradas
     */
    @Override
    public ArrayList<BibliotecaModel> obtenerBibliotecas() {
        ArrayList<BibliotecaModel> bibliotecas = new ArrayList<>();
        try {
            if (conn == null) {
                conn = ConnectionDB.getConnection(); //Abrir la conexion con DB
                System.out.println(conn);
                //Query de consulta para el objeto bibloteca
                String sql = "SELECT  bib_id, bib_fecha, bib_tag,\n" +
                             "        cli_nombre, con_id, con_titulo\n" +
                             "FROM    biblioteca JOIN cliente JOIN contenido\n" +
                             "ON      biblioteca.bib_tag=cliente.cli_tag\n" +
                             "AND     biblioteca.bib_contenido=contenido.con_id\n" +
                             "ORDER BY bib_id DESC;";
                //Generar la consulta
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Crear los objetos de consulta y añadirlos a la lista bibliotecas
                while (result.next()) {
                    /* Result = {1.bib_id, 2.bib_fecha, 3.bib_tag, 4.cli_nombre, 5.con_id, 6.con_titulo}
                     * new BibliotecaModel(Id, Fecha, Tag, NombreCliente, ContenidoId, TituloContenido)
                     * nombreColumnas = {"Fecha","Usuario","Nombre","Título"};
                     */
                    BibliotecaModel biblioteca = new BibliotecaModel(result.getInt(1),
                                                                     result.getString(2),
                                                                     result.getString(3),
                                                                     result.getString(4),
                                                                     result.getInt(5),
                                                                     result.getString(6)
                                                                     );
                    bibliotecas.add(biblioteca);
                    //System.out.println(bibliotecas.toString());
                }
                conn.close();
                System.out.println("Connection close!");
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        
        return bibliotecas;
    }
    
    
    @Override
    public void actualizarBiblioteca(int bibliotecaId){
        
    }
}
