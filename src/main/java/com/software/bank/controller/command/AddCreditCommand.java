package com.software.bank.controller.command;

import java.util.NoSuchElementException;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.view.KeyMessage;

public class AddCreditCommand implements ActionCommand {
	
	@Override
	public void execute(ICreditLogic creditLogic) throws ServiceException {
		
		CreditController.view.printMessage(KeyMessage.ENTER_CONTRACT_NUMBER);
		String contractNumber = CreditController.input.read();
		
		CreditController.view.printMessage(KeyMessage.ENTER_CREDIT);
		double summaCredit = readDouble();
		
		CreditController.view.printMessage(KeyMessage.ENTER_RATE);
		double rate = readDouble();
		
		CreditController.view.printMessage(KeyMessage.ENTER_TERM);
		int term = readInt();
		
		CreditController.view.printMessage(KeyMessage.SELECT_REPAYMENT);
		String repaymentMethod = CreditController.input.read();
		
		creditLogic.addCredit(contractNumber, summaCredit, term, rate);
		String [] grid = creditLogic.getPaymentGrid(contractNumber);
	}
	
	private double readDouble(){
		double value = 0;
		while (true){
			try{
				value = CreditController.input.readDouble();
				break;
			} catch (NoSuchElementException e) {
				CreditController.view.printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
		return value;
	}
	
	private int readInt(){
		int value = 0;
		while (true){
			try{
				value = CreditController.input.readInt();
				break;
			} catch (NoSuchElementException e) {
				CreditController.view.printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
		return value;
	}
}