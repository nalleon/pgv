package es.ies.puerto.model;

import es.ies.puerto.PokemonBattle;
import utilities.TestUtilities;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PokemonBattleTest extends TestUtilities {

        @Test
        public void pokemonBattleTest() throws InterruptedException {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));

            Thread charmander = new Thread(new PokemonBattle("Charmander"));
            Thread pikachu = new Thread(new PokemonBattle("Pikachu"));

            charmander.start();
            pikachu.start();

            charmander.join();
            pikachu.join();

            String output = outContent.toString();
            assertTrue(output.contains("Charmander has been defeated") ||
                    output.contains("Pikachu has been defeated"));
        }

}
