package com.software.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;
import com.software.bank.service.model.Debit;

public abstract class CreditAbstract implements ICreditLogic {
	
	abstract protected Debit calculateMinDebit(Credit redit); 
	
	abstract protected String [] createPaymentSchedule(Credit credit);
	
	@Override
	public String [] addCredit(Credit credit) throws ServiceException {
		saveCredit(credit);
		return createPaymentSchedule(credit);
	}
	
	@Override
	public Credit getCredit(String contractNumber) throws ServiceException {
		try {
			Credit credit = dataBase.getCredit(contractNumber);
			if (credit != null){
				Debit debit = calculateMinDebit(credit);
				credit.setMinRequiredDebit(debit.getMinRequiredDebit());
				credit.setPercent(debit.getPercent());
			}
			return credit;
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void addDebit(Credit credit) throws ServiceException {
		BigDecimal newTotalDebit = setNewTotalDebit(credit);
		credit.setTotalDebit(newTotalDebit);
		saveDebit(credit);
	}
	
	private BigDecimal setNewTotalDebit(Credit credit) {
		BigDecimal currentDebit = credit.getMinRequiredDebit().subtract(credit.getPercent()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal newTotalDebet = currentDebit.add(credit.getTotalDebit());
		return newTotalDebet;
	}

	private void saveDebit(Credit credit) throws ServiceException {
		try {
			dataBase.addPayment(credit.getContractNumber(), credit.getTotalDebit());
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}

	private void saveCredit(Credit credit) throws ServiceException {
		try {
			dataBase.addCredit(credit);
		} catch (DaoException e) {
			throw new ServiceException(e);
		}
	}
}