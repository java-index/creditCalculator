package com.software.bank.controller.command;

import java.util.NoSuchElementException;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.RepaymentTypeEnum;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;
import com.software.bank.view.KeyMessage;

public class AddCreditCommand implements ActionCommand {
	
	@Override
	public void execute(ICreditLogic creditLogic) throws ServiceException {
		
		Credit credit = new Credit();
		
		CreditController.view.printMessage(KeyMessage.ENTER_CONTRACT_NUMBER);
		credit.setContractNumber(CreditController.input.read());
		
		CreditController.view.printMessage(KeyMessage.ENTER_CREDIT);
		credit.setSummaCredit(readDouble());
		
		CreditController.view.printMessage(KeyMessage.ENTER_RATE);
		credit.setRate(readDouble());
		
		CreditController.view.printMessage(KeyMessage.ENTER_TERM);
		credit.setTerm(readInt());
		
		CreditController.view.printMessage(KeyMessage.SELECT_REPAYMENT);
		int repayment = readInt();
		credit.setRepayment(RepaymentTypeEnum.values()[repayment]);
		
		creditLogic.addCredit(credit);
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