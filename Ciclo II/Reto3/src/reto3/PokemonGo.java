package reto3;

import java.util.ArrayList;

/**
 * Misión MinTIC 2022
 * @author JULIAN C
 */
public class PokemonGo {

    public static void main(String[] args) {}

    public static ArrayList<String> obtenerTodos(ArrayList<String> lista) {
        ArrayList<String> salida = new ArrayList<>();
        for(String elemento : lista) {
            if (salida.contains(elemento) == false) {
                salida.add(elemento);
            }
        }
        return salida;
    }

    public static ArrayList<Integer> obtenerCoincidencia(ArrayList<Integer> posLista,
            ArrayList<String> pokemonLista,
            String pokemonBuscado) {
        ArrayList<Integer> resultado = new ArrayList<>();
        for (int posicion : posLista) {
            if (posicion < pokemonLista.size()) {
                if (pokemonLista.get(posicion).equals(pokemonBuscado)) {
                    resultado.add(posicion);
                }
            } else {
                break;
            }
        }
        return resultado;
    }

    public static ArrayList<String> obtenerPokemonDiferentes(ArrayList<String> pokemonUsuario1, ArrayList<String> pokemonUsuario2) {
        ArrayList<String> salida = new ArrayList<>();
        for(String pokemon : pokemonUsuario1) {
            if (pokemonUsuario2.contains(pokemon) == false) {
                salida.add(pokemon);
            }
        }
        return salida;
    }

    public static Integer obtenerNumeroIntercambios(ArrayList<String> pokemonUsuario1,
            ArrayList<String> pokemonUsuario2) {
        if (pokemonUsuario2.size() <= pokemonUsuario1.size()) {
            return obtenerPokemonDiferentes(pokemonUsuario2, pokemonUsuario1).size();
        } else {
            return obtenerPokemonDiferentes(pokemonUsuario1, pokemonUsuario2).size();
        }
    }

}
