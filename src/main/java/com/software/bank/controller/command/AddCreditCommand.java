package com.software.bank.controller.command;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public class AddCreditCommand implements ActionCommand {
	
	@Override
	public void execute() throws ServiceException {
		Credit credit = CreditController.view.addCreditMenuView();
		ICreditLogic creditLogic = credit.getRepayment().getRepaymentMethod();
		creditLogic.addCredit(credit);
	}
}