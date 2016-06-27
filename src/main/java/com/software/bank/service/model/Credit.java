package com.software.bank.service.model;

import java.math.BigDecimal;

import com.software.bank.service.RepaymentTypeEnum;

public class Credit {
	
	private String contractNumber;
	private BigDecimal totalCredit;
	private BigDecimal totalDebit;
	private int term;
	private BigDecimal rate;
	private RepaymentTypeEnum repayment;
	
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
	
	public RepaymentTypeEnum getRepayment() {
		return repayment;
	}
	
	public void setRepayment(RepaymentTypeEnum repayment) {
		this.repayment = repayment;
	}
	
	@Override
	public String toString() {
		return "contractNumber: " + contractNumber + 
				" Credit (UAH):  " + totalCredit + 
				" Debit (UAH): " + totalDebit + 
				" Term (M): " + term + 
				" Rate (%): " + rate + 
				" Repayment: " + repayment;
	}
}
