package com.software.bank.service.model;

import java.math.BigDecimal;

import com.software.bank.service.Repayment;

public class Credit {
	
	private String contractNumber;
	
	private BigDecimal totalCredit;
	
	private BigDecimal totalDebit;
	
	private BigDecimal minRequiredDebit;
	
	private BigDecimal percent;
		
	private int term;
	
	private BigDecimal rate;
	
	private int qtyPayments; 
	
	private Repayment type;
	
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

	public Repayment getRepayment() {
		return type;
	}

	public void setRepayment(Repayment type) {
		this.type = type;
	}

	public int getQtyPayments() {
		return qtyPayments;
	}

	public void setQtyPayments(int qtyPayments) {
		this.qtyPayments = qtyPayments;
	}

	public String getContractNumber() {
		return contractNumber;
	}
	
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
	public BigDecimal getTotalCredit() {
		return totalCredit;
	}

	public void setTotalCredit(BigDecimal totalCredit) {
		this.totalCredit = totalCredit;
	}

	public BigDecimal getTotalDebit() {
		return totalDebit;
	}

	public void setTotalDebit(BigDecimal totalDebit) {
		this.totalDebit = totalDebit;
	}

	public int getTerm() {
		return term;
	}
	
	public void setTerm(int term) {
		this.term = term;
	}
	
	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return "contractNumber: " + contractNumber + 
				" Credit (UAH):  " + totalCredit + 
				" Debit (UAH): " + totalDebit + 
				" Term (M): " + term + 
				" Rate (%): " + rate;
	}
}