import java.util.concurrent.Semaphore;
public class Main {
	 final static int numeroFilosofos = 5;
	 final static int[][] palillosFilosofo = {
		        {0, 4},
		        {1, 0}, 
		        {2, 1}, 
		        {3, 2}, 
		        {4, 3} 
		    };
	 final static Semaphore[] palillos_semaforo = new Semaphore[numeroFilosofos];
	 
	 
	 
	 
	 
	 
	public static void main(String[] args) {
		for (int i = 0; i < numeroFilosofos; i++) {
			palillos_semaforo[i] = new Semaphore(1);
		}
		for (int idFilosofo = 0; idFilosofo < numeroFilosofos; idFilosofo++) {
            new filosofo(idFilosofo, palillos_semaforo, palillosFilosofo).start();
        }
	}

}
