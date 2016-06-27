package com.software.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.software.bank.dao.exception.DaoException;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public class Annuity extends CreditAbstract {

	@Override
	public void addPayment(String contractNumber, BigDecimal summaDebit) throws ServiceException {
		try {
			ICreditLogic.bataBase.addPayment(contractNumber, summaDebit);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMinPayment(Credit credit) {
		// min payment
		// X = S * K 
		// K = p *  ((1 + p)^n / (1+P)^n - 1)
		// X - month payment
		// K - factor of annuity
		// S - credit total
		// p - rate/12/100
		// n - term (month)
		
		BigDecimal rate = credit.getRate();
		BigDecimal partRate = rate.divide(BigDecimal.valueOf(1200L), 6, RoundingMode.HALF_UP);

		BigDecimal didvident = partRate.add(new BigDecimal(1));
		didvident = didvident.pow(credit.getTerm());
		didvident = didvident.subtract(new BigDecimal(1));

		BigDecimal quotient = partRate.add(new BigDecimal(1));
		quotient = quotient.pow(credit.getTerm());
		quotient = partRate.multiply(quotient);

		BigDecimal minDebet = credit.getSummaCredit().multiply(quotient.divide(didvident, RoundingMode.HALF_UP));
		minDebet = minDebet.setScale(2, RoundingMode.HALF_UP);

		return minDebet.toString();
	}
}