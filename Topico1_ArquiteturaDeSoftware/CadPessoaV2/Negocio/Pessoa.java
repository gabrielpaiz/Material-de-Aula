package Negocio;

public class Pessoa {
	private String nome;
	private char sexo;
	
	public Pessoa(String umNome, boolean masculino) {
		nome = umNome;
		if(masculino) {
			sexo = 'M';
		}
		else {
			sexo = 'F';
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public char getSexo() {
		return sexo;
	}
	
	public String toString() {
		return "["+nome+","+sexo+"]";
	}
	
	public static boolean consiste(String nome) {
		if (!nome.isEmpty() && nome.contains(" ")) {
			return true;
		}else {
			return(false);
		}
	}
}
