package mx.com.tiendas3b.evale.model;

public class SaldoParam {

	private String tarjetaNum;
	private String tclave;
	private String caja;
	private String numTicket;
	private String ipTrans;
	private String llave;

	public SaldoParam(String tarjetaNum, String tclave, String caja, String numTicket, String ipTrans, String llave) {
		super();
		this.tarjetaNum = tarjetaNum;
		this.tclave = tclave;
		this.caja = caja;
		this.numTicket = numTicket;
		this.ipTrans = ipTrans;
		this.llave = llave;
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

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public String getIpTrans() {
		return ipTrans;
	}

	public void setIpTrans(String ipTrans) {
		this.ipTrans = ipTrans;
	}

	public String getLlave() {
		return llave;
	}

	public void setLlave(String llave) {
		this.llave = llave;
	}

}
