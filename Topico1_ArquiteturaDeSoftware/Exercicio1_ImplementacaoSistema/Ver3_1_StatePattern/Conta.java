package Refactoring03_StatePattern;

public class Conta {
	public final int SILVER = 0;
	public final int GOLD = 1;
	public final int PLATINUM = 2;
	public final int LIM_SILVER_GOLD = 50000;
	public final int LIM_GOLD_PLATINUM = 200000;
	public final int LIM_PLATINUM_GOLD = 100000;
	public final int LIM_GOLD_SILVER = 25000;

	private int numero;
	private String correntista;
	private double saldo;
	private StateConta state;

	public Conta(int umNumero, String umNome) {
		numero = umNumero;
		correntista = umNome;
		saldo = 0.0;
		state = new StatusSilver();
	}

	public Conta(int umNumero, String umNome, double umSaldo, int umStatus) {
		numero = umNumero;
		correntista = umNome;
		saldo = umSaldo;
		switch (umStatus) {
		case SILVER:
			state = new StatusSilver();
			break;
		case GOLD:
			state = new StatusGold();
			break;
		case PLATINUM:
			state = new StatusPlatinum();
			break;
		}
	}

	public double getSaldo() {
		return saldo;
	}

	public Integer getNumero() {
		return numero;
	}

	public String getCorrentista() {
		return correntista;
	}

	public int getStatus() {
		return state.getStatus();
	}

	public void deposito(double valor) {
		state.deposito(valor);
	}

	public void retirada(double valor) {
		if (saldo - valor < 0.0) {
			return;
		} else {
			state.retirada(valor);
		}
	}

	@Override
	public String toString() {
		return "Conta [numero=" + numero + ", correntista=" + correntista + ", saldo=" + saldo + ", status="
				+ state.getStatus() + "]";
	}

	class StatusSilver implements StateConta {
		public int getStatus() {
			return SILVER;
		}

		@Override
		public void deposito(double valor) {
			saldo += valor;
			if (saldo >= LIM_SILVER_GOLD) {
				state = new StatusGold();
			}
		}

		@Override
		public void retirada(double valor) {
			saldo = saldo - valor;
		}
	}

	class StatusGold implements StateConta {
		@Override
		public int getStatus() {
			return GOLD;
		}

		@Override
		public void deposito(double valor) {
			saldo += valor * 1.01;
			if (saldo >= LIM_GOLD_PLATINUM) {
				state = new StatusPlatinum();
			}
		}

		@Override
		public void retirada(double valor) {
			saldo = saldo - valor;
			if (saldo < LIM_GOLD_SILVER) {
				state = new StatusSilver();
			}
		}
	}

	class StatusPlatinum implements StateConta {
		@Override
		public int getStatus() {
			return PLATINUM;
		}

		@Override
		public void deposito(double valor) {
			saldo = saldo + valor * 1.025;
		}

		@Override
		public void retirada(double valor) {
			saldo = saldo - valor;
			if (saldo < LIM_PLATINUM_GOLD) {
				state = new StatusGold();
			}
		}
	}
}
