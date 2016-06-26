package com.software.bank.view;

import com.software.bank.service.model.Credit;
import com.software.bank.service.model.Debit;

public interface IVisual {

	void printMessage(KeyMessage key);
	
	String languageChoiceMenuView();

	String operationChoiceMenuView(); 
	
	Credit addCreditMenuView(); 
		
	Debit getDebitMenuView();
	
	void showContractNotFound(); 
	
	void showInternalError(); 
	
	void showSuccess();
	
	void bye();
}