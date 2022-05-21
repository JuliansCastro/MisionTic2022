package reto2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Misión TIC 2022
 * @author JULIAN C
 */

public class Club {
    //Variable global
    protected static ArrayList<Jugador> jugadores = new ArrayList<>();
    
    //Métodos    
    public static void main(String[] args) {
        procesarOpciones();
        /* PRUEBA
        1;Regular;Camilo;Salazar;Arquero;25;234
        1;Cedido;Sebastian;Gonzales;Delantero;30;Inter
        2
        3
        */
    }
    
    public static void Club(){
        System.out.println("Jugadores del club GRUPO80");
    }
    
    public static void agregarJugadores(String[] jugador){
        if(jugador.length > 1){
            String tipoJugador = jugador[1];
            String nm = jugador[2];
            String ap = jugador[3];
            String position = jugador[4];
            int edad = Integer.parseInt(jugador[5]);  

            if("Regular".equals(tipoJugador)){
                int minutes = Integer.parseInt(jugador[6]);
                Regular nuevoJugadorReg = new Regular(nm, ap, edad, position, minutes);        
                jugadores.add(nuevoJugadorReg);
                //System.out.println("Se agregó jugador regular: " + nm);
            }
            else if("Cedido".equals(tipoJugador)){
                String club = jugador[6];
                Cedido nuevoJugadorCed = new Cedido(nm, ap, edad, position, club);        
                jugadores.add(nuevoJugadorCed);
                //System.out.println("Se agregó jugador cedido: " + nm);
            }
        }
    }
    
    public static void listarJugadores(){
        Club();        
        for(Jugador j: jugadores){
            System.out.println(j.toString());
        }
    }
    
    public static void procesarOpciones(){
        Scanner sc = new Scanner(System.in);
        boolean continueProgram = true;
        int option;
        String command;
        String[] data;
        
        while(continueProgram){
            command = sc.nextLine(); //.replace(" ","");
            data = command.split(";");
            option = Integer.parseInt(data[0]);
            
            switch(option){
                case 1:
                    agregarJugadores(data);
                    break;
                case 2:
                    listarJugadores();
                    break;
                case 3:
                    continueProgram = false;
                    break;
                default:
                    System.out.println("Ingrese una opción válida.");
                    break;
            }
        }       
    }
}
