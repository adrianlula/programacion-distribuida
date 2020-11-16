
import java.util.Scanner;

public class mesa {
	
	protected static int sillas;
	public int getsillas() {
        return sillas;
    }
	 public mesa (int sillas) {
		 this.sillas = sillas;   
	    } 
		 
		 
		 

	public static void main(String[] args) {
		Scanner escan = new Scanner(System.in);
		System.out.println("cuantas cillas necesita?");
		int deisponibles=escan.nextInt();
		System.out.println(deisponibles+"cillas desponibles");
	
		for(int i=0;i<deisponibles;i++){
			new filosofo().start();
			
		}	
	}

}
