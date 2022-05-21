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
import model.BibliotecaModel;
import view.RegistrarView;

/**
 *
 * @author daniel davila
 */
public class RegistrarController {

    //Atributos
    private final RegistrarView registrarView;
    private final Connection conn;
    private final ContenidoDAO contenidoDAO;
    private final ClienteDAO clienteDAO;
    private final BibliotecaDAO bibliotecaDAO;

    private String bibliotecaTag;
    private String bibliotecaTitulo;
    private int contenidoId;
    private int bibliotecaId;

    /**
     * Contructor
     *
     * @param registrarView
     * @param conn
     * @param contenidoDAO
     * @param clienteDAO
     */
    public RegistrarController(RegistrarView registrarView, Connection conn,
            ContenidoDAO contenidoDAO, ClienteDAO clienteDAO) {
        this.registrarView = registrarView;
        this.conn = conn;
        this.contenidoDAO = contenidoDAO;
        this.clienteDAO = clienteDAO;

        this.bibliotecaDAO = new BibliotecaDAO(conn);
        this.registrarView.setVisible(true);
        this.registrarView.setLocationRelativeTo(null);
        this.agregarEventos();
        this.configCxbContenido();
        configCxbUsuarios();
    }

    //Methods
    private void agregarEventos() {
        this.registrarView.getBotonAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonAgregarActionPerformed(evt);
            }
        });

        this.registrarView.getBotonActualizar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonActualizarActionPerformed(evt);
            }
        });

        this.registrarView.getBotonEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                botonEliminarActionPerformed(evt);
            }
        });

        this.registrarView.getCbxContenido().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CbxContenidoItemStateChanged(evt);
            }
        });

        this.registrarView.getCbxUsuario().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent evt) {
                CbxUsuarioItemStateChanged(evt);
            }
        });

    }

    /**
     * Agregar registro
     *
     * @param evt
     */
    private void botonAgregarActionPerformed(ActionEvent evt) {
        String fecha = this.registrarView.getTextFechaHora().getText().replace("/", "-");
        if (!"Todos".equals(bibliotecaTag)) {
            BibliotecaModel biblioteca = new BibliotecaModel(bibliotecaTag, contenidoId, fecha);
            bibliotecaDAO.agregarBiblioteca(biblioteca);
            this.registrarView.dispose();

        }

    }

    private void botonActualizarActionPerformed(ActionEvent evt) {
        String fecha = this.registrarView.getTextFechaHora().getText().replace("/", "-");
        bibliotecaId = Integer.valueOf(registrarView.getTextIdBiblioteca().getText());

        if (!"Todos".equals(bibliotecaTag)) {

            BibliotecaModel biblioteca = new BibliotecaModel(bibliotecaTag, contenidoId, bibliotecaId, fecha);
            bibliotecaDAO.actualizarBiblioteca(biblioteca);
            System.out.println("Boton 'Editar' registro!");
            this.registrarView.dispose();

        }
    }

    private void botonEliminarActionPerformed(ActionEvent evt) {
        System.out.println("Boton 'Eliminar' registro!");
        String fecha = this.registrarView.getTextFechaHora().getText().replace("/", "-");
        bibliotecaId = Integer.valueOf(registrarView.getTextIdBiblioteca().getText());
        bibliotecaDAO.eliminarBiblioteca(bibliotecaId);
        this.registrarView.dispose();

    }

    private void CbxContenidoItemStateChanged(ItemEvent evt) {
        String item;
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            item = evt.getItem().toString();
            Object[] contenido;
            for (int i = 0; i < contenidoDAO.getContenidos().size(); i++) {
                contenido = contenidoDAO.getContenidos().get(i).toArray();
                if (item == contenido[1].toString()) {
                    bibliotecaTitulo    = contenido[1].toString();
                    contenidoId         = (int) contenido[0];
                }
            }
        }
        //this.registrarView.getCbxContenido().
    }

    private void CbxUsuarioItemStateChanged(ItemEvent evt) {
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            bibliotecaTag = evt.getItem().toString();
            System.out.println("Item: " + bibliotecaTag);
        }
    }

    public final void configCxbContenido() {
        ArrayList<String> titulos = contenidoDAO.obtenerTitulos();
        titulos.add(0, "Todos");
        this.registrarView.getCbxContenido().removeAll();
        this.registrarView.getCbxContenido().setModel(
                new DefaultComboBoxModel<>(titulos.toArray(new String[0])
                ));
    }

    public final void configCxbUsuarios() {
        ArrayList<String> usuarios = clienteDAO.obtenerUsuarios();
        usuarios.add(0, "Todos");
        this.registrarView.getCbxUsuario().removeAll();
        this.registrarView.getCbxUsuario().setModel(
                new DefaultComboBoxModel<>(usuarios.toArray(new String[0])
                ));
    }
}
