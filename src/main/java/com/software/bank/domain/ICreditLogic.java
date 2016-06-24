package com.software.bank.domain;

public interface ICreditLogic {
	
	void addCredit(String contractNumber, long summa_credit, int term, double rate);
	
	void addPayment(String contractNumber, long summa_debet);
	
	long getDebet(String contractNumber);
	
	String [] getPaymentGrid(String contractNumber);
}
