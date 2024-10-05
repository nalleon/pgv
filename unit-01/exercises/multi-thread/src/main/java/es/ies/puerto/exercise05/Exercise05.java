package es.ies.puerto.exercise05;

/**
 * Crea una simulación donde dos exploradores Jedi, representados por hilos, viajan por el
 * espacio buscando pistas sobre el Lado Oscuro. Cada hilo busca en diferentes planetas, y el
 * primer explorador que encuentre una pista debe detener al otro. Implementa tiempos de
 * búsqueda aleatorios para cada Jedi
 */
public class Exercise05 {
    public static void main(String[] args) {
        JediTravel jediTravel1 = new JediTravel();
        JediTravel jediTravel2 = new JediTravel();

        jediTravel1.setName("Obi Wan Kenobi");
        jediTravel2.setName("Anakin");

        Thread obiwan = new Thread(jediTravel1);
        Thread anakin = new Thread(jediTravel2);

        obiwan.start();
        anakin.start();
    }
}
