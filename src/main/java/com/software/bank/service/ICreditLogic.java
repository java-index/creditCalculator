package com.software.bank.service;

import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public interface ICreditLogic {
	
	void addCredit(Credit credit) throws ServiceException;
	
	void addPayment(String contractNumber, double summa_debet) throws ServiceException;
	
	long getMinimalPayment(String contractNumber) throws ServiceException;
}
