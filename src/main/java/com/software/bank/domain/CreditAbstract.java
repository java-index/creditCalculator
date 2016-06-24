package com.software.bank.domain;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.input.IInput;
import com.software.bank.view.IVisual;

public abstract class CreditAbstract implements ICreditLogic {
	
	IDataBase dataBase = null;
	IVisual visual = null;
	IInput input = null;
		
	@Override
	public void addCredit(String contractNumber, long summa_credit, int term, double rate) {
		try {
			dataBase.addCredit(contractNumber, summa_credit, term, rate);
		} catch (DaoException e) {
			visual.messageError();
		}
	}

	@Override
	public long getDebet(String contractNumber) {
		long debet = 0;
		try {
			debet = dataBase.getDebet(contractNumber);
		} catch (DaoException e) {
			visual.messageError();
		}
		return debet;
	}
}