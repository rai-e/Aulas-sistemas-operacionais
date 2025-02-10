package fila;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Page implements Comparable<Page>{
	int idade;
	double altura;
	long epoch;
	/* vários atributos*/
	public Page(int idade, double altura) {
		this.idade = idade;
		this.altura = altura;
		epoch = System.currentTimeMillis();
	}
	
	public void setEpoch(long epoch) {
		this.epoch = epoch;
	}

	@Override
	public int compareTo(Page outraPage) {
		if(this.altura > outraPage.altura) {
			return -1;//objeto this deve vir depois
		}else if(this.altura < outraPage.altura) {
			return 1;//objeto this deve vir antes
		}else {
			return 0;//iguais
		}
		//return this.idade - outraPage.idade;
	}
}

public class FilaExample {

	public static void main(String[] args) {
		Queue<Page> fila = new LinkedList<>();
		
		fila.add(new Page(53,3.0));
		fila.add(new Page(98,3.0));
		fila.add(new Page(19,3.0));
		fila.add(new Page(40,3.0));
		
		for (Page item : fila) {
            System.out.print(item.idade+" ");
        }
		
		System.out.println("\nfrente: "+fila.peek().idade);
		System.out.println("\nremovido a frente: "+fila.remove().idade);
		for (Page item : fila) {
            System.out.print(item.idade+" ");
        }
		System.out.println("\nfrente: "+fila.peek().idade);
		System.out.println("\nremovido a frente: "+fila.remove().idade);
		for (Page item : fila) {
            System.out.print(item.idade+" ");
        }
	}

}
