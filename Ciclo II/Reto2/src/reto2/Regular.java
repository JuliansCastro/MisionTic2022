package reto2;

/**
 * Misión TIC 2022
 * @author JULIAN C
 */
public class Regular extends Jugador{
    protected int minutosJugados;
    
    public Regular(String nombre, String  apellido, int edad, String  posicion, int minutosJugados){
        super(nombre, apellido, edad, posicion);
        this.minutosJugados = minutosJugados;
    }
    
   

    @Override
    public String toString(){
        return "\tNombre completo: " + this.nombre + " " + this.apellido + "\n" +
               "\tEdad: " + this.edad + " años\n" +
               "\tPosición: " + this.posicion + "\n" +
               "\tTiempo jugado: " + this.minutosJugados + " minutos";
    }
}
