package mx.com.tiendas3b.evale.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EvaleTiendas {
	@Id
	private Integer id;
	private Integer tclave;
	private String pv01;
	private String pv02;
	private String pv03;
	private String pv04;
	private String pv05;
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTclave() {
		return tclave;
	}

	public void setTclave(Integer tclave) {
		this.tclave = tclave;
	}

	public String getPv01() {
		return pv01;
	}

	public void setPv01(String pv01) {
		this.pv01 = pv01;
	}

	public String getPv02() {
		return pv02;
	}

	public void setPv02(String pv02) {
		this.pv02 = pv02;
	}

	public String getPv03() {
		return pv03;
	}

	public void setPv03(String pv03) {
		this.pv03 = pv03;
	}

	public String getPv04() {
		return pv04;
	}

	public void setPv04(String pv04) {
		this.pv04 = pv04;
	}

	public String getPv05() {
		return pv05;
	}

	public void setPv05(String pv05) {
		this.pv05 = pv05;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
