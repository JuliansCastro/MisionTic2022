package reto2;

/**
 * Misión TIC 2022
 * @author JULIAN C
 */
public class Cedido extends Jugador{
    protected String clubActual;
    
    public Cedido(String nombre, String  apellido, int edad, String  posicion, String clubActual){
        super(nombre, apellido, edad, posicion);
        this.clubActual = clubActual;
    }

    @Override
    public String toString(){
        return "\tNombre completo: " + this.nombre + " " + this.apellido + "\n" +
               "\tEdad: " + this.edad + " años\n" +
               "\tPosición: " + this.posicion + "\n" +
               "\tClub actual: " + this.clubActual;
    }
}
