/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.util.ArrayList;
import model.ContenidoModel;
/**
 *
 * @author daniel davila
 */
public interface IContenidoDAO {
        /**
     * SELECT *
     * @return Devuelve lista de todos los clientes
     */
    public ArrayList<ContenidoModel>   obtenerTodosContenidos();
    public ArrayList<String>           obtenerTitulos();
}
