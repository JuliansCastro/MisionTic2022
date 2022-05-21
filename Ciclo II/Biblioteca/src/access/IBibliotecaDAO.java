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
    //CRUD
    //Añadir un registro en la biblioteca - C
    public void agregarBiblioteca(BibliotecaModel biblioteca);
    //Obtener los registros de la biblioteca - R
    public ArrayList <BibliotecaModel> obtenerBibliotecas();
    //Actualizar un registro de la biblioteca - U
    public void actualizarBiblioteca(int bibliotecaId);
    // Eliminar un regitro en la biblioteca - D
    public void eliminarBiblioteca(BibliotecaModel biblioteca);
    
}
