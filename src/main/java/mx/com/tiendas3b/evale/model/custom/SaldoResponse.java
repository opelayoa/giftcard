package mx.com.tiendas3b.evale.model.custom;

import mx.com.tiendas3b.evale.model.Saldo;

public class SaldoResponse {
	private Saldo saldo;
	private ErrorHandler errorHandler;

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	public ErrorHandler getErrorHandler() {
		return errorHandler;
	}

	public void setErrorHandler(ErrorHandler errorHandler) {
		this.errorHandler = errorHandler;
	}

}
