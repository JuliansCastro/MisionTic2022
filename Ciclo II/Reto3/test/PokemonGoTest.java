
import java.util.ArrayList;
import java.util.Arrays;
//import ju
import reto3.PokemonGo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author JULIAN C
 */
public class PokemonGoTest {
    @Test
    public void testObtenerTodos() {
        System.out.println("Obtener todos:");
        ArrayList<String> entrada = new ArrayList<>(Arrays.asList("Pikachu", "Meowth", "Eevee", "Bulbasaur", "Pikachu", "Eevee"));

        //PokemonGo instance = new PokemonGo();
        ArrayList<String> expResult = new ArrayList<>(Arrays.asList("Pikachu", "Meowth", "Eevee", "Bulbasaur"));
        ArrayList<String> result = PokemonGo.obtenerTodos(entrada);
        assertEquals("'Obtener todos' no funciona bien.", expResult, result, 0.0);
    }
    @Test
    public void testObtenerCoincidencia() {
        System.out.println("Obtener coincidencia:");
        ArrayList<Integer> posList = new ArrayList<>(Arrays.asList(0, 2, 3, 5, 6));
        ArrayList<String> pokemonList = new ArrayList<>(Arrays.asList("Pikachu", "Pichu", "Raichu", "Bulbasaur", "Eevee", "Meowth", "Pikachu", "Pikachu"));
        String pokemonBusc = "Pikachu";

        //PokemonGo instance = new PokemonGo();
        ArrayList<Integer> expResult = new ArrayList<>(Arrays.asList(0, 6));
        ArrayList<Integer> result = PokemonGo.obtenerCoincidencia(posList, pokemonList, pokemonBusc);
        assertEquals("'Obtener coincidencia' no funciona bien.", expResult, result, 0.0);
    }

    @Test
    public void testObtenerPokemonDiferentes() {
        System.out.println("Obtener pokemon diferentes:");
        ArrayList<String> pokemonUser1 = new ArrayList<>(Arrays.asList("Pikachu", "Meowth", "Pichu"));
        ArrayList<String> pokemonUser2 = new ArrayList<>(Arrays.asList("Raichu", "Pikachu", "Squirtle"));

        //PokemonGo instance = new PokemonGo();
        ArrayList<String> expResult = new ArrayList<>(Arrays.asList("Meowth", "Pichu"));
        ArrayList<String> result = PokemonGo.obtenerPokemonDiferentes(pokemonUser1, pokemonUser2);
        assertEquals("'Obtener pokemon diferentes' no funciona bien.", expResult, result, 0.0);
    }

    @Test
    public void testObtenerNumeroIntercambios() {
        System.out.println("Obtener número de intercambios:");
        ArrayList<String> pokemonUser1 = new ArrayList<>(Arrays.asList("Pikachu", "Bulbasaur", "Charmander", "Squirtle"));
        ArrayList<String> pokemonUser2 = new ArrayList<>(Arrays.asList("Pikachu", "Pichu", "Raichu"));

        //PokemonGo instance = new PokemonGo();
        Integer expResult = 2;
        Integer result = PokemonGo.obtenerNumeroIntercambios(pokemonUser1, pokemonUser2);
        assertEquals("'Obtener número de intercambios' no funciona bien.", expResult, result, 0.0);
    }
}
