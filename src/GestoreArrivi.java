// GestoreArrivi.java
/**
 * Classe che implementa il thread per il totem touch screen che aggiunge
 * i clienti alla lista di attesa e genera il numero di attesa.
 * rappresenta il produttore
 */
public class GestoreArrivi implements Runnable {

    private ListaClienti listaClienti;
    private final int attesaArrivi = 2000;

    public GestoreArrivi(ListaClienti listaClienti) {
        this.listaClienti = listaClienti;
    }

    public void run() {
        try {
            while (!Thread.interrupted()) {
                Thread.sleep(attesaArrivi);
                Integer clienteArrivato = listaClienti.addCliente();
                if (clienteArrivato == null) {
                    break;
                }
                //System.out.println("Arrivo Cliente Numero \t " + clienteArrivato);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrotto durante lo sleep");
        } finally {
            System.out.println("Posta Chiusa");
        }
    }
}

