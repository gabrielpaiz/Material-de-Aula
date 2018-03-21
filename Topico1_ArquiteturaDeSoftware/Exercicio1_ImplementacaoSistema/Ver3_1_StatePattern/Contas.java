package Refactoring03_StatePattern;

import java.util.Map;

public class Contas {
	private static Contas contasInstance = null;
	
	private Map<Integer, Conta> contas;
	private Conta contaEmUso;
	
	private Contas() {
		contas = Persistencia.getInstance().loadContas();
		contaEmUso = null;
	}
	
	public static Contas getInstance() {
		if (contasInstance == null) {
			contasInstance = new Contas();
		}
		return contasInstance;
	}
	
	public void saveContas() {
		Persistencia.getInstance().saveContas(contas.values());
	}
	
	public boolean setContaEmUso(int conta) {
		contaEmUso = contas.get(conta);
		if (contaEmUso == null) {
			return false;
		}else {
			return true;
		}
	}
	
	public Conta getContaEmUso() {
		return contaEmUso;
	}
}
