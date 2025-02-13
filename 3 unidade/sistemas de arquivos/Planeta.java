package arquivos;

import java.io.Serializable;

public class Planeta implements Serializable{
	double gravidade;
	int numLuas;
	String nome;
	
	public Planeta(double gravidade, int numLuas, String nome){
		this.gravidade = gravidade;
		this.numLuas = numLuas;
		this.nome = nome;
	}
}
