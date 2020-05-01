package mx.com.tiendas3b.evale.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RegistryTransaction {
	@Id
	@Column(name = "log_id")
	private int logId;
	@Column(name = "nc_envio")
	private String ncEnvio;

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

}
