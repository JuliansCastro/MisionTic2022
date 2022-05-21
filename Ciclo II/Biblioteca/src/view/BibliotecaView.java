/*
 * DAtes: https://www.campusmvp.es/recursos/post/como-manejar-correctamente-fechas-en-java-el-paquete-java-time.aspx
 * Calendar: http://datojava.blogspot.com/2015/11/jcalendarJavaSwingEjemploTutorial.html
 */
package view;

import com.toedter.calendar.JDateChooser;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

/**
 *
 * @author JULIAN C
 */
public class BibliotecaView extends javax.swing.JFrame {
    /**
     * Creates new form ClienteVista
     */
    public BibliotecaView() {
        initComponents();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        txt_fechaHora.setText(dtf.format(LocalDateTime.now()));
        //System.out.println("yy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_datos = new javax.swing.JPanel();
        lbl__busqTitulo = new javax.swing.JLabel();
        lbl_buscarFecha = new javax.swing.JLabel();
        lbl_busqUsuario = new javax.swing.JLabel();
        btn_buscarUsuario = new javax.swing.JToggleButton();
        btn_buscarTitulo = new javax.swing.JToggleButton();
        txt_contenidoTitulo = new javax.swing.JTextField();
        txt_clienteTag = new javax.swing.JTextField();
        dtc_seleccionarFecha = new com.toedter.calendar.JDateChooser();
        pnl_Detalle = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        tbl_detalle = new javax.swing.JTable();
        pnl_registroDatos = new javax.swing.JPanel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contenido = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        lbl_cantidad = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        txt_fechaHora = new javax.swing.JTextField();
        cbx_usuario = new javax.swing.JComboBox<>();
        cbx_contenido = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca");
        setResizable(false);

        pnl_datos.setBorder(javax.swing.BorderFactory.createTitledBorder("Búsqueda de datos"));

        lbl__busqTitulo.setText("Búsqueda por título:");

        lbl_buscarFecha.setText("Fecha:");

        lbl_busqUsuario.setText("Búsqueda por usuario:");

        btn_buscarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/IconBuscar.png"))); // NOI18N
        btn_buscarUsuario.setMaximumSize(new java.awt.Dimension(25, 25));
        btn_buscarUsuario.setMinimumSize(new java.awt.Dimension(25, 25));
        btn_buscarUsuario.setPreferredSize(new java.awt.Dimension(25, 25));

        btn_buscarTitulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/utils/IconBuscar.png"))); // NOI18N
        btn_buscarTitulo.setMaximumSize(new java.awt.Dimension(25, 25));
        btn_buscarTitulo.setMinimumSize(new java.awt.Dimension(25, 25));
        btn_buscarTitulo.setPreferredSize(new java.awt.Dimension(25, 25));

        dtc_seleccionarFecha.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout pnl_datosLayout = new javax.swing.GroupLayout(pnl_datos);
        pnl_datos.setLayout(pnl_datosLayout);
        pnl_datosLayout.setHorizontalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl__busqTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_contenidoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buscarTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_busqUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_clienteTag, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_buscarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbl_buscarFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dtc_seleccionarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        pnl_datosLayout.setVerticalGroup(
            pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_datosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_datosLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_buscarFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_buscarUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtc_seleccionarFecha, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(69, 69, 69))
                    .addGroup(pnl_datosLayout.createSequentialGroup()
                        .addGroup(pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl_busqUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_clienteTag, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnl_datosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbl__busqTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_contenidoTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btn_buscarTitulo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pnl_Detalle.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        tbl_detalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha y Hora", "Usuario", "Nombre", "Título"
            }
        ));
        scroll.setViewportView(tbl_detalle);

        javax.swing.GroupLayout pnl_DetalleLayout = new javax.swing.GroupLayout(pnl_Detalle);
        pnl_Detalle.setLayout(pnl_DetalleLayout);
        pnl_DetalleLayout.setHorizontalGroup(
            pnl_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_DetalleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll)
                .addContainerGap())
        );
        pnl_DetalleLayout.setVerticalGroup(
            pnl_DetalleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_DetalleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );

        pnl_registroDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de datos"));
        pnl_registroDatos.setToolTipText("");

        lbl_usuario.setText("Usuario:");

        lbl_contenido.setText("Contenido:");

        lbl_fecha.setText("Fecha:");

        lbl_cantidad.setText("Cantidad:");

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        txt_fechaHora.setEditable(false);
        txt_fechaHora.setBorder(null);

        cbx_usuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------" }));

        cbx_contenido.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------" }));

        javax.swing.GroupLayout pnl_registroDatosLayout = new javax.swing.GroupLayout(pnl_registroDatos);
        pnl_registroDatos.setLayout(pnl_registroDatosLayout);
        pnl_registroDatosLayout.setHorizontalGroup(
            pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbx_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                        .addComponent(lbl_usuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbx_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cantidad)
                    .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                            .addComponent(lbl_fecha)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_fechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                            .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(71, 71, 71))
        );
        pnl_registroDatosLayout.setVerticalGroup(
            pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_usuario)
                    .addComponent(cbx_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_fecha)
                    .addComponent(txt_fechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_contenido)
                    .addComponent(lbl_cantidad))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar)
                    .addComponent(cbx_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pnl_registroDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_datos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnl_Detalle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_registroDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnl_Detalle, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_datos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_agregarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JToggleButton btn_buscarTitulo;
    private javax.swing.JToggleButton btn_buscarUsuario;
    private javax.swing.JComboBox<String> cbx_contenido;
    private javax.swing.JComboBox<String> cbx_usuario;
    private com.toedter.calendar.JDateChooser dtc_seleccionarFecha;
    private javax.swing.JLabel lbl__busqTitulo;
    private javax.swing.JLabel lbl_buscarFecha;
    private javax.swing.JLabel lbl_busqUsuario;
    private javax.swing.JLabel lbl_cantidad;
    private javax.swing.JLabel lbl_contenido;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPanel pnl_Detalle;
    private javax.swing.JPanel pnl_datos;
    private javax.swing.JPanel pnl_registroDatos;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable tbl_detalle;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_clienteTag;
    private javax.swing.JTextField txt_contenidoTitulo;
    private javax.swing.JTextField txt_fechaHora;
    // End of variables declaration//GEN-END:variables

    
    //Getters & Setters
    
    public JButton getBtn_agregar() {
        return btn_agregar;
    }

    public void setBtn_agregar(JButton btn_agregar) {
        this.btn_agregar = btn_agregar;
    }

    public JToggleButton getBtn_buscarTitulo() {
        return btn_buscarTitulo;
    }

    public void setBtn_buscarTitulo(JToggleButton btn_buscarTitulo) {
        this.btn_buscarTitulo = btn_buscarTitulo;
    }

    public JToggleButton getBtn_buscarUsuario() {
        return btn_buscarUsuario;
    }

    public void setBtn_buscarUsuario(JToggleButton btn_buscarUsuario) {
        this.btn_buscarUsuario = btn_buscarUsuario;
    }

    public JComboBox<String> getCbx_contenido() {
        return cbx_contenido;
    }

    public void setCbx_contenido(JComboBox<String> cbx_contenido) {
        this.cbx_contenido = cbx_contenido;
    }

    public JComboBox<String> getCbx_usuario() {
        return cbx_usuario;
    }

    public void setCbx_usuario(JComboBox<String> cbx_usuario) {
        this.cbx_usuario = cbx_usuario;
    }

    public JDateChooser getDtc_seleccionarFecha() {
        return dtc_seleccionarFecha;
    }

    public void setDtc_seleccionarFecha(JDateChooser dtc_seleccionarFecha) {
        this.dtc_seleccionarFecha = dtc_seleccionarFecha;
    }

    public JTable getTbl_detalle() {
        return tbl_detalle;
    }

    public void setTbl_detalle(JTable tbl_detalle) {
        this.tbl_detalle = tbl_detalle;
    }

    public JTextField getTxt_cantidad() {
        return txt_cantidad;
    }

    public void setTxt_cantidad(JTextField txt_cantidad) {
        this.txt_cantidad = txt_cantidad;
    }

    public JTextField getTxt_clienteTag() {
        return txt_clienteTag;
    }

    public void setTxt_clienteTag(JTextField txt_clienteTag) {
        this.txt_clienteTag = txt_clienteTag;
    }

    public JTextField getTxt_contenidoTitulo() {
        return txt_contenidoTitulo;
    }

    public void setTxt_contenidoTitulo(JTextField txt_contenidoTitulo) {
        this.txt_contenidoTitulo = txt_contenidoTitulo;
    }

    public JTextField getTxt_fechaHora() {
        return txt_fechaHora;
    }

    public void setTxt_fechaHora(JTextField txt_fechaHora) {
        this.txt_fechaHora = txt_fechaHora;
    }
}