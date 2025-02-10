package aleatorio;
import java.util.Scanner;

public class GerenciadorMemoriaAleatorio {

	public static void main(String[] args) {
		/* declarando 4 p�ginas na ram */
		Page ram[] = new Page[4];//linkedlist
		/* declarando 6 p�ginas no hd */
		Page hd[] = new Page[6];
		/* Considere que o sistema est� no seguinte estado
		 *	- A � composto de 3 blocos/p�ginas
		 *		PARTE 1 DE A NA RAM
		 *		PARTE 2 DE A NO DISCO
		 *		PARTE 3 DE A NO DISCO
		 *	- B � composto de 4 blocos/p�ginas
		 *		PARTE 1 DE B NO DISCO
		 *		PARTE 2 DE B NO DISCO
		 *		PARTE 3 DE B NO DISCO
		 *		PARTE 4 DE B NO DISCO
		 *  - C � composto de 3 blocos/p�ginas
		 *  	PARTE 1 DE C NA RAM
		 *  	PARTE 2 DE C NA RAM
		 *  	PARTE 3 DE C NA RAM
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
			int indexPageHD = -1;//guarda o �ndice do hd que ser� feito page in
			int indexPageRAM = -1;//guarda o �ndice da RAM que ser� referenciada
			switch (opcao) {
			case 1:
				System.out.print("Qual �ndice do disco ser� usada no page in? 0 a "+(hd.length-1)+" ");
				indexPageHD = scan.nextInt();//Selecione qual �ndice do disco tem uma p�gina que ir� para a RAM
				System.out.println("A p�gina atualmente associada a esse �ndice do disco �: "+hd[indexPageHD]);//exiba a p�gina que est� no �ndice
				/* RECOMENDADO TRATAR A EXCE��O DE ACESSAR POSI��O FORA DO TAMANHO DO VETOR */
				System.out.println("O algoritmo est� selecionando p�gina da RAM para ser substitu�da...");
				/* 
				 * 
				 * SUA IMPLEMENTA��O DE PAGE IN
				 * O algoritmo ir� escolher qual �ndice ser� selecionado para sair da RAM
				 * 
				 * */
				int indexSelecionadoAlgoritmo = -1;
				/* substituir pelo �ndice calculado pelo algoritmo */
				System.out.println("O �ndice escolhido pelo algoritmo para sair da RAM foi: "+indexSelecionadoAlgoritmo);//exibir valor de ram[indexSelecionadoAlgritmo]
				System.out.println("A p�gina atualmente associada a esse �ndice �: ram[indexSelecionadoAlgoritmo]");//exiba a p�gina que est� no �ndice escolhido pelo algoritmo
				break;
			case 2:
				System.out.print("Qual �ndice da RAM ser� referenciado? 0 a "+(ram.length - 1)+" ");
				indexPageRAM = scan.nextInt();
				System.out.println("A p�gina atualmente associada a esse �ndice �: "+ram[indexPageRAM]);//exiba a p�gina que est� no �ndice
				System.out.println("Referenciando p�gina da RAM...");
				/* 
				 * SUA IMPLEMENTA��O DE REFER�NCIA � P�GINA
				 * Alguns algoritmos fazem algum processamento nessa etapa
				 */
				break;
			case 3:
				
				header(" MEM�RIA RAM ATUAL ",ram.length);

				for (int i = 0; i < ram.length; ++i) {
					System.out.print("| ");
					System.out.printf("%-15s", ram[i]);
					System.out.print(" ");
				}
				footer(ram.length);
				header(" MEM�RIA HDD ATUAL ",hd.length);

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
			System.out.printf("%-15s", "�ndice " + i);
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
