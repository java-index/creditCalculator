package com.software.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.software.bank.controller.CreditController;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;
import com.software.bank.service.model.Debit;

public class DecliningBalance extends CreditAbstract {
	
	@Override
	public void addPayment(Debit debit) throws ServiceException {
		BigDecimal currentDebit = debit.getCurrentDebit().subtract(debit.getPercent()).setScale(2, RoundingMode.HALF_UP);
		BigDecimal newTotalDebet = currentDebit.add(debit.getTotalDebit());
		try {
			ICreditLogic.bataBase.addPayment(debit.getContractNumber(), newTotalDebet);
		} catch (DaoException e) {
			CreditController.view.showInternalError();
		}
	}

	@Override
	public Debit getMinPayment(Credit credit) {
		
		System.err.println(credit);
		// baseDebit = credit/term
		// profit = creditRemainder * ( rate/12/100)
		// current debit = baseDebit + profit;
		
		Debit minDebit = new Debit();
		int monthInYear = 12;
		int scale = 6;
		
		BigDecimal baseCredit = credit.getTotalCredit().divide(new BigDecimal(credit.getTerm()), scale, RoundingMode.HALF_UP);
		
		System.err.println(baseCredit);				
		
		BigDecimal percent = credit.getTotalCredit().subtract(credit.getTotalDebit()).multiply(credit.getRate().divide(new BigDecimal(monthInYear), scale, RoundingMode.HALF_UP).divide(new BigDecimal(100), 6, RoundingMode.HALF_UP));
		
		System.err.println(percent);				
		
		BigDecimal  minDebitPayment = baseCredit.add(percent).setScale(2, RoundingMode.HALF_UP);
		
		minDebit.setMinDebit(minDebitPayment.setScale(4, RoundingMode.HALF_UP));
		minDebit.setTotalDebit(credit.getTotalDebit());
		minDebit.setPercent(percent.setScale(4, RoundingMode.HALF_UP));
		minDebit.setContractNumber(credit.getContractNumber());
		
		return minDebit;
	}
}