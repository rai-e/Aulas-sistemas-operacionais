package fila;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Page {
	String dados;

	/* vários atributos */
	public Page(String dados) {
		this.dados = dados;
	}

}

public class FilaExemplo {

	public static void main(String[] args) {
		Queue<Page> fila = new LinkedList<>();
		// idade,
		fila.add(new Page("dados 0"));
		fila.add(new Page("dados 1"));
		fila.add(new Page("dados 2"));
		fila.add(new Page("dados 3"));

		for (Page item : fila) {
			System.out.print(item.dados + "|");
		}

		System.out.println("\nfrente: " + fila.peek().dados);

		System.out.println("removido no início: " + fila.remove().dados);
		System.out.println("-------------------------");
		for (Page item : fila) {
			System.out.print(item.dados + "|");
		}

		System.out.println("\nfrente: " + fila.peek().dados);

		System.out.println("removido no início: " + fila.remove().dados);
		System.out.println("-------------------------");
		for (Page item : fila) {
			System.out.print(item.dados + "|");
		}

		System.out.println("\nfrente: " + fila.peek().dados);

		System.out.println("adicionado no fim: " + fila.add(new Page("dados 4")));
		System.out.println("-------------------------");
		for (Page item : fila) {
			System.out.print(item.dados + "|");
		}
	}

}
