package timestamp;

public class EpochExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("milisegundos desde 01/jan/1970 "+System.currentTimeMillis());
		
		long tempoReferenciapaginaY = System.currentTimeMillis();
		System.out.println("Página Y referenciado no epoch = "+tempoReferenciapaginaY+"ms");
		long tempoReferenciapaginaX = System.currentTimeMillis();
		System.out.println("Página X referenciado no epoch = "+tempoReferenciapaginaX+"ms");
		System.out.println("Diferença de tempo = "+(tempoReferenciapaginaY - tempoReferenciapaginaX)+"ms");
		if(tempoReferenciapaginaX > tempoReferenciapaginaY) {
			System.out.println("X é mais novo");
		}else {
			System.out.println("X é mais velho");
		}
		
	}

}
