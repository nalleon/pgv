package es.ies.puerto.exercise09;

public class Exercise09 {
    public static void main(String[] args) {
        MillenniumFalconSimulator hanSolo = new MillenniumFalconSimulator();
        MillenniumFalconSimulator chewbacca = new MillenniumFalconSimulator();

        hanSolo.setName("Han Solo");
        chewbacca.setName("Chewbacca");

        Thread speedControl = new Thread(hanSolo);
        Thread shieldControl = new Thread(chewbacca);

        speedControl.start();
        shieldControl.start();

        try {
            speedControl.join();
            shieldControl.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
