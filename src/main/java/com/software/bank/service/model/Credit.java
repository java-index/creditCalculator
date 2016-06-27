package com.software.bank.service.model;

import java.math.BigDecimal;

import com.software.bank.service.RepaymentTypeEnum;

public class Credit {
	
	private String contractNumber;
	private BigDecimal summaCredit;
	private BigDecimal summaDebit;
	private int term;
	private BigDecimal rate;
	private RepaymentTypeEnum repayment;
	
	public String getContractNumber() {
		return contractNumber;
	}
	
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
	public BigDecimal getSummaDebit() {
		return summaDebit;
	}

	public void setSummaDebit(BigDecimal summaDebit) {
		this.summaDebit = summaDebit;
	}

	public BigDecimal getSummaCredit() {
		return summaCredit;
	}
	
	public void setSummaCredit(BigDecimal summaCredit) {
		this.summaCredit = summaCredit;
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
				" summaCredit:  " + summaCredit + 
				" summaDebit: " + summaDebit + 
				" term: " + term + 
				" rate: " + rate + 
				" repayment: " + repayment;
	}
}
