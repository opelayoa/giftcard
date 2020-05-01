package mx.com.tiendas3b.evale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Saldo {
	
	// 123456196 log_id	user_id	tarjeta_id	tarjeta_num	saldo	fecha_vig	tstatus
	@Id
	@Column(name = "log_id")
	private int logId;
	@Column(name = "user_id")
	private int tarjetaId;
	@Column(name = "tarjeta_id")
	private String tarjetaNum;
	@Column(name = "tarjeta_num")
	private String userId;
	@Column(name = "saldo")
	private float saldo;
	@Column(name = "fecha_vig")
	private String vigencia;
	@Column(name = "tstatus")
	private String status;
	
	// private HandlerError error;
	public int getLogId() {
		return logId;
	}

	public void setLogId(int logId) {
		this.logId = logId;
	}

	public int getTarjetaId() {
		return tarjetaId;
	}

	public void setTarjetaId(int tarjetaId) {
		this.tarjetaId = tarjetaId;
	}

	public String getTarjetaNum() {
		return tarjetaNum;
	}

	public void setTarjetaNum(String tarjetaNum) {
		this.tarjetaNum = tarjetaNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
