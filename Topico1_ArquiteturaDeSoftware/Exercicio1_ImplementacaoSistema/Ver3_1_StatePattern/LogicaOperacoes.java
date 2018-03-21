package Refactoring03_StatePattern;

import java.util.GregorianCalendar;

public class LogicaOperacoes {
	private static LogicaOperacoes logicaInstance = null;

	private LogicaOperacoes() {
	}

	public static LogicaOperacoes getInstance() {
		if (logicaInstance == null) {
			logicaInstance = new LogicaOperacoes();
		}
		return logicaInstance;
	}

	public void defineContaEmUso(String conta) {
		Integer nroConta = Integer.parseInt(conta);
		if (nroConta == null || nroConta < 0 || !Contas.getInstance().setContaEmUso(nroConta)) {
			throw new NumberFormatException("Conta invalida");
		}
	}

	public void operacaoCredito(String strValue) {
		double valor = Integer.parseInt(strValue);
		if (valor < 0.0) {
			throw new NumberFormatException("Valor invalido");
		}
		Contas.getInstance().getContaEmUso().deposito(valor);
		GregorianCalendar date = new GregorianCalendar();
		Operacao op = new Operacao(date.get(GregorianCalendar.DAY_OF_MONTH), date.get(GregorianCalendar.MONTH + 1),
				date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.HOUR), date.get(GregorianCalendar.MINUTE),
				date.get(GregorianCalendar.SECOND), Contas.getInstance().getContaEmUso().getNumero(),
				Contas.getInstance().getContaEmUso().getStatus(), valor, 0);
		Operacoes.getInstance().insereNovaOperacao(op);
	}

	public void operacaoDebito(String strValue) {
		double valor = Integer.parseInt(strValue);
		if (valor < 0.0) {
			throw new NumberFormatException("Valor invalido");
		}
		Contas.getInstance().getContaEmUso().retirada(valor);
		GregorianCalendar date = new GregorianCalendar();
		Operacao op = new Operacao(date.get(GregorianCalendar.DAY_OF_MONTH), date.get(GregorianCalendar.MONTH + 1),
				date.get(GregorianCalendar.YEAR), date.get(GregorianCalendar.HOUR), date.get(GregorianCalendar.MINUTE),
				date.get(GregorianCalendar.SECOND), Contas.getInstance().getContaEmUso().getNumero(),
				Contas.getInstance().getContaEmUso().getStatus(), valor, 1);
		Operacoes.getInstance().insereNovaOperacao(op);
	}
	
}
