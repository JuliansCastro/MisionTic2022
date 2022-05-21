package controller;

import access.BibliotecaDAO;
import java.util.ArrayList;
import model.BibliotecaModel;

/**
 *
 * @author JULIAN C
 */
public class InitialData {
    ArrayList<BibliotecaModel>  bibliotecas = null;
    
    public InitialData(){
        BibliotecaDAO bibliotecas = new BibliotecaDAO();
        this.bibliotecas = bibliotecas.obtenerBibliotecas();
//        this.bibliotecas.add(0, new BibliotecaModel(-1, "Fecha", "Usuario", "Nombre", -1, "Titulo"));
    }
}
