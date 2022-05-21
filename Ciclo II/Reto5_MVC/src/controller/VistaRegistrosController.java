/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.BibliotecaDAO;
import access.ClienteDAO;
import access.ContenidoDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import model.BibliotecaModel;
import view.RegistrarView;
import view.VistaRegistrosView;

/**
 *
 * @author daniel davila
 */
public class VistaRegistrosController {

    //Atributes
    private final VistaRegistrosView vistaRegistrosView;
    private final Connection conn;
    private final BibliotecaDAO bibliotecaDAO;
    private final ContenidoDAO contenidoDAO;
    private final ClienteDAO clienteDAO;
    private DefaultTableModel tablaDetalle;
    private int bibliotecaId;
    private final String[] nombreColumnas = {"No.Registro", "Fecha", "Usuario", "Nombre", "ID Contenido", "Contenido"};

    // Constructors
    public VistaRegistrosController(VistaRegistrosView vistaRegistrosView, Connection conn) {
        this.vistaRegistrosView = vistaRegistrosView;
        this.conn = conn;
        this.bibliotecaDAO = new BibliotecaDAO(conn);
        this.contenidoDAO = new ContenidoDAO(conn);
        this.clienteDAO = new ClienteDAO(conn);

        this.vistaRegistrosView.setVisible(true);
        this.vistaRegistrosView.setLocationRelativeTo(null);
        this.agregarEventos();
        this.modelarTablaInicio();
    }

    //Methods
    private void agregarEventos() {
        this.vistaRegistrosView.getBotonModificarRegistro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonModificarRegistroActionPerformed(evt);
            }
        });

        this.vistaRegistrosView.getBotonAgregarRegistro().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonAgregarRegistroActionPerformed(evt);
            }
        });

        this.vistaRegistrosView.getBotonVerRegistros().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonVerRegistrosActionPerformed(evt);
            }
        });

        this.vistaRegistrosView.getCbxContenido().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CbxContenidoItemStateChanged(evt);
            }
        });

        this.vistaRegistrosView.getCbxUsuario().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CbxUsuarioItemStateChanged(evt);
            }
        });

        this.vistaRegistrosView.getCbxFecha().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CbxFechatemStateChanged(evt);
            }
        });

        this.vistaRegistrosView.getTablaDetalle().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                getIdRowTable(evt);
            }
        });

    }

    private void botonModificarRegistroActionPerformed(ActionEvent evt) {
        //System.out.println("Boton 'modificar' registro!");
        if (bibliotecaId != 0) {
            RegistrarView registrarView = new RegistrarView();
            registrarView.setTitle("Modificar o Eliminar Registro");
            registrarView.getBotonAgregar().setEnabled(false);
            registrarView.getTextIdBiblioteca().setText(Integer.toString(bibliotecaId));
            registrarView.getCbxContenido();
            RegistrarController registrarController = new RegistrarController(
                    registrarView, conn, contenidoDAO, clienteDAO);
        }
    }

    private void botonAgregarRegistroActionPerformed(ActionEvent evt) {
        //System.out.println("Boton 'agregar' registro!");
        RegistrarView registrarView = new RegistrarView();
        registrarView.setTitle("Agregar Registro");
        registrarView.getBotonEliminar().setEnabled(false);
        registrarView.getBotonActualizar().setEnabled(false);
        registrarView.getTextIdBiblioteca().setVisible(false);
        registrarView.getLabelIdUsuario().setVisible(false);
        RegistrarController registrarController = new RegistrarController(
                registrarView, conn, contenidoDAO, clienteDAO);
    }

    private void botonVerRegistrosActionPerformed(ActionEvent evt) {
        System.out.println("Boton 'Ver' registro!");
        modelarTablaInicio();
    }

    private void CbxContenidoItemStateChanged(ItemEvent evt) {
        String item;
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            item = evt.getItem().toString();
            System.out.println("Item: " + item);

            ArrayList<BibliotecaModel> listaContenido;
            listaContenido = bibliotecaDAO.obtenerBibliotecasTitulo(item);
            //System.out.println(listaContenido.toString());
            modelarTabla(listaContenido);
        }
    }

    private void CbxUsuarioItemStateChanged(ItemEvent evt) {
        String item;
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            item = evt.getItem().toString();
            System.out.println("Item: " + item);

            ArrayList<BibliotecaModel> listaBibliotecas;
            listaBibliotecas = bibliotecaDAO.obtenerBibliotecasUsuario(item);
            modelarTabla(listaBibliotecas);
        }
    }

    private void CbxFechatemStateChanged(ItemEvent evt) {
        String item;
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            item = evt.getItem().toString().split(" ")[0];
            System.out.println("Item: " + item);

            ArrayList<BibliotecaModel> listaBibliotecas;
            listaBibliotecas = bibliotecaDAO.obtenerBibliotecasFecha(item);
            modelarTabla(listaBibliotecas);
        }
    }

    private void getIdRowTable(ListSelectionEvent evt) {
        bibliotecaId = (int) this.vistaRegistrosView.getTablaDetalle().getValueAt(vistaRegistrosView.getTablaDetalle().getSelectedRow(), 0);
        //System.out.println(bibliotecaId);
    }

    //Modelos
    private void modelarTablaInicio() {
        tablaDetalle = new DefaultTableModel(nombreColumnas, 0);

        ArrayList<BibliotecaModel> listaBibliotecas;
        listaBibliotecas = bibliotecaDAO.obtenerBibliotecas();
        for (BibliotecaModel bibliotecaModel : listaBibliotecas) {
            tablaDetalle.addRow(bibliotecaModel.toArray());
        }

        vistaRegistrosView.getTablaDetalle().setModel(tablaDetalle);
        configCxbFecha();
        configCxbContenido();
        configCxbUsuarios();
    }

    private void modelarTabla(ArrayList<BibliotecaModel> listaBibliotecas) {
        tablaDetalle = new DefaultTableModel(nombreColumnas, 0);
        for (BibliotecaModel bibliotecaModel : listaBibliotecas) {
            tablaDetalle.addRow(bibliotecaModel.toArray());
        }

        vistaRegistrosView.getTablaDetalle().setModel(tablaDetalle);
        configCxbFecha();
        configCxbContenido();
        configCxbUsuarios();
    }

    public void configCxbFecha() {
        ArrayList<String> fechas = bibliotecaDAO.obtenerFechas();
        fechas.add(0, "Todos");
        this.vistaRegistrosView.getCbxFecha().removeAll();
        this.vistaRegistrosView.getCbxFecha().setModel(
                new DefaultComboBoxModel<>(fechas.toArray(new String[0])
                ));
    }

    public void configCxbContenido() {
        ArrayList<String> titulos = contenidoDAO.obtenerTitulos();
        titulos.add(0, "Todos");
        this.vistaRegistrosView.getCbxContenido().removeAll();
        this.vistaRegistrosView.getCbxContenido().setModel(
                new DefaultComboBoxModel<>(titulos.toArray(new String[0])
                ));
    }

    public void configCxbUsuarios() {
        ArrayList<String> usuarios = clienteDAO.obtenerUsuarios();
        usuarios.add(0, "Todos");
        this.vistaRegistrosView.getCbxUsuario().removeAll();
        this.vistaRegistrosView.getCbxUsuario().setModel(
                new DefaultComboBoxModel<>(usuarios.toArray(new String[0])
                ));
    }
}
