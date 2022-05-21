package model;

/**
 *
 * @author JULIAN C
 *
 * +---------------+----------+------+-----+---------+-------+
 * | Field         | Type     | Null | Key | Default | Extra |
 * +---------------+----------+------+-----+---------+-------+
 * | cli_tag       | char(20) | NO   | PRI | NULL    |       |
 * | cli_nombre    | char(20) | NO   |     | NULL    |       |
 * | cli_email     | char(30) | NO   |     | NULL    |       |
 * | cli_celular   | bigint   | YES  |     | NULL    |       |
 * | cli_clave     | char(20) | YES  |     | NULL    |       |
 * | cli_fecha_nto | date     | NO   |     | NULL    |       |
 * +---------------+----------+------+-----+---------+-------+
 */
public class ClienteModel {

    // Attributes
    private String  clienteTag;
    private String  clienteNombre;
    private String  clienteEmail;
    private int     clienteCelular;
    private String  clienteClave;
    private String  clienteFechaNto;

    /**
     * Constructor para modelo del Cliente: Crea un cliente recibiendo como
     * parámetros datos básicos de esa persona
     *
     * @param clienteTag Etiqueta de usuario única
     * @param clienteNombre Nombre completo
     * @param clienteEmail Correo electrónico
     * @param clienteCelular Celular opcional
     * @param clienteClave Clave opcional
     * @param clienteFechaNto Fecha de nacimiento
     */
    public ClienteModel(String clienteTag, String clienteNombre, String clienteEmail, int clienteCelular, String clienteClave, String clienteFechaNto) {
        this.clienteTag         = clienteTag;
        this.clienteNombre      = clienteNombre;
        this.clienteEmail       = clienteEmail;
        this.clienteCelular     = clienteCelular;
        this.clienteClave       = clienteClave;
        this.clienteFechaNto    = clienteFechaNto;
    }

    // Getters
    public String getClienteTag() {
        return clienteTag;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public int getClienteCelular() {
        return clienteCelular;
    }

    public String getClienteClave() {
        return clienteClave;
    }

    public String getClienteFechaNto() {
        return clienteFechaNto;
    }

    
    /**
     * 
     * @return the array of ClienteModel´s data
     */
    public Object[] toArray(){
        Object[] data = {this.clienteTag, this.clienteNombre, this.clienteEmail,
                         this.clienteCelular, this.clienteClave,
                         this.clienteFechaNto};
        return data;
    }
    
//    Setters
}
