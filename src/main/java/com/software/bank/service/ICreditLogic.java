package com.software.bank.service;

import com.software.bank.service.exception.ServiceException;

public interface ICreditLogic {
	
	void addCredit(String contractNumber, double summa_credit, int term, double rate) throws ServiceException;
	
	void addPayment(String contractNumber, double summa_debet) throws ServiceException;
	
	long getMinimalPayment(String contractNumber);
	
	String [] getPaymentGrid(String contractNumber);
}
