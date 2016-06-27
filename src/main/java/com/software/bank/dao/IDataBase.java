package com.software.bank.dao;

import java.math.BigDecimal;

import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.model.Credit;

public interface IDataBase {
	
	void addCredit(Credit credit) throws DaoException;
	
	void addPayment(String contractNumber, BigDecimal summaDebit) throws DaoException;
	
	Credit getCredit(String contractNumber) throws DaoException; 
}
