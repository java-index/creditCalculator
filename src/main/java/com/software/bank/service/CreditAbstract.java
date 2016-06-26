package com.software.bank.service;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.dao.h2.CreditDataBaseDao;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public abstract class CreditAbstract implements ICreditLogic {
	
	public static IDataBase dataBase = new CreditDataBaseDao();

	@Override
	public void addCredit(Credit credit) throws ServiceException {
		//long summaCreditCent = Math.round(credit.getSummaCredit() * centFactor());
		try {
			dataBase.addCredit(credit);
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
	
	/**
	 * @return amount of cents in the currency unit 
	 */
	public int centFactor(){
		return 100; 
	}
}