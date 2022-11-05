package com.ssafy.home.model.dto;

public class Sido {
	String dongCode;
	String sidoName;
	
	public Sido() {
	}

	public Sido(String dongCode, String sidoName) {
		this.dongCode = dongCode;
		this.sidoName = sidoName;
	}

	public String getDongCode() {
		return dongCode;
	}

	public void setDongCode(String dongCode) {
		this.dongCode = dongCode;
	}

	public String getSidoName() {
		return sidoName;
	}

	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}

	@Override
	public String toString() {
		return "Sido [dongCode=" + dongCode + ", sidoName=" + sidoName + "]";
	}
	
}
