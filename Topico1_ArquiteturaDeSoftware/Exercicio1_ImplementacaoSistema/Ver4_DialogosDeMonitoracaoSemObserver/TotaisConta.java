package Refactoring05_DialogoModeless;

public class TotaisConta {
	private int numero;
	private String nomeCorrentista;
	private boolean maiorSaldo;
    private double totalCreditos;
    private double totalDebitos;
	
    public TotaisConta(int numero, String nomeCorrentista, double totalCreditos, double totalDebitos, boolean maiorSaldo) {
		super();
		this.numero = numero;
		this.nomeCorrentista = nomeCorrentista;
		this.totalCreditos = totalCreditos;
		this.totalDebitos = totalDebitos;
		this.maiorSaldo = maiorSaldo;
	}

    public int getNumero() {
    	return numero;	
    }
    
    public String getNomeCorrentista() {
    	return nomeCorrentista;
    }
    
	public double getTotalCreditos() {
		return totalCreditos;
	}

	public double getTotalDebitos() {
		return totalDebitos;
	}

	public boolean isMaiorSaldo() {
		return maiorSaldo;
	}
    
    public double getSaldo() {
    	return totalCreditos - totalDebitos;
    }
}
