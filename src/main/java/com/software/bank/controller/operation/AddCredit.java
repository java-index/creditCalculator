package com.software.bank.controller.operation;

import com.software.bank.controller.ActionCommand;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;

public class AddCredit implements ActionCommand {

	@Override
	public void execute(ICreditLogic creditLogic) throws ServiceException {
		System.out.println("ADD CREDIT");	
	}
}
