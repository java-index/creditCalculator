package com.software.bank.service.model;

import java.math.BigDecimal;

public class Debit {
	
	private BigDecimal percent;
	
	private BigDecimal minRequiredDebit;

	public BigDecimal getPercent() {
		return percent;
	}

	public void setPercent(BigDecimal percent) {
		this.percent = percent;
	}

	public BigDecimal getMinRequiredDebit() {
		return minRequiredDebit;
	}

	public void setMinRequiredDebit(BigDecimal minRequiredDebit) {
		this.minRequiredDebit = minRequiredDebit;
	}
}