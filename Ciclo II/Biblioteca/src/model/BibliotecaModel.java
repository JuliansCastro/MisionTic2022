/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 * @author JULIAN C
 * 
 * +---------------+----------+------+-----+---------+-------+
 * | Field         | Type     | Null | Key | Default | Extra |
 * +---------------+----------+------+-----+---------+-------+
 * | bib_id        | int      | NO   | PRI | NULL    |       |
 * | bib_tag       | char(40) | NO   | MUL | NULL    |       |
 * | bib_contenido | int      | NO   | MUL | NULL    |       |
 * | bib_fecha     | datetime | NO   |     | NULL    |       |
 * +---------------+----------+------+-----+---------+-------+
 */
public class BibliotecaModel {

    //Atributes
    private int     bibliotecaId;               //Llave de la Tabla biblioteca
    private String  bibliotecaTag;              //Usuario
    private int     bibliotecaContenidoId;      //ID de la tabla contenido
    private String  bibliotecaFecha;            //Fecha de registro
    private String  bibliotecaNombreCliente;    //Nombre del usuario
    private String  bibliotecaTituloContenido;  //Titulo de la tabla contenido
    //private String  bibliotecaFecha;

    // Constructors
    //(Id, Fecha, Tag, NombreCliente, ContenidoId, TituloContenido)
    public BibliotecaModel(int bibliotecaId,
                           String bibliotecaFecha,
                           String bibliotecaTag,
                           String bibliotecaNombreCliente,
                           int bibliotecaContenidoId,
                           String bibliotecaTituloContenido){
        
        this.bibliotecaId               = bibliotecaId;
        this.bibliotecaFecha            = bibliotecaFecha;
        this.bibliotecaTag              = bibliotecaTag;
        this.bibliotecaNombreCliente    = bibliotecaNombreCliente;
        this.bibliotecaContenidoId      = bibliotecaContenidoId;
        this.bibliotecaTituloContenido  = bibliotecaTituloContenido;
    }
  

    // Getters
    /**
     * 
     * @return bibliotecaId
     */
    public int getBibliotecaId() {
        return bibliotecaId;
    }

    public String getBibliotecaFecha() {
        return bibliotecaFecha;
    }

    public String getBibliotecaTag() {
        return bibliotecaTag;
    }

    public String getBibliotecaNombreCliente() {
        return bibliotecaNombreCliente;
    }

    public int getBibliotecaContenidoId() {
        return bibliotecaContenidoId;
    }

    public String getBibliotecaTituloContenido() {
        return bibliotecaTituloContenido;
    }

    /**
     * 
     * @return the array Blilioteca's data
     */
    public Object[] toArray(){
        // nombreColumnas = {"Fecha","Usuario","Nombre","Título"}
        Object[] data = {this.bibliotecaFecha,
                         this.bibliotecaTag,
                         this.bibliotecaNombreCliente,
                         this.bibliotecaTituloContenido};
        return data;
    }
    
    // Setters

    public void setBibliotecaId(int bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }

    public void setBibliotecaFecha(String bibliotecaFecha) {
        this.bibliotecaFecha = bibliotecaFecha;
    }

    public void setBibliotecaTag(String bibliotecaTag) {
        this.bibliotecaTag = bibliotecaTag;
    }

    public void setBibliotecaContenidoId(int bibliotecaContenidoId) {
        this.bibliotecaContenidoId = bibliotecaContenidoId;
    }
    
}
