/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import model.BibliotecaModel;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author daniel davila
 */
public class BibliotecaDAO implements IBibliotecaDAO {

    //Atrubutes
    private Connection conn = null;
    private ArrayList<BibliotecaModel> bibliotecas;

    //Constructor
    public BibliotecaDAO(Connection conn) {
        this.conn = conn;
    }

    /**
     *
     * @param biblioteca
     */
    @Override
    public void agregarBiblioteca(BibliotecaModel biblioteca) {
        try {
            if (conn != null) {
                //conn = ControlIngresoController.eventoBotonConectarDB();
                String sql = "INSERT INTO biblioteca(bib_tag,bib_contenido,"
                        + "bib_fecha) VALUES(?,?,?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                //Inyeccion de datos
                statement.setString(1, biblioteca.getBibliotecaTag());
                statement.setInt(2, biblioteca.getBibliotecaContenidoId());
                statement.setString(3, biblioteca.getBibliotecaFecha());
                int filaInsertada = statement.executeUpdate();
                if (filaInsertada > 0) {
                    System.out.println("Registro agregado");
                    //bibliotecas.add(new BibliotecaModel(filaInsertada, sql, sql, sql, filaInsertada, sql))
                } else {
                    System.out.println("No se agregó el registro");
                }
                //conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo agregar el registro");
            ex.getStackTrace();
            System.out.println("Error: " + ex);
        }
    }

    /**
     * 
     * @param bibliotecaId 
     */
    @Override
    public void eliminarBiblioteca(int bibliotecaId) {
        try {
            if (conn != null) {
                //conn = controller.ControlIngresoController.eventoBotonConectarDB();
                String sql = "DELETE FROM biblioteca\n"
                        + "WHERE (bib_id=?);";
                PreparedStatement statement = conn.prepareStatement(sql);
                //Inyeccion de datos
                statement.setInt(1, bibliotecaId);
                int filaInsertada = statement.executeUpdate();
                if (filaInsertada > 0) {
                    System.out.println("Eliminacion exitosa!");
                } else {
                    System.out.println("No se pudo eliminar el registro");
                }
//                conn.close();
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Error: " + ex);
        }
    }

    /**
     *
     * @param biblioteca Recibe un objeto de clase biblioteca
     */
    @Override
    public void actualizarBiblioteca(BibliotecaModel biblioteca) {
        try {
            if (conn != null) {
                //conn = controller.ControlIngresoController.eventoBotonConectarDB();
                String sql = "UPDATE biblioteca\n"
                        + "SET bib_contenido= ?,"
                        + "bib_tag=?\n"
                        + "WHERE bib_id=?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                //Inyeccion de datos
                statement.setInt(1, biblioteca.getBibliotecaContenidoId());
                statement.setString(2, biblioteca.getBibliotecaTag());
                statement.setInt(3, biblioteca.getBibliotecaId());

                int filaInsertada = statement.executeUpdate();
                if (filaInsertada > 0) {
                    System.out.println("Actualización exitosa!");
                } else {
                    System.out.println("No se pudo actulaizar el registro");
                }
//                conn.close();
            }
        } catch (SQLException ex) {
            ex.getStackTrace();
            System.out.println("Error: "  + ex);
        }
    }

    @Override
    public ArrayList<BibliotecaModel> obtenerBibliotecas() {
        bibliotecas = new ArrayList<>();
        try {
            if (conn != null) {
                //Query de consulta para el objeto bibloteca
                String sql = "SELECT bib_id,bib_fecha,bib_tag,cli_nombre,con_id,con_titulo\n"
                        + "FROM biblioteca JOIN cliente JOIN contenido\n"
                        + "ON biblioteca.bib_tag=cliente.cli_tag "
                        + "AND biblioteca.bib_contenido=contenido.con_id\n"
                        + "ORDER BY bib_id DESC;";
                //Generar la consulta
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Crear los objetos de consulta y añadirlos a la lista bibliotecas
                while (result.next()) {
                    BibliotecaModel bibliotecaModel = new BibliotecaModel(result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getInt(5),
                            result.getString(6));

                    bibliotecas.add(bibliotecaModel);
                }
//                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return bibliotecas;
    }

    @Override
    public ArrayList<BibliotecaModel> obtenerBibliotecasUsuario(String tag) {
        ArrayList<BibliotecaModel> bibliotecasUsuario = new ArrayList<>();
        try {
            if (conn != null) {
                //Query de consulta para el objeto bibloteca
                String sql = "SELECT bib_id,bib_fecha,bib_tag,cli_nombre,con_id,con_titulo\n"
                        + "FROM biblioteca JOIN cliente JOIN contenido\n"
                        + "ON biblioteca.bib_tag=cliente.cli_tag\n"
                        + "AND biblioteca.bib_contenido=contenido.con_id\n"
                        + "WHERE bib_tag LIKE \"%" + tag + "%\"\n"
                        + "ORDER BY bib_id DESC;";
                //Generar la consulta
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Crear los objetos de consulta y añadirlos a la lista bibliotecas
                while (result.next()) {
                    BibliotecaModel bibliotecaModel = new BibliotecaModel(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getInt(5),
                            result.getString(6));

                    bibliotecasUsuario.add(bibliotecaModel);
                }
//                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return bibliotecasUsuario;
    }

    @Override
    public ArrayList<BibliotecaModel> obtenerBibliotecasTitulo(String titulo) {
        ArrayList<BibliotecaModel> bibliotecasTitulos = new ArrayList<>();
        try {
            if (conn != null) {
                //Query de consulta para el objeto bibloteca
                String sql = "SELECT bib_id,bib_fecha,bib_tag,cli_nombre,con_id,con_titulo\n"
                        + "FROM biblioteca JOIN cliente JOIN contenido\n"
                        + "ON biblioteca.bib_tag=cliente.cli_tag\n"
                        + "AND biblioteca.bib_contenido=contenido.con_id\n"
                        + "WHERE con_titulo LIKE \"%" + titulo + "%\"\n"
                        + "ORDER BY bib_id DESC;";
                //Generar la consulta
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Crear los objetos de consulta y añadirlos a la lista bibliotecas
                while (result.next()) {
                    BibliotecaModel bibliotecaModel = new BibliotecaModel(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getInt(5),
                            result.getString(6));

                    bibliotecasTitulos.add(bibliotecaModel);
                }
//                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return bibliotecasTitulos;
    }

    @Override
    public ArrayList<BibliotecaModel> obtenerBibliotecasFecha(String fecha) {
        ArrayList<BibliotecaModel> bibliotecasFecha = new ArrayList<>();
        try {
            if (conn != null) {
                //Query de consulta para el objeto bibloteca
                String sql = "SELECT bib_id,bib_fecha,bib_tag,cli_nombre,con_id,con_titulo\n"
                        + "FROM biblioteca JOIN cliente JOIN contenido\n"
                        + "ON biblioteca.bib_tag=cliente.cli_tag\n"
                        + "AND biblioteca.bib_contenido=contenido.con_id\n"
                        + "WHERE bib_fecha LIKE \"%" + fecha + "%\"\n"
                        + "ORDER BY bib_id DESC;";
                //Generar la consulta
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Crear los objetos de consulta y añadirlos a la lista bibliotecas
                while (result.next()) {
                    BibliotecaModel bibliotecaModel = new BibliotecaModel(
                            result.getInt(1),
                            result.getString(2),
                            result.getString(3),
                            result.getString(4),
                            result.getInt(5),
                            result.getString(6));

                    bibliotecasFecha.add(bibliotecaModel);
                }
//                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return bibliotecasFecha;
    }

    @Override
    public ArrayList<String> obtenerFechas() {
        ArrayList<String> fechas = new ArrayList<>();
        try {
            for (int i = 0; i < bibliotecas.size(); i++) {
                fechas.add(bibliotecas.get(i).getBibliotecaFecha());
            }

        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return fechas;
    }

    public ArrayList<BibliotecaModel> getBibliotecas() {
        return bibliotecas;
    }

}
