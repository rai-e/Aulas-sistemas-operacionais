package arquivos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializacao {

	public static void main(String[] args) {
		Planeta p = new Planeta(17.3, 2, "Saturno");
		try {
			FileOutputStream fos = new FileOutputStream(new File("planetas.data"));
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(p);
			oos.close();
			fos.close();
			
			FileInputStream fis = new FileInputStream(new File("planetas.data"));
			ObjectInputStream ois = new ObjectInputStream(fis);
			Planeta planeta = (Planeta)ois.readObject();
			System.out.println(planeta.nome+" - "+planeta.gravidade);
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
