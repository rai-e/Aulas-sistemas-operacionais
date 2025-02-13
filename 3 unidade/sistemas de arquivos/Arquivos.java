package arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivos {

	public static void main(String[] args) {
		/*
		 * Planeta planetas [] = new Planeta[3]; planetas[0] = new Planeta(7.23, 3,
		 * "Marte"); planetas[1] = new Planeta(9.8, 1, "Terra"); planetas[2] = new
		 * Planeta(12.75, 16, "Saturno");
		 * 
		 * for (Planeta planeta : planetas) {
		 * System.out.println(planeta.nome+" - "+planeta.gravidade); }
		 */

		try {
			FileWriter fw = new FileWriter(new File("example.txt"));
			BufferedWriter bw = new BufferedWriter(fw);
			fw.write("hello arquivos\n");
			fw.write("segunda linha");
			bw.close();
			fw.close();

			FileReader fr = new FileReader(new File("example.txt"));
			BufferedReader br = new BufferedReader(fr);

			String linha;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}

			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			System.err.println("erro: " + e);
		} catch (IOException e) {
			System.err.println("erro: " + e);
		}

	}

}
