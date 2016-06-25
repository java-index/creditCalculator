package com.software.bank.service;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.dao.h2.CreditDataBaseDao;
import com.software.bank.service.exception.ServiceException;

public abstract class CreditAbstract implements ICreditLogic {
	
	private IDataBase dataBase = new CreditDataBaseDao();

	@Override
	public void addCredit(String contractNumber, double summaCredit, int term, double rate) throws ServiceException {
		long summaCreditCent = Math.round(summaCredit * centFactor());
		try {
			dataBase.addCredit(contractNumber, summaCreditCent, term, rate);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addPayment(String contractNumber, double summaDebet) throws ServiceException {
		long summaDebetCent = Math.round(summaDebet * centFactor());
		try {
			dataBase.addPayment(contractNumber, summaDebetCent);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	private int centFactor(){
		return 100;
	}
}