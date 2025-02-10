package aleatorio;
import java.util.Scanner;

public class GerenciadorMemoriaAleatorio {

	public static void main(String[] args) {
		/* declarando 4 páginas na ram */
		Page ram[] = new Page[4];//linkedlist
		/* declarando 6 páginas no hd */
		Page hd[] = new Page[6];
		/* Considere que o sistema está no seguinte estado
		 *	- A é composto de 3 blocos/páginas
		 *		PARTE 1 DE A NA RAM
		 *		PARTE 2 DE A NO DISCO
		 *		PARTE 3 DE A NO DISCO
		 *	- B é composto de 4 blocos/páginas
		 *		PARTE 1 DE B NO DISCO
		 *		PARTE 2 DE B NO DISCO
		 *		PARTE 3 DE B NO DISCO
		 *		PARTE 4 DE B NO DISCO
		 *  - C é composto de 3 blocos/páginas
		 *  	PARTE 1 DE C NA RAM
		 *  	PARTE 2 DE C NA RAM
		 *  	PARTE 3 DE C NA RAM
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
		//ram[1].tempo = System.currentTimeMillis();
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
			int indexPageRAM = -1;//guarda o índice da RAM que será referenciada
			switch (opcao) {
			case 1:
				System.out.print("Qual índice do disco será usada no page in? 0 a "+(hd.length-1)+" ");
				indexPageHD = scan.nextInt();//Selecione qual índice do disco tem uma página que irá para a RAM
				System.out.println("A página atualmente associada a esse índice do disco é: "+hd[indexPageHD]);//exiba a página que está no índice
				/* RECOMENDADO TRATAR A EXCEÇÃO DE ACESSAR POSIÇÃO FORA DO TAMANHO DO VETOR */
				System.out.println("O algoritmo está selecionando página da RAM para ser substituída...");
				/* 
				 * 
				 * SUA IMPLEMENTAÇÃO DE PAGE IN
				 * O algoritmo irá escolher qual índice será selecionado para sair da RAM
				 * 
				 * */
				int indexSelecionadoAlgoritmo = -1;
				/* substituir pelo índice calculado pelo algoritmo */
				System.out.println("O índice escolhido pelo algoritmo para sair da RAM foi: "+indexSelecionadoAlgoritmo);//exibir valor de ram[indexSelecionadoAlgritmo]
				System.out.println("A página atualmente associada a esse índice é: ram[indexSelecionadoAlgoritmo]");//exiba a página que está no índice escolhido pelo algoritmo
				break;
			case 2:
				System.out.print("Qual índice da RAM será referenciado? 0 a "+(ram.length - 1)+" ");
				indexPageRAM = scan.nextInt();
				System.out.println("A página atualmente associada a esse índice é: "+ram[indexPageRAM]);//exiba a página que está no índice
				System.out.println("Referenciando página da RAM...");
				/* 
				 * SUA IMPLEMENTAÇÃO DE REFERÊNCIA À PÁGINA
				 * Alguns algoritmos fazem algum processamento nessa etapa
				 */
				break;
			case 3:
				
				header(" MEMÓRIA RAM ATUAL ",ram.length);

				for (int i = 0; i < ram.length; ++i) {
					System.out.print("| ");
					System.out.printf("%-15s", ram[i]);
					System.out.print(" ");
				}
				footer(ram.length);
				header(" MEMÓRIA HDD ATUAL ",hd.length);

				for (int i = 0; i < hd.length; ++i) {
					System.out.print("| ");
					System.out.printf("%-15s", hd[i]);
					System.out.print(" ");
				}
				footer(hd.length);
				break;
			}
		}
	}

	public static void header(String titulo, int nElements) {
		// HEADER
		System.out.println(titulo);
		System.out.print('+');
		System.out.print("-".repeat(17*nElements+nElements-1));
		System.out.print("+\n");
		// -----------------------------

		for (int i = 0; i < nElements; ++i) {
			System.out.print("| ");
			System.out.printf("%-15s", "Índice " + i);
			System.out.print(" ");
		}
		System.out.println("|");

		System.out.print('+');
		System.out.print("-".repeat(17*nElements+nElements-1));
		System.out.print("+\n");

	}

	public static void footer(int nElements) {
		System.out.println("|");
		System.out.print('+');
		System.out.print("-".repeat(18*nElements-1));
		System.out.println('+');
	}
}
