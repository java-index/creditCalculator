package com.software.bank.service;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.h2.CreditDataBaseDao;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;
import com.software.bank.view.IVisual;
import com.software.bank.view.VisualGeneral;

public interface ICreditLogic {
	
	IVisual view = new VisualGeneral();
	
	IDataBase dataBase = new CreditDataBaseDao();
	
	String [] addCredit(Credit credit) throws ServiceException;
	
	Credit getCredit(String contractNumber) throws ServiceException;
	
	void addDebit(Credit credit) throws ServiceException;
	
}