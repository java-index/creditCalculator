package com.software.bank.view;

public interface IVisual {
	
	void messageContractNumber();
		
	void messageWelcome();
	
	void messageBye();
	
	void showPaymentGrid(String[] list);
	
	void messageError();
	
	void messageSuccess();
}