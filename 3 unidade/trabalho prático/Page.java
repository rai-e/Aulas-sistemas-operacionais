package aleatorio;

public class Page {
	String dados;//representa simplificadamente o conteúdo da página: dados e instruções
	
	public Page(String dados) {
		this.dados = dados;
	}
	
	public String toString() {
		return this.dados;
	}
}