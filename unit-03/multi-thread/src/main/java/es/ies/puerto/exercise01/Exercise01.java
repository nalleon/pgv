package es.ies.puerto.exercise01;

/**
 * Crea una simulación de batalla Pokémon en la que dos Pokémon (Pikachu y Charmander) luchan entre sí.
 * Cada hilo representa a un Pokémon que alterna ataques y recibe daño hasta que uno de ellos
 * se queda sin puntos de vida (HP). Deberás lanzar dos hilos y hacer que se detengan cuando uno de los Pokémon gane.
 */
public class Exercise01 {

    public Exercise01() {}

    public static void main(String[] args) {
        PokemonBattle battleCharmander = new PokemonBattle();
        battleCharmander.setName("Charmander");
        PokemonBattle battlePikachu = new PokemonBattle();
        battlePikachu.setName("Pikachu");
        Thread charmander = new Thread(battleCharmander);
        Thread pikachu = new Thread(battlePikachu);

        charmander.start();
        pikachu.start();

    }

}
