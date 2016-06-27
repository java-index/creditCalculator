package com.software.bank.service;

import java.math.BigDecimal;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.h2.CreditDataBaseDao;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public interface ICreditLogic {
	
	IDataBase bataBase = new CreditDataBaseDao();
	
	void addCredit(Credit credit) throws ServiceException;
	
	Credit getCredit(String contractNumber) throws ServiceException;
	
	void addPayment(String contractNumber, BigDecimal debit) throws ServiceException;
	
	String getMinPayment(Credit credit);
}
