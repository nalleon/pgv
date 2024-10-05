package es.ies.puerto.exercise10;

public class Exercise10 {
    public static void main(String[] args) {
        MagicBattle magicBattle1 = new MagicBattle();
        MagicBattle magicBattle2 = new MagicBattle();

        magicBattle1.setName("Gandalf");
        magicBattle2.setName("Saruman");

        Thread gandalf = new Thread(magicBattle1);
        Thread saruman = new Thread(magicBattle2);

        gandalf.start();
        saruman.start();
    }
}
