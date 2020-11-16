
import java.io.*;
import java.net.*;
import java.util.logging.*;
public class ServidorHilo extends Thread {
	private Socket socket;
	private DataOutputStream dos;
	private DataInputStream dis;
	private int idSessio;
	public ServidorHilo(Socket socket, int id) {
		this.socket = socket;
		this.idSessio = id; 
		try { dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
		} catch (IOException ex) {
			Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex); 
			}
		}
	public void desconnectar() 
	{
		try { socket.close();
		} catch (IOException ex) {
			Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	@Override 
	public void run() { 
		String mensaje = "";
		String respuesta;
		
		try { 
			mensaje = dis.readUTF();
		if(mensaje.equalsIgnoreCase("pensando")){
			respuesta="confirmado";
			dos.writeUTF(respuesta);
		}
		
		if(mensaje.equalsIgnoreCase("ambre")){
			int num=0;
			if((idSessio+1)==5){
				idSessio--;
			}
			if((idSessio-1)==-1){
				idSessio++;
			}
			if(comiendo[idSessio+1]=false){
				num++;
			}
			if(comiendo[idSessio-1]=false){
			num++;
			}
			if(num==2){
				comiendo[idSessio+1]=true;
				comiendo[idSessio-1]=true;
			respuesta="come";
			dos.writeUTF(respuesta);
			}else{
				respuesta="espera";
				dos.writeUTF(respuesta);
			}
				
		}
		if(mensaje.equalsIgnoreCase("suelta")){
			comiendo[idSessio+1]=false;
			comiendo[idSessio-1]=false;
		}
			
			
		} catch (IOException ex) { 
			Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
			}
		
		
		
		}
	
	}


