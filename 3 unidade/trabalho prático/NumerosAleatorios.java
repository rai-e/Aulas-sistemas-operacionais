import java.util.Random;

public class NumerosAleatorios {
	public static void main(String[] args) {
		Random random = new Random();
		
		System.out.println(random.nextInt(4));
		System.out.println(random.nextInt(4));
		System.out.println(random.nextInt(4));
		System.out.println(random.nextInt(4));
	}
}
