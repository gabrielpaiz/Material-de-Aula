package Refactoring03_StatePattern;

public interface StateConta {
	public int getStatus();
    public void deposito(double valor);
    public void retirada(double valor);
}
