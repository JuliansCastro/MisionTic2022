package access;

import java.util.ArrayList;
import model.ClienteModel;

/**
 *
 * @author JULIAN C
 */
public interface IClienteDAO {    
    /**
     * SELECT *
     * @return Devuelve lista de todos los clientes
     */
    ArrayList<ClienteModel> obtenerClientes();
    ArrayList<String>       obtenerUsuarios();
     
}
