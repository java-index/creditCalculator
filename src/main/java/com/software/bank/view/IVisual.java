package com.software.bank.view;

import java.math.BigDecimal;

import com.software.bank.service.model.Credit;

public interface IVisual {

	String languageChoiceMenu(); 
	
	String operationChoiceMenu(); 
	
	Credit addCreditMenu(); 
		
	String enterContractNumber();
	
	void paymentSchedule(String [] paymentSchedule);
	
	BigDecimal enterDebit(String minDebit);
	
	void contractClosed();
	
	void contractNotFound(); 
	
	void contractIsExist(); 
	
	void internalError(); 
	
	void success();
	
	void bye();
	
	void setView(IVisual newView);
}