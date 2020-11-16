import java.io.*; 
import java.net.Socket;
import java.util.Random;
import java.util.logging.*; 
public class filosofo extends Thread {
	protected Socket sk;
	protected DataOutputStream dos;
	protected DataInputStream dis;
	private int id;
	protected boolean comiendo=false;
	
	public boolean getcomiendo() {
        return comiendo;
    }
	public void setcomiendo(boolean com) {
       comiendo=com;
    }
	    
	
	@Override
	public void run() { 
		try { sk = new Socket("localhost", 6789);
		
		String mensaje;
		while(true){
			dos = new DataOutputStream(sk.getOutputStream()); 
			dis = new DataInputStream(sk.getInputStream());
		Random tiempoAleatorio = new Random();	
		System.out.println(id + "pensando");
		mensaje="pensando";
		dos.writeUTF(mensaje); 
		String respuesta=""; 
		respuesta = dis.readUTF(); 
		System.out.println(id + " el servidor responde: " + respuesta);
		sleep(tiempoAleatorio.nextInt(2000));
		mensaje="ambre";
		dos.writeUTF(mensaje); 
		respuesta = dis.readUTF(); 
		System.out.println(id + " el servidor responde: " + respuesta);
		if(respuesta.equals("come")){
			tiempoAleatorio = new Random();
			System.out.println(id + " el servidor responde: " + respuesta);
			sleep(tiempoAleatorio.nextInt(500));
			mensaje="suelta";
			dos.writeUTF(mensaje); 
			respuesta = dis.readUTF(); 
			System.out.println(id + " el servidor responde: " + respuesta);
			
		}
	
			 tiempoAleatorio = new Random();
			int i= tiempoAleatorio.nextInt(10000);
			while(i != 0 && respuesta.equals("espera")){
				i--;
				dos.writeUTF(mensaje); 
				respuesta = dis.readUTF(); 
				if(respuesta.equals("come")){
					tiempoAleatorio = new Random();
					System.out.println(id + " el servidor responde: " + respuesta);
					sleep(tiempoAleatorio.nextInt(500));
					mensaje="suelta";
					dos.writeUTF(mensaje); 
					respuesta = dis.readUTF(); 
					System.out.println(id + " el servidor responde: " + respuesta);
				}
			}
		}
		}
	
		 catch (IOException ex) {
 Logger.getLogger(filosofo.class.getName()).log(Level.SEVERE, null, ex);
 } catch (InterruptedException e) {
			
			e.printStackTrace();
		} 
		}
	}



