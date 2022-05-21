
import controller.ControllerBiblioteca;
import view.BibliotecaView;

/**
 *
 * @author JULIAN C
 */

public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BibliotecaView bibliotecaView = new BibliotecaView();
        ControllerBiblioteca controlador = new ControllerBiblioteca(bibliotecaView);

//        ArrayList<BibliotecaModel> obtenerBiblio = new ArrayList<>();
//        BibliotecaDAO biblioDAO = new BibliotecaDAO();
//        obtenerBiblio = biblioDAO.obtenerBibliotecas();
    }    
}
