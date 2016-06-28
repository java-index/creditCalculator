package com.software.bank.service;

import com.software.bank.service.exception.ServiceException;
import com.software.bank.view.IVisual;

public interface ICreditLogic {
	
	IVisual getView();
	
	void addCredit() throws ServiceException;
	
	void addDebit() throws ServiceException;

}