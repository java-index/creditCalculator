package com.software.bank.dao;

import com.software.bank.dao.exception.DaoException;

public interface IDataBase {
	
	void addCredit(String contractNumber, long summa, int term, double rate) throws DaoException;
	
	void addPayment(String contractNumber, long summa) throws DaoException;
	
	long getDebet(String contractNumber) throws DaoException;
	
	long getCredit(String contractNumber) throws DaoException; 

	int getTerm(String contractNumber) throws DaoException; 
	
	double getRate(String contractNumber) throws DaoException; 
}
