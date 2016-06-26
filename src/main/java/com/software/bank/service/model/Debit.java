package com.software.bank.service.model;


public class Debit {
	
	private String contractNumber;
	private double summaDebit;
	
	public String getContractNumber() {
		return contractNumber;
	}
	
	public void setContractNumber(String contractNumber) {
		this.contractNumber = contractNumber;
	}
	
	public double getSummaDebit() {
		return summaDebit;
	}
	
	public void setSummaDebit(double summaDebit) {
		this.summaDebit = summaDebit;
	}
}
