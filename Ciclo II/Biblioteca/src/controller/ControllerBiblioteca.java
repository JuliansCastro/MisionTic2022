package controller;

import access.BibliotecaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import model.BibliotecaModel;
import view.BibliotecaView;

/**
 *
 * @author JULIAN C
 */
public class ControllerBiblioteca implements ActionListener{
    //Atributes
    private final BibliotecaView      bibliotecaView;
    private BibliotecaDAO       bibliotecas;
    private DefaultTableModel   tbl_detalle;
    
    private int     bibliotecaId;               //Llave de la Tabla biblioteca
    private String  bibliotecaFecha;            //Fecha de registro
    private String  bibliotecaTag;              //Usuario
    private String  bibliotecaNombreCliente;    //Nombre del usuario
    private int     bibliotecaContenidoId;      //ID de la tabla contenido
    private String  bibliotecaTituloContenido;  //Titulo de la tabla contenido
    
    //Constructor
    public ControllerBiblioteca(BibliotecaView bibliotecaView){ 
        this.bibliotecaView     = bibliotecaView;
        this.bibliotecaView.setVisible(true);
        this.bibliotecaView.setLocationRelativeTo(null);    // Abre la ventana en la mitan de la pantalla
        agregarEventos();
        modelarTablaBusquedas();
    }
    
    public ControllerBiblioteca(BibliotecaDAO bibliotecas, BibliotecaView bibliotecaView){
        this.bibliotecas        = bibliotecas;  
        this.bibliotecaView     = bibliotecaView;
        this.bibliotecaView.setVisible(true);
        this.bibliotecaView.setLocationRelativeTo(null);    // Abre la ventana en la mitan de la pantalla
        agregarEventos();
        modelarTablaBusquedas();
    }
    
    //Methods
    private void agregarEventos(){
        this.bibliotecaView.getBtn_agregar().addActionListener(this);
        
        //Accion para botón 'buscarTitulo'
        this.bibliotecaView.getBtn_buscarTitulo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_buscarTituloActionPerformed(evt);
            }
        });
        
        //Accion para botón 'buscarUsuaario'
        this.bibliotecaView.getBtn_buscarUsuario().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                btn_buscarUsuarioActionPerformed(evt);
            }
        });
        this.bibliotecaView.getCbx_usuario().addActionListener(this);
        this.bibliotecaView.getCbx_contenido().addActionListener(this);
        
        //Accion para botón 'seleccionFecha'
        this.bibliotecaView.getDtc_seleccionarFecha().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dtc_seleccionarFechaPropertyChange(evt);
            }
        });
        
        this.bibliotecaView.getTbl_detalle().addMouseListener(new MouseAdapter() {
            public void MouseClicked(){            
                devolverDatos();
            }
        });
    }
    
    /** ________________________________________________________________________
     * Crea la tabla para las búsquedas
     */
    private void modelarTablaBusquedas(){
        String[] nombreColumnas = {"Fecha y Hora","Usuario","Nombre","Título"};
        ArrayList<BibliotecaModel> listaBibliotecas;
        
        tbl_detalle = new DefaultTableModel(nombreColumnas, 0);
        listaBibliotecas = new BibliotecaDAO().obtenerBibliotecas(); // Crea nuevo object DAO //From DAO
        
        for(BibliotecaModel biblioteca : listaBibliotecas){
            tbl_detalle.addRow(biblioteca.toArray());
        }
        
        bibliotecaView.getTbl_detalle().setModel(tbl_detalle);        
    }
    
    private void devolverDatos(){
        System.out.println("Acción Tabla!");
    }
    
    
    /*
    public String txtContenidoTituloKeyTyped(java.awt.event.KeyEvent evt){
        String result = "";
        if(evt.getKeyCode() ==  KeyEvent.VK_ENTER){
            result =  txt_cotenidoTitulo.getText();
        }        
        return result;
    }
    */

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Por implementar."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void btn_agregarActionPerformed(ActionEvent evt) {                                            
        System.out.println("Acción para el botón Agregar!");
    }
    
    /**
     * 
     * @param evt
     */
    private void btn_buscarTituloActionPerformed(ActionEvent evt) {                                                 
        System.out.println("Acción para el botón buscarTitulo!");
    }
    
    /**
     * 
     * @param evt 
     */
    private void btn_buscarUsuarioActionPerformed(ActionEvent evt) {                                                  
        System.out.println("Acción para el botón buscarUsuario!");
    }
    
    /**
     * 
     * @param evt 
     */
    private void dtc_seleccionarFechaPropertyChange(PropertyChangeEvent evt) {                                                    
        System.out.println("Cambié la fecha");
    } 
}
