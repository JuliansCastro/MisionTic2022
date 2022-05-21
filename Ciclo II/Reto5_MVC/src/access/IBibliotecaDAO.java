/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.ArrayList;
import model.BibliotecaModel;

/**
 *
 * @author daniel davila
 */
public interface IBibliotecaDAO {
    //Añadir un registro en la biblioteca
    public void agregarBiblioteca(BibliotecaModel biblioteca);
    
    // Eliminar un regitro en la biblioteca
    public void eliminarBiblioteca(int bibliotecaId);
    public void actualizarBiblioteca(BibliotecaModel biblioteca);
    
    //Obtener todos los registros de la biblioteca
    public ArrayList <BibliotecaModel> obtenerBibliotecas();
    public ArrayList <BibliotecaModel> obtenerBibliotecasUsuario(String usuario);
    public ArrayList <BibliotecaModel> obtenerBibliotecasTitulo(String titulo);
    public ArrayList <BibliotecaModel> obtenerBibliotecasFecha(String fecha);
    
    public ArrayList <String> obtenerFechas();    
}
