package com.software.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.software.bank.service.model.Credit;
import com.software.bank.service.model.Debit;

public class DecliningBalance extends CreditAbstract {

	protected Debit calculateMinDebit(Credit credit) {
		// baseDebit = credit/term
		// profit = creditRemainder * ( rate/12/100)
		// current debit = baseDebit + percent;

		Debit debit = new Debit();
		
		int monthInYear = 12;
		int scale = 4;
		
		BigDecimal baseCredit = credit.getTotalCredit().divide(new BigDecimal(credit.getTerm()), 2, RoundingMode.HALF_UP);
		if (credit.getTerm()  - credit.getQtyPayments() == 1){ // last payment, correct cents
			baseCredit = credit.getTotalCredit().subtract(credit.getTotalDebit()); 
		}
		// creditRemainder * ( rate/12/100)
		BigDecimal percent = credit.getTotalCredit().subtract(credit.getTotalDebit())
				.multiply(credit.getRate().divide(new BigDecimal(monthInYear), scale, RoundingMode.HALF_UP)
				.divide(new BigDecimal(100), 6, RoundingMode.HALF_UP));
	
		BigDecimal  minDebitPayment = baseCredit.add(percent);
		debit.setMinRequiredDebit(minDebitPayment.setScale(scale, RoundingMode.HALF_UP));
		debit.setPercent(percent.setScale(scale, RoundingMode.HALF_UP));
		return debit;
	}
	
	protected String [] createPaymentSchedule(Credit credit){
		credit.setTotalDebit(new BigDecimal("0.0"));
		int term = credit.getTerm();
		String [] schedule = new String[term];
		for(int i = 0; i< schedule.length; i++){
			Debit debit = calculateMinDebit(credit);
			schedule [i] = debit.getMinRequiredDebit().setScale(2, RoundingMode.HALF_UP).toString();
			credit.setTotalDebit(credit.getTotalDebit()
					.add(debit.getMinRequiredDebit())
					.subtract(debit.getPercent()));
			credit.setQtyPayments(i+1);
			}
		return schedule;
	}
}