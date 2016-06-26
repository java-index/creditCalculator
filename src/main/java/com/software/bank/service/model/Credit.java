package com.software.bank.service.model;

import com.software.bank.service.RepaymentTypeEnum;

public class Credit {
	
	private String contractNumber;
	private double summaCredit;
	private double summaDebet;
	private int term;
	private double rate;
	private RepaymentTypeEnum repayment;
	
	public String getContractNumber() {
		return contractNumber;
	}
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	public double getSummaCredit() {
		return summaCredit;
	}
	public void setSummaCredit(double summaCredit) {
		this.summaCredit = summaCredit;
	}
	public double getSummaDebet() {
		return summaDebet;
	}
	public void setSummaDebet(double summaDebet) {
		this.summaDebet = summaDebet;
	}
	public int getTerm() {
		return term;
	}
	public void setTerm(int term) {
		this.term = term;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public RepaymentTypeEnum getRepayment() {
		return repayment;
	}
	public void setRepayment(RepaymentTypeEnum repayment) {
		this.repayment = repayment;
	}
}
