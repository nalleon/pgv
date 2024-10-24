package es.ies.puerto.exercise02;

/**
 * Imagina que Harry, Hermione y Ron están buscando Horrocruxes. Cada personaje está
 * representado por un hilo que busca en una ubicación diferente del mundo.
 * El primer hilo que encuentra un Horrocrux debe detener a los demás y terminar la
 * búsqueda. Elige el tiempo de búsqueda de manera aleatoria para cada hilo.
 */
public class Exercise02 {
    public static void main(String[] args) {
        HuntHorrocruxes huntHarry = new HuntHorrocruxes();
        huntHarry.setName("Harry");
        huntHarry.setLocation("Location1");

        HuntHorrocruxes huntHermione = new HuntHorrocruxes();
        huntHermione.setName("Hermione");
        huntHermione.setLocation("Location2");

        HuntHorrocruxes huntRon = new HuntHorrocruxes();
        huntRon.setName("Ron");
        huntRon.setLocation("Location3");

        Thread harry = new Thread(huntHarry);
        Thread hermione = new Thread(huntHermione);
        Thread ron = new Thread(huntRon);

        harry.start();
        hermione.start();
        ron.start();
    }
}
