package es.ies.puerto.exercise04;

/**
 * Simula un partido de Quidditch, donde dos cazadores compiten para anotar más goles.
 * Los cazadores son hilos que anotan puntos aleatoriamente. Adicionalmente, crea un
 * tercer hilo que representa al buscador, que trata de atrapar la Snitch dorada.
 * El partido termina cuando uno de los equipos atrapa la Snitch
 */
public class Exercise04 {
    public static void main(String[] args) {
        QuidditchMatch match1 = new QuidditchMatch();
        QuidditchMatch match2 = new QuidditchMatch();
        QuidditchMatch match3 = new QuidditchMatch();

        match1.setName("Hunter 1");
        match1.setFinder(false);
        match2.setName("Hunter 2");
        match2.setFinder(false);
        match3.setName("Finder");
        match3.setFinder(false);


        Thread hunter1 = new Thread(match1);
        Thread hunter2 = new Thread(match2);
        Thread finder = new Thread(match3);

        hunter1.start();
        hunter2.start();
        finder.start();
    }
}
