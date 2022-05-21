/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author JULIAN C
 * Fechas: https://www.delftstack.com/es/howto/java/how-to-get-the-current-date-time-in-java/
 * ctrl + shift + i : shorcut para importar
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class RegistrarView extends javax.swing.JFrame {

    /**
     * Creates new form RegistrarVenta
     */
    public RegistrarView() {
        initComponents();
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yy/MM/dd HH:mm:ss");
        txt_fechaHora.setText(dtf.format(LocalDateTime.now()));
        System.out.println("yy/MM/dd HH:mm:ss-> "+dtf.format(LocalDateTime.now()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_registroDatos = new javax.swing.JPanel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contenido = new javax.swing.JLabel();
        jLabel_fecha = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txt_cantidad = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        txt_fechaHora = new javax.swing.JTextField();
        cbx_usuario = new javax.swing.JComboBox<>();
        cbx_contenido = new javax.swing.JComboBox<>();
        pnl_previsualizacion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_previsualizacion = new javax.swing.JTable();
        btn_comprar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnl_registroDatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Registro de datos"));
        pnl_registroDatos.setToolTipText("");

        lbl_usuario.setText("Usuario:");

        lbl_contenido.setText("Contenido:");

        jLabel_fecha.setText("Fecha:");

        jLabel1.setText("Cantidad:");

        btn_agregar.setText("Agregar");

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
                    .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                        .addComponent(jLabel_fecha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_fechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                        .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbx_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_cantidad))
                        .addGap(37, 37, 37)
                        .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                        .addComponent(lbl_usuario)
                        .addGap(18, 18, 18)
                        .addComponent(cbx_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );
        pnl_registroDatosLayout.setVerticalGroup(
            pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_registroDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_usuario)
                    .addComponent(cbx_usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_contenido)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_agregar)
                    .addComponent(cbx_contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(pnl_registroDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_fecha)
                    .addComponent(txt_fechaHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );

        pnl_previsualizacion.setBorder(javax.swing.BorderFactory.createTitledBorder("Previsualización"));

        tbl_previsualizacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Título", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(tbl_previsualizacion);

        javax.swing.GroupLayout pnl_previsualizacionLayout = new javax.swing.GroupLayout(pnl_previsualizacion);
        pnl_previsualizacion.setLayout(pnl_previsualizacionLayout);
        pnl_previsualizacionLayout.setHorizontalGroup(
            pnl_previsualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnl_previsualizacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnl_previsualizacionLayout.setVerticalGroup(
            pnl_previsualizacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        btn_comprar.setText("Registrar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnl_previsualizacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnl_registroDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btn_comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnl_registroDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnl_previsualizacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_comprar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_comprar;
    private javax.swing.JComboBox<String> cbx_contenido;
    private javax.swing.JComboBox<String> cbx_usuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel_fecha;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_contenido;
    private javax.swing.JLabel lbl_usuario;
    private javax.swing.JPanel pnl_previsualizacion;
    private javax.swing.JPanel pnl_registroDatos;
    private javax.swing.JTable tbl_previsualizacion;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_fechaHora;
    // End of variables declaration//GEN-END:variables

    // Setters & Getters
    public JButton getBtn_agregar() {
        return btn_agregar;
    }

    public void setBtn_agregar(JButton btn_agregar) {
        this.btn_agregar = btn_agregar;
    }

    public JButton getBtn_comprar() {
        return btn_comprar;
    }

    public void setBtn_comprar(JButton btn_comprar) {
        this.btn_comprar = btn_comprar;
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

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel_fecha() {
        return jLabel_fecha;
    }

    public void setjLabel_fecha(JLabel jLabel_fecha) {
        this.jLabel_fecha = jLabel_fecha;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JLabel getLbl_contenido() {
        return lbl_contenido;
    }

    public void setLbl_contenido(JLabel lbl_contenido) {
        this.lbl_contenido = lbl_contenido;
    }

    public JLabel getLbl_usuario() {
        return lbl_usuario;
    }

    public void setLbl_usuario(JLabel lbl_usuario) {
        this.lbl_usuario = lbl_usuario;
    }

    public JPanel getPnl_previsualizacion() {
        return pnl_previsualizacion;
    }

    public void setPnl_previsualizacion(JPanel pnl_previsualizacion) {
        this.pnl_previsualizacion = pnl_previsualizacion;
    }

    public JPanel getPnl_registroDatos() {
        return pnl_registroDatos;
    }

    public void setPnl_registroDatos(JPanel pnl_registroDatos) {
        this.pnl_registroDatos = pnl_registroDatos;
    }

    public JTable getTbl_previsualizacion() {
        return tbl_previsualizacion;
    }

    public void setTbl_previsualizacion(JTable tbl_previsualizacion) {
        this.tbl_previsualizacion = tbl_previsualizacion;
    }

    public JTextField getTxt_cantidad() {
        return txt_cantidad;
    }

    public void setTxt_cantidad(JTextField txt_cantidad) {
        this.txt_cantidad = txt_cantidad;
    }

    public JTextField getTxt_fechaHora() {
        return txt_fechaHora;
    }

    public void setTxt_fechaHora(JTextField txt_fechaHora) {
        this.txt_fechaHora = txt_fechaHora;
    }

    
}
