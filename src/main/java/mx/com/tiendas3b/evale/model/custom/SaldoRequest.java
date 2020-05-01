package mx.com.tiendas3b.evale.model.custom;

public class SaldoRequest {
	private String key;
	private String numTarjeta;
	private String tclave;
	private String caja;
	private Integer numTicket;
	private String ipLocal;
	private String ipTrans;
	private Integer bandera;

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
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

	public String getIpLocal() {
		return ipLocal;
	}

	public void setIpLocal(String ipLocal) {
		this.ipLocal = ipLocal;
	}

	public String getIpTrans() {
		return ipTrans;
	}

	public void setIpTrans(String ipTrans) {
		this.ipTrans = ipTrans;
	}

	public Integer getBandera() {
		return bandera;
	}

	public void setBandera(Integer bandera) {
		this.bandera = bandera;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
