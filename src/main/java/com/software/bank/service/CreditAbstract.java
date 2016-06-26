package com.software.bank.service;

import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public abstract class CreditAbstract implements ICreditLogic {
	
	@Override
	public void addCredit(Credit credit) throws ServiceException {
		try {
			ICreditLogic.bataBase.addCredit(credit);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public Credit getCredit(String contractNumber) throws ServiceException {
		try {
			Credit credit =  ICreditLogic.bataBase.getCredit(contractNumber);
			return credit;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}