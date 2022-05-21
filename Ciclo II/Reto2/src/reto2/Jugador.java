package reto2;

/**
 * Misión TIC 2022
 * @author JULIAN C
 */
public class Jugador {
    protected String nombre;
    protected String apellido;
    protected int edad;
    protected String posicion;
    
    public Jugador(String nombre, String  apellido, int edad, String  posicion){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.posicion = posicion;
    }
    
    @Override
    public String toString(){
        return "\tNombre completo: " + this.nombre + " " + this.apellido + "\n" +
               "\tEdad: " + this.edad + " años\n" +
               "\tPosición: " + this.posicion;
    }    
}
