package com.software.bank.domain;

import com.software.bank.dao.exception.DaoException;
import com.software.bank.input.IDataInput;
import com.software.bank.input.ReadConsole;

public abstract class CreditAbstract implements ICreditLogic {
	
	static IDataInput input = new ReadConsole();
	
	public void addCredit(){
		visual.messageWelcome();
	}
		
	@Override
	public void addCredit(String contractNumber, long summa_credit, int term, double rate) {
		try {
			dataBase.addCredit(contractNumber, summa_credit, term, rate);
			visual.messageSuccess();
		} catch (DaoException e) {
			visual.messageError();
		}
	}

	public long getDebet(String contractNumber) {
		long debet = -1;
		try {
			debet = dataBase.getDebet(contractNumber);
		} catch (DaoException e) {
			visual.messageError();
		}
		return debet;
	}
	
	@Override
	public void addPayment(String contractNumber, long summa_debet) {
		try {
			dataBase.addPayment(contractNumber, summa_debet);
			visual.messageSuccess();
		} catch (DaoException e) {
			visual.messageError();
		}
	}
	
	@Override
	public long getMinimalPayment(String contractNumber) {
		// TODO Auto-generated method stub
		return 0;
	}
}