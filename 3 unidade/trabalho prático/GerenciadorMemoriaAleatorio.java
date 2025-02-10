package aleatorio;

import java.util.Random;
import java.util.Scanner;

public class GerenciadorMemoriaAleatorio {

	public static void main(String[] args) {
		/* declarando 4 páginas na ram */
		Page ram[] = new Page[4];
		/* declarando 6 páginas no hd */
		Page hd[] = new Page[6];
		/* Considere que o sistema está no seguinte estado
		 *	A é composto de 3 blocos/páginas
		 *	B é composto de 4 blocos/páginas
		 *  C é composto de 3 blocos/páginas
		 * 		  [     0      ,      1      ,     2       ,     3       ,      4      ,      5      ]
		 *	RAM   [PARTE 3 DE A, PARTE 1 DE C, PARTE 2 DE C, PARTE 3 DE C]	
		 *  DISCO [PARTE 1 DE A, PARTE 2 DE A, PARTE 1 DE B, PARTE 2 DE B, PARTE 3 DE B, PARTE 4 DE B]
		 * 	
		 * */
		 
		/* preenchendo a ram e disco com suas páginas cada um */
		/* CRIANDO PÁGINAS DE A*/
		hd[0] = new Page("PARTE 1 DE A");
		hd[1] = new Page("PARTE 2 DE A");
		ram[0] = new Page("PARTE 3 DE A");
		/* CRIANDO PÁGINAS DE B*/
		hd[2] = new Page("PARTE 1 DE B");
		hd[3] = new Page("PARTE 2 DE B");
		hd[4] = new Page("PARTE 3 DE B");
		hd[5] = new Page("PARTE 4 DE B");
		/* CRIANDO PÁGINAS DE C*/
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
			int indexPageHD = -1;//guarda o índice do hd que será feito page in
			switch (opcao) {
			case 1:

				System.out.print("Qual índice da página do disco será usada no page in? 0 a 4");
				indexPageHD = scan.nextInt();
				System.out.println("Selecionando página da RAM para ser substituída...");
				Random random = new Random();
				int indexPageSorteada = random.nextInt(5);//índice do quadro 
				System.out.println("O índice da página física sorteada para sair da RAM foi: " + indexPageSorteada);
				/* RECOMENDADO TRATAR A EXCEÇÃO DE ACESSAR POSIÇÃO FORA DO TAMANHO DO VETOR */

				/* 
				 * 
				 * SUA IMPLEMENTAÇÃO DE PAGE IN
				 * 
				 * */
				
				break;
			case 2:
				System.out.print("Qual índice da página da RAM será referenciado? 0 a 4");
				indexPageHD = scan.nextInt();
				System.out.println("Referenciando página da RAM para ser substituída...");
				/* 
				 * SUA IMPLEMENTAÇÃO DE REFERÊNCIA À PÁGINA
				 * 
				 */
				break;
			case 3:
				
				header(" MEMÓRIA RAM ATUAL ");

				for (int i = 0; i < ram.length; ++i) {
					System.out.print("| ");
					System.out.printf("%-15s", ram[i]);
					System.out.print(" ");
				}
				footer();
				header(" MEMÓRIA HDD ATUAL ");

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
			System.out.printf("%-15s", "Índice " + i);
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
