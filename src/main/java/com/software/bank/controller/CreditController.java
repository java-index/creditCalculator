package com.software.bank.controller;

import com.software.bank.service.exception.ServiceException;
import com.software.bank.view.IVisual;
import com.software.bank.view.VisualEng;

public class CreditController {

	public static IVisual view; // = new VisualEng();

	public void selectLanguage() {
		String languageChoice = view.languageChoiceMenuView();
		mainProcess(languageChoice);
	}
	
	public void selectOperation() {
		String operationChoice = view.operationChoiceMenuView();
		mainProcess(operationChoice);
	}

	private void mainProcess(String userChoice) {
		ActionCommand command = ActionFactory.defineCommand(userChoice);
		try {
			command.execute();
		} catch (ServiceException e) {
			view.showInternalError();
		}
	}
}