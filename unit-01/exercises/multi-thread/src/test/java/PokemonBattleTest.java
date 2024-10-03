import es.ies.puerto.PokemonBattle;
import org.junit.jupiter.api.BeforeEach;
import utilities.TestUtilities;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class PokemonBattleTest extends TestUtilities {

        PokemonBattle battleCharmander;
        PokemonBattle battlePikachu;

    @BeforeEach
        public void beforeEach(){
            battleCharmander = new PokemonBattle();
            battlePikachu = new PokemonBattle();
            battleCharmander.setName("Charmander");
            battlePikachu.setName("Pikachu");
        }

        @Test
        public void pokemonBattleTest() throws InterruptedException {
            ByteArrayOutputStream outContent = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outContent));


            Thread charmander = new Thread(battleCharmander);
            Thread pikachu = new Thread(battlePikachu);


            charmander.start();
            pikachu.start();

            charmander.join();
            pikachu.join();

            String output = outContent.toString();
            assertTrue(output.contains(battlePikachu.getName() +" has been defeated") ||
                    output.contains(battleCharmander.getName() +" has been defeated"));
        }

}
