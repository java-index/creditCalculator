package com.software.bank.controller.command;

import com.software.bank.controller.ActionCommand;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;

public class ExitCommand implements ActionCommand {

	@Override
	public void execute(ICreditLogic creditLogic) throws ServiceException {
		creditLogic.getView().bye();
		System.exit(0);
	}
}