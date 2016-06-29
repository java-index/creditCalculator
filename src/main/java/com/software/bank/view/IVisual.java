package com.software.bank.view;

import java.math.BigDecimal;

import com.software.bank.service.model.Credit;

public interface IVisual {

	//void printMessage(KeyMessage key);
	
	String operationChoiceMenuView(); 
	
	Credit addCreditMenuView(); 
		
	String addPaymentContractView();
	
	void showPaymentSchedule(String [] paymentSchedule);
	
	BigDecimal addPaymentSummaView(String minDebit);
	
	void showContractClosed();
	
	void showContractNotFound(); 
	
	void showContractIsExist(); 
	
	void showInternalError(); 
	
	void showSuccess();
	
	void bye();
}