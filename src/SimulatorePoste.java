// SimulatorePoste.java
/**
 * Classe main per simulare l'ufficio postale con 2 gestori arrivi
 */
public class SimulatorePoste {
    public static void main(String[] args) {
        ListaClienti listaClienti = new ListaClienti();

        // Due gestori arrivi
        Thread arriviThread1 = new Thread(new GestoreArrivi(listaClienti), "Totem1");
        Thread arriviThread2 = new Thread(new GestoreArrivi(listaClienti), "Totem2");

        // Due sportelli
        Thread sportelloThread1 = new Thread(new Sportello(listaClienti, "Marzia"));
        Thread sportelloThread2 = new Thread(new Sportello(listaClienti, "Cinzia"));

        // Avvio thread
        arriviThread1.start();
        arriviThread2.start();
        sportelloThread1.start();
        sportelloThread2.start();
    }
}
