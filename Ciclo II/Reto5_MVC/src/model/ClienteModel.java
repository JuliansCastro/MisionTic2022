package model;

/**
 *
 * @author JULIAN C
 *
 * +---------------+----------+------+-----+---------+-------+ | Field | Type |
 * Null | Key | Default | Extra |
 * +---------------+----------+------+-----+---------+-------+ | cli_tag |
 * char(20) | NO | PRI | NULL | | | cli_nombre | char(20) | NO | | NULL | | |
 * cli_email | char(30) | NO | | NULL | | | cli_celular | bigint | YES | | NULL
 * | | | cli_clave | char(20) | YES | | NULL | | | cli_fecha_nto | date | NO | |
 * NULL | | +---------------+----------+------+-----+---------+-------+
 */
public class ClienteModel {

    // Attributes
    private String clienteTag;
    private String clienteNombre;

    /**
     * Constructor para modelo del Cliente: Crea un cliente recibiendo como
     * parámetros datos básicos de esa persona
     *
     * @param clienteTag Etiqueta de usuario única
     */
    public ClienteModel(String clienteTag, String clienteNombre) {
        this.clienteTag     = clienteTag;
        this.clienteNombre  = clienteNombre;
    }

    // Setters & Getters
    public String getClienteTag() {
        return clienteTag;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }



}
