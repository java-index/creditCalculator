package com.software.bank.controller.command;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.view.KeyMessage;

public class ExitCommand implements ActionCommand {

	@Override
	public void execute(ICreditLogic creditLogic) throws ServiceException {
		CreditController.view.printMessage(KeyMessage.BYE);
		System.exit(0);
	}
}