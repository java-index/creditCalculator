package com.software.bank.controller;

import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;

public class CreditController {

	private ICreditLogic creditLogic;
	
	public ICreditLogic getCreditLogic() {
		return creditLogic;
	}

	public void setCreditLogic(ICreditLogic creditLogic) {
		this.creditLogic = creditLogic;
	}

	public void choiceOperation() {
		String operationChoice = creditLogic.getView().operationChoiceMenuView();
		ActionCommand command = ActionFactory.defineCommand(operationChoice);
		try {
			command.execute(creditLogic);
		} catch (ServiceException e) {
			creditLogic.getView().showInternalError();
		}
	}
}