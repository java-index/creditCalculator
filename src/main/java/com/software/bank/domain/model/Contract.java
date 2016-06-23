package com.software.bank.domain.model;

import java.math.BigDecimal;

public class Contract {
	
	private String contartNumber;
	
	private int time;
	
	private BigDecimal summa;

	public String getContartNumber() {
		return contartNumber;
	}

	public void setContartNumber(String contartNumber) {
		this.contartNumber = contartNumber;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public BigDecimal getSumma() {
		return summa;
	}

	public void setSumma(BigDecimal summa) {
		this.summa = summa;
	}
}
