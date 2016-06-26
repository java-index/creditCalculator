package com.software.bank.controller;

import com.software.bank.service.exception.ServiceException;
import com.software.bank.view.IVisual;
import com.software.bank.view.VisualEng;
import com.software.bank.view.input.IDataInput;
import com.software.bank.view.input.ReadConsole;

public class CreditController {

	public static IVisual view = new VisualEng();
	public static IDataInput input = new ReadConsole();

	public void launch() {
		while (true) {
			String languageChoice = view.languageChoiceMenuView();
			mainProcess(languageChoice);
			String operationChoice = view.operationChoiceMenuView();
			mainProcess(operationChoice);
		}
	}

	private void mainProcess(String userChoice) {
		ActionCommand command = ActionFactory.defineCommand(userChoice);
		try {
			command.execute();
			view.showSuccess();
		} catch (ServiceException e) {
			view.showInternalError();
		}
	}
}