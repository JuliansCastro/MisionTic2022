/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author daniel davila
 */
public class DatosConexionModel {

    private String host;
    private String port;
    private String username;
    private String password;
    private String nameDB;

    public DatosConexionModel(String host, String port, String username, String password, String nameDB) {
        this.host = host;
        this.port = port;
        this.username = username;
        this.password = password;
        this.nameDB = nameDB;
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNameDB() {
        return nameDB;
    }

}
