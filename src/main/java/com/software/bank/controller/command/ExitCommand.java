package com.software.bank.controller.command;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.exception.ServiceException;

public class ExitCommand implements ActionCommand {

	@Override
	public void execute() throws ServiceException {
		CreditController.view.bye();
		System.exit(0);
	}
}