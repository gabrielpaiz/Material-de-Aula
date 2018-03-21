package Refactoring02_Facade;

import java.util.List;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Operacoes {
    public static Operacoes operacoesInstancia = null;
	private List<Operacao> operacoes; 
	private ObservableList<Operacao> operacoesContaEmUso;

	private Operacoes() {
		operacoes = Persistencia.getInstance().loadOperacoes();
	}
	
	public static Operacoes getInstance() {
		if (operacoesInstancia == null) {
			operacoesInstancia = new Operacoes();
		}
		return operacoesInstancia;
	}

	public void saveOperacoes() {
		Persistencia.getInstance().saveOperacoes(operacoes);
	}
    
	public ObservableList<Operacao> getExtratoContaEmUso() {
		if (Contas.getInstance().getContaEmUso() == null) {
			return null;
		}else {
			Conta conta = Contas.getInstance().getContaEmUso();
			operacoesContaEmUso = 
	        		FXCollections.observableArrayList(
	        				operacoes
	        				.stream()
	        				.filter(op -> op.getNumeroConta() == Contas.getInstance().getContaEmUso().getNumero())
	        				.collect(Collectors.toList())
	        				);
            return operacoesContaEmUso;
		}
		
	}
	
	public void insereNovaOperacao(Operacao op) {
		operacoes.add(op);
		operacoesContaEmUso.add(op);
	}
}
