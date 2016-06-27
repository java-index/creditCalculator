package com.software.bank.service.model;

import java.math.BigDecimal;

public class Debit {
	
	private String contractNumber;
	
	private BigDecimal percent;
	
	private BigDecimal minDebit;

	private BigDecimal currentDebit;

	private BigDecimal totalDebit;

	public String getContractNumber() {
		return contractNumber;
	}

	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public BigDecimal getMinDebit() {
		return minDebit;
	}

	public void setMinDebit(BigDecimal minDebit) {
		this.minDebit = minDebit;
	}

	public BigDecimal getCurrentDebit() {
		return currentDebit;
	}

	public void setCurrentDebit(BigDecimal currentDebit) {
		this.currentDebit = currentDebit;
	}

	public BigDecimal getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(BigDecimal totalDebit) {
		this.totalDebit = totalDebit;
	}

	
}