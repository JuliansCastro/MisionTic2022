package access;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ClienteModel;

/**
 *
 * @author JULIAN C
 */
public class ClienteDAO implements IClienteDAO {
    //Atributes
    private final   Connection conn;
    private         ArrayList<ClienteModel> clientes;

    
    //Constructor
    public ClienteDAO(Connection conn){
        this.conn   = conn;
        clientes    = this.obtenerClientes();
    }
    
    //Methods
    @Override
    public final ArrayList<ClienteModel> obtenerClientes() {
        clientes = new ArrayList<>();
        try {
            if (conn != null) {
                //conn = controller.IngresoController.eventoBotonConectarDB(); //Abrir la conexion con DB
                //System.out.println(conn);
                //Query de consulta para el objeto bibloteca
                String sql = "SELECT cli_tag, cli_nombre\n" +
                             "FROM  cliente;";
                //Generar la consulta
                Statement statement = conn.createStatement();
                ResultSet result = statement.executeQuery(sql);

                //Crear los objetos de consulta y añadirlos a la lista bibliotecas
                while (result.next()) {
                    ClienteModel cliente = new ClienteModel(result.getString(1),
                                                            result.getString(2));
                    clientes.add(cliente);
                    //System.out.println(cliente.getClienteNombre());
                }
                //conn.close();
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex);
        }
        return clientes;
    }
    
    @Override
    public ArrayList<String> obtenerUsuarios(){
        ArrayList<String> nombres = new ArrayList<>();
        try {
            for(int i = 0 ; i < clientes.size(); i++){
                nombres.add(clientes.get(i).getClienteTag());
            }
            
        } catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
        return nombres;
    }

}
