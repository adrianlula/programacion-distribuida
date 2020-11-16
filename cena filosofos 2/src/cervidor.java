
import java.io.*;
import java.net.*;
import java.util.logging.*;
public class cervidor {
	public static void main(String args[]) throws IOException {
		ServerSocket ss;
		System.out.print("Inicializando servidor... "); 
		try {
			ss = new ServerSocket(6789);
			System.out.println("\t[OK]");
			int idSession = 0;
			while (true) { 
				Socket socket;
				socket = ss.accept();
				System.out.println("Nueva conexión entrante: "+socket);
				((ServidorHilo) new ServidorHilo(socket, idSession)).start(); 
				((ServidorHilo) new ServidorHilo(socket, idSession)).start(); 
				((ServidorHilo) new ServidorHilo(socket, idSession)).start(); 
				((ServidorHilo) new ServidorHilo(socket, idSession)).start(); 
				((ServidorHilo) new ServidorHilo(socket, idSession)).start(); 
				idSession++; 
				}
			} catch (IOException ex) {
				Logger.getLogger(cervidor.class.getName()).log(Level.SEVERE, null, ex); 
				}
		}
	}





