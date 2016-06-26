package com.software.bank.controller.command.language;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.view.VisualRus;

public class ViewRuCommand implements ActionCommand {

	@Override
	public void execute() throws ServiceException {
		CreditController.view = new VisualRus();
	}
}