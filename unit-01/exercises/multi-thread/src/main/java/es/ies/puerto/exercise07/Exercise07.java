package es.ies.puerto.exercise07;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Crea una simulación donde Superman y Batman intentan salvar diferentes zonas de la ciudad de una amenaza.
 * Cada superhéroe es un hilo que representa el esfuerzo por salvar una serie de áreas. Si uno de los superhéroes
 * salva todas sus áreas primero, la amenaza será neutralizada y el otro superhéroe deberá detenerse.
 */
public class Exercise07 {
    public static void main(String[] args) {
        CitySavingByHeroes citySavingByHeroes1 = new CitySavingByHeroes();
        CitySavingByHeroes citySavingByHeroes2 = new CitySavingByHeroes();

        citySavingByHeroes1.setHeroName("Superman");
        citySavingByHeroes1.setLocationsCity(new HashSet<>(Arrays.asList("Zone1", "Zone2", "Zone3")));
        citySavingByHeroes2.setHeroName("Batman");
        citySavingByHeroes2.setLocationsCity(new HashSet<>(Arrays.asList("Zone1", "Zone2", "Zone3")));

        Thread thread1 = new Thread(citySavingByHeroes1);
        Thread thread2 = new Thread(citySavingByHeroes2);

        thread1.start();
        thread2.start();
    }
}
