package com.software.bank.controller;

import com.software.bank.controller.input.IDataInput;
import com.software.bank.controller.input.ReadConsole;
import com.software.bank.service.DecliningBalance;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.view.IVisual;
import com.software.bank.view.KeyMessage;
import com.software.bank.view.VisualEng;

public class CreditController {
	
	public static IVisual view = new VisualEng();;
	public static IDataInput input = new ReadConsole();;
	
	private ICreditLogic creditLogic = new DecliningBalance();
	
	public ICreditLogic getCreditLogic() {
		return creditLogic;
	}

	public void setCreditLogic(ICreditLogic creditLogic) {
		this.creditLogic = creditLogic;
	}
	
	public void start() {
		showMenu(KeyMessage.SELECT_LANGUAGE, 0);
		showMenu(KeyMessage.SELECT_OPERATION, 1);
	}

	private void showMenu(KeyMessage key, int idMenu) {
		view.printMessage(key);;
		String userChoice = input.read();
		ActionCommand command = ActionFactory.defineCommand(userChoice + idMenu);
		try {
			command.execute(creditLogic);
		} catch (ServiceException e) {
			view.printMessage(KeyMessage.INTERNAL_ERROR);
		}
	}
}