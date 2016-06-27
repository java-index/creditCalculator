package com.software.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.software.bank.controller.CreditController;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;
import com.software.bank.service.model.Debit;

public class Annuity extends CreditAbstract {
	
	@Override
	public void addPayment(Debit debit) throws ServiceException {
		try {
			ICreditLogic.bataBase.addPayment(debit.getContractNumber(), debit.getCurrentDebit());
		} catch (DaoException e) {
			CreditController.view.showInternalError();
		}
	}
	
	@Override
	public Debit getMinPayment(Credit credit) {
		// X (min payment) = S * K 
		// K - factor of annuity p *  ((1 + p)^n / (1+P)^n - 1)
		// S - credit total
		// p - rate/12/100
		// n - term (month)
		
		Debit minDebit = new Debit();
		int scale = 10;
		
		BigDecimal rate = credit.getRate();
		BigDecimal partRate = rate.divide(BigDecimal.valueOf(1200L), scale, RoundingMode.HALF_UP);

		BigDecimal didvident = partRate.add(new BigDecimal(1));
		didvident = didvident.pow(credit.getTerm());
		didvident = didvident.subtract(new BigDecimal(1));

		BigDecimal quotient = partRate.add(new BigDecimal(1));
		quotient = quotient.pow(credit.getTerm());
		quotient = partRate.multiply(quotient);

		BigDecimal minDebetPayment = credit.getTotalCredit().multiply(quotient.divide(didvident, RoundingMode.HALF_UP));
		minDebetPayment = minDebetPayment.setScale(2, RoundingMode.HALF_UP);
		
		minDebit.setMinDebit(minDebetPayment);
		minDebit.setTotalDebit(credit.getTotalDebit());
		minDebit.setPercent(new BigDecimal(0));
		minDebit.setContractNumber(credit.getContractNumber());
		
		return minDebit;
	}
}