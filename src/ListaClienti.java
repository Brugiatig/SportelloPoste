// ListaClienti.java
import java.util.ArrayList;

/**
 * Classe che rappresenta la risorsa condivisa fra i thread
 * @author frida
 */
public class ListaClienti {
    private ArrayList<Integer> listaNumeri;
    private int ultimoArrivo;
    private final int numeroMassimo = 10;

    public ListaClienti() {
        listaNumeri = new ArrayList<>();
        ultimoArrivo = 0;
    }

    /**
     * Metodo eseguito dai thread Sportello
     * Rimuove il primo cliente dalla lista (FIFO)
     */
    public synchronized Integer rimuoviCliente() throws InterruptedException {
        while (listaNumeri.isEmpty()) { // uso lista reale invece dei contatori
           // System.out.println("Non ci sono clienti in attesa");
            wait();
        }
        Integer cliente = listaNumeri.remove(0); // rimuove il primo cliente FIFO
        return cliente;
    }

    /**
     * Metodo eseguito da GestoreArrivi
     * Aggiunge un cliente alla lista
     */
    public synchronized Integer addCliente() {
        if (ultimoArrivo < numeroMassimo) {
            ultimoArrivo++;
            listaNumeri.add(ultimoArrivo);
            System.out.println("Arrivo Cliente Numero \t " + ultimoArrivo + " (gestore: " + Thread.currentThread().getName() + ")");
            notifyAll();
            return ultimoArrivo;
        }
        return null;
    }

}
