package com.software.bank.service;

import javax.sql.rowset.serial.SerialException;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.exception.ServiceException;

public abstract class CreditAbstract implements ICreditLogic {
	
	private IDataBase dataBase;

	@Override
	public void addCredit(String contractNumber, long summa_credit, int term, double rate) throws ServiceException {
		try {
			dataBase.addCredit(contractNumber, summa_credit, term, rate);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void addPayment(String contractNumber, long summa_debet) throws ServiceException {
		try {
			dataBase.addPayment(contractNumber, summa_debet);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}