package es.ies.puerto.exercise01;

import es.ies.puerto.exercise01.PokemonBattle;
import org.junit.jupiter.api.BeforeEach;
import utilities.TestUtilities;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PokemonBattleTest extends TestUtilities {

    PokemonBattle instanceForThread1;
    PokemonBattle instanceForThread2;

    @BeforeEach
        public void beforeEach(){
            instanceForThread1 = new PokemonBattle();
            instanceForThread2 = new PokemonBattle();
            instanceForThread1.setName("Charmander");
            instanceForThread2.setName("Pikachu");
        }

        @Test
        public void pokemonBattleTest() throws InterruptedException {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));


            Thread thread1 = new Thread(instanceForThread1);
            Thread thread2 = new Thread(instanceForThread2);


            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            String output = outContent.toString();
            assertTrue(output.contains(instanceForThread2.getName() +" has been defeated") ||
                    output.contains(instanceForThread1.getName() +" has been defeated"), MESSAGE_ERROR);
        }

}
