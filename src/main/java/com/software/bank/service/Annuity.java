package com.software.bank.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.software.bank.service.model.Credit;
import com.software.bank.service.model.Debit;

public class Annuity extends CreditAbstract {
	
	@Override
	protected Debit calculateMinDebit(Credit credit) {
		// minRequiredDebit = total credit * K 
		// K - factor of annuity = P * ((1+P)^N / (1+P)^N - 1)
		// P - rate/12/100
		// N - term (month)
		
		Debit debit = new Debit();
		int scale = 10;
		BigDecimal rate = credit.getRate();
		// rate/12/100
		BigDecimal partRate = rate.divide(BigDecimal.valueOf(1200L), scale, RoundingMode.HALF_UP);
		
		BigDecimal didvident = partRate.add(new BigDecimal(1));
		didvident = didvident.pow(credit.getTerm());
		didvident = didvident.subtract(new BigDecimal(1));

		BigDecimal quotient = partRate.add(new BigDecimal(1));
		quotient = quotient.pow(credit.getTerm());
		quotient = partRate.multiply(quotient);
		// total credit * K 
		BigDecimal minRequiredDebit = credit.getTotalCredit().multiply(quotient.divide(didvident, RoundingMode.HALF_UP));
		minRequiredDebit = minRequiredDebit.setScale(2, RoundingMode.HALF_UP);
		
		debit.setMinRequiredDebit(minRequiredDebit);
		debit.setPercent(new BigDecimal(0));
		return debit;
	}
	
	protected String [] createPaymentSchedule(Credit credit){
		int term = credit.getTerm();
		String [] schedule = new String[term];
		String minRequiredDebit = calculateMinDebit(credit).getMinRequiredDebit().toString();
		for(int i = 0; i< schedule.length; i++){
			schedule[i] = minRequiredDebit;
		}
		return schedule;
	}
}