package mx.com.tiendas3b.evale.model.custom;

public class TransactionRequest {

	private Integer logId;
	private String tarjetaNum;
	private String tclave;
	private String caja;
	private Integer numTicket;
	private Double monto;
	private String llave;

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getTarjetaNum() {
		return tarjetaNum;
	}

	public void setTarjetaNum(String tarjetaNum) {
		this.tarjetaNum = tarjetaNum;
	}

	public String getTclave() {
		return tclave;
	}

	public void setTclave(String tclave) {
		this.tclave = tclave;
	}

	public String getCaja() {
		return caja;
	}

	public void setCaja(String caja) {
		this.caja = caja;
	}

	public Integer getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(Integer numTicket) {
		this.numTicket = numTicket;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

}
