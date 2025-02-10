package aleatorio;

import java.util.Random;
import java.util.Scanner;

public class GerenciadorMemoriaAleatorio {

	public static void main(String[] args) {
		/* declarando 4 p�ginas na ram */
		Page ram[] = new Page[4];
		/* declarando 6 p�ginas no hd */
		Page hd[] = new Page[6];
		/* Considere que o sistema est� no seguinte estado
		 *	A � composto de 3 blocos/p�ginas
		 *	B � composto de 4 blocos/p�ginas
		 *  C � composto de 3 blocos/p�ginas
		 * 		  [     0      ,      1      ,     2       ,     3       ,      4      ,      5      ]
		 *	RAM   [PARTE 3 DE A, PARTE 1 DE C, PARTE 2 DE C, PARTE 3 DE C]	
		 *  DISCO [PARTE 1 DE A, PARTE 2 DE A, PARTE 1 DE B, PARTE 2 DE B, PARTE 3 DE B, PARTE 4 DE B]
		 * 	
		 * */
		 
		/* preenchendo a ram e disco com suas p�ginas cada um */
		/* CRIANDO P�GINAS DE A*/
		hd[0] = new Page("PARTE 1 DE A");
		hd[1] = new Page("PARTE 2 DE A");
		ram[0] = new Page("PARTE 3 DE A");
		/* CRIANDO P�GINAS DE B*/
		hd[2] = new Page("PARTE 1 DE B");
		hd[3] = new Page("PARTE 2 DE B");
		hd[4] = new Page("PARTE 3 DE B");
		hd[5] = new Page("PARTE 4 DE B");
		/* CRIANDO P�GINAS DE C*/
		ram[1] = new Page("PARTE 1 DE C");
		ram[2] = new Page("PARTE 2 DE C");
		ram[3] = new Page("PARTE 3 DE C");

		int opcao = -1;

		Scanner scan = new Scanner(System.in);
		while (opcao != 0) {
			System.out.println("+----------------- MENU ------------------+");
			System.out.println("| 1 - REALIZAR PAGE IN ");
			System.out.println("| 2 - REFERENCIAR QUADRO DA RAM ");
			System.out.println("| 3 - VISUALIZAR RAM E DISCO ATUALMENTE ");
			System.out.println("| 0 - SAIR ");
			System.out.println("+-----------------------------------------+");
			System.out.print("O que deseja fazer? ");
			opcao = scan.nextInt();
			int indexPageHD = -1;//guarda o �ndice do hd que ser� feito page in
			switch (opcao) {
			case 1:

				System.out.print("Qual �ndice da p�gina do disco ser� usada no page in? 0 a 4");
				indexPageHD = scan.nextInt();
				System.out.println("Selecionando p�gina da RAM para ser substitu�da...");
				Random random = new Random();
				int indexPageSorteada = random.nextInt(5);//�ndice do quadro 
				System.out.println("O �ndice da p�gina f�sica sorteada para sair da RAM foi: " + indexPageSorteada);
				/* RECOMENDADO TRATAR A EXCE��O DE ACESSAR POSI��O FORA DO TAMANHO DO VETOR */

				/* 
				 * 
				 * SUA IMPLEMENTA��O DE PAGE IN
				 * 
				 * */
				
				break;
			case 2:
				System.out.print("Qual �ndice da p�gina da RAM ser� referenciado? 0 a 4");
				indexPageHD = scan.nextInt();
				System.out.println("Referenciando p�gina da RAM para ser substitu�da...");
				/* 
				 * SUA IMPLEMENTA��O DE REFER�NCIA � P�GINA
				 * 
				 */
				break;
			case 3:
				
				header(" MEM�RIA RAM ATUAL ");

				for (int i = 0; i < ram.length; ++i) {
					System.out.print("| ");
					System.out.printf("%-15s", ram[i]);
					System.out.print(" ");
				}
				footer();
				header(" MEM�RIA HDD ATUAL ");

				for (int i = 0; i < hd.length; ++i) {
					System.out.print("| ");
					System.out.printf("%-15s", hd[i]);
					System.out.print(" ");
				}
				footer();
				break;
			}
		}
	}

	public static void header(String titulo) {
		// HEADER
		System.out.print('+');
		System.out.print("-".repeat(35));
		System.out.print(titulo);
		System.out.print("-".repeat(35));
		System.out.print("+\n");
		// -----------------------------

		for (int i = 0; i < 5; ++i) {
			System.out.print("| ");
			System.out.printf("%-15s", "�ndice " + i);
			System.out.print(" ");
		}
		System.out.println("|");

		System.out.print('+');
		System.out.print("-".repeat(89));
		System.out.println('+');

	}

	public static void footer() {
		System.out.println("|");
		System.out.print('+');
		System.out.print("-".repeat(89));
		System.out.println('+');
	}
}
