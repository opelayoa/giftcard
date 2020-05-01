package mx.com.tiendas3b.evale.model.custom;

public class TransactionResponse {
	
	private int logId;
	private String ncEnvio;
	private ErrorHandler error;

	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public String getNcEnvio() {
		return ncEnvio;
	}

	public void setNcEnvio(String ncEnvio) {
		this.ncEnvio = ncEnvio;
	}

	public ErrorHandler getError() {
		return error;
	}

	public void setErrorHandler(ErrorHandler error) {
		this.error = error;
	}

}
