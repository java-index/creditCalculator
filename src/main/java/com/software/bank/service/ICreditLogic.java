package com.software.bank.service;

import com.software.bank.service.exception.ServiceException;

public interface ICreditLogic {
	
	void addCredit(String contractNumber, long summa_credit, int term, double rate) throws ServiceException;
	
	void addPayment(String contractNumber, long summa_debet) throws ServiceException;
	
	long getMinimalPayment(String contractNumber);
	
	String [] getPaymentGrid(String contractNumber);
}
