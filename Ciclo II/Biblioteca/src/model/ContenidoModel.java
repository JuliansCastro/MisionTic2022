/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daniel davila
  * +----------------+-----------+------+-----+---------+-------+
 * | Field           | Type      | Null | Key | Default | Extra |
 * +-----------------+-----------+------+-----+---------+-------+
 * | con_id          | int       | NO   | PRI | NULL    |       |
 * | con_titulo      | char(50)  | NO   |     | NULL    |       |
 * | con_descripcion | char(255) | YES  |     | NULL    |       |
 * +-----------------+-----------+------+-----+---------+-------+			
 */
public class ContenidoModel {
    //atributes
    private int     contenidoId;
    private String  contenidoTitulo;
    private String  contenidoDescripcion;
    
    //Constructor
    public ContenidoModel(int contenidoId, String contenidoTitulo, String contenidoDescripcion) {
        this.contenidoId            = contenidoId;
        this.contenidoTitulo        = contenidoTitulo;
        this.contenidoDescripcion   = contenidoDescripcion;
    }

    public int getContenidoId(){
        return contenidoId;
    }
    
    public String getContenidoTitulo() {        
        return contenidoTitulo;
    }

    // Getters
    public String getContenidoDescripcion() {
        return contenidoDescripcion;
    }

    /**
     * 
     * @return the array Contenidos data
     */
    public Object[] toArray() {
        Object[] data = {this.contenidoId,this.contenidoTitulo,
            this.contenidoTitulo};
        return data;
    }
    // Setters
}
