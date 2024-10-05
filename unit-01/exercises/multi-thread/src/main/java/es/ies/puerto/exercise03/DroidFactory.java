package es.ies.puerto.exercise03;

import java.util.ArrayList;
import java.util.List;

/**
 * Simula una fábrica de droides en la que se están ensamblando droides de batalla.
 * Un hilo se encarga de ensamblar los droides, mientras que otro hilo se encarga de
 * activarlos. Asegúrate de que los droides no se activen antes de ser
 * completamente ensamblados, usando mecanismos de sincronización entre hilos.
 */
public class DroidFactory implements Runnable {

    private String name;
    private static List<Droid> droidList;

    public DroidFactory() {
       droidList = new ArrayList<>();
       droidList.add(new Droid("droid1"));
       droidList.add(new Droid("droid2"));
       droidList.add(new Droid("droid3"));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public synchronized void run() {
        int auxCounter = 0;
        while (auxCounter < droidList.size()) {
            switch (getName()) {
                case "assembler":
                    droidList.get(auxCounter).setAssembly(true);
                    System.out.println("Droid: " + droidList.get(auxCounter).getName() + " has been assembled");
                    break;
                case "activator":
                    if(droidList.get(auxCounter).isAssembly()) {
                        System.out.println("Droid: " + droidList.get(auxCounter).getName() + " has been activated");
                        droidList.get(auxCounter).setActivate(true);
                    }
                    break;
                default:
                    System.out.println("ERROR: Factory is in shambles without assemblers and activator");
            }
            auxCounter++;

            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
