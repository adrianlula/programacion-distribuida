
import java.util.Random;
import java.util.concurrent.Semaphore;


public class filosofo extends Thread {
    private  int idFilosofo;
    private  Semaphore[] palillos_semaforo;
    private  int[][] palillosFilosofo;
    private  int palilloIzquierdo;
    private  int palilloDerecho;
    private final Random tiempoAleatorio = new Random();
    public filosofo(int idFilosofo, Semaphore[] palillos_semaforo, int[][] palillosFilosofo) {
        this.idFilosofo = idFilosofo;
        this.palillos_semaforo = palillos_semaforo;
        this.palillosFilosofo = palillosFilosofo;
        this.palilloIzquierdo = palillosFilosofo[idFilosofo][0];
        this.palilloDerecho = palillosFilosofo[idFilosofo][1];
    }
    protected void comer() {
        if (palillos_semaforo[palilloIzquierdo].tryAcquire()) {
            if (palillos_semaforo[palilloDerecho].tryAcquire()) {
                System.out.println("FILÓSOFO " + idFilosofo + " ESTÁ COMIENDO.");
                try {
                    sleep(tiempoAleatorio.nextInt(2000));
                } catch (InterruptedException ex) {
                    System.out.println("Error : " + ex.toString());
                }
                System.out.println("Filósofo " + idFilosofo + " ha terminado de comer.Libera los palillos " + palilloIzquierdo + " y " + palilloDerecho);
                palillos_semaforo[palilloDerecho].release();
            }
            palillos_semaforo[palilloIzquierdo].release();
        } else { 
            System.out.println("Filósofo " + idFilosofo + " está hambriento.");
        }
    }
    protected void pensar() {
        System.out.println("Filósofo " + idFilosofo + " está pensando.");
        try {
            filosofo.sleep(tiempoAleatorio.nextInt(3000));
        } catch (InterruptedException ex) {
            System.out.println("Error en el método pensar(): " + ex.toString());
        }
    }
    @Override
    public void run() {
        while (true) {
            pensar();
            comer();
        }
    }
}