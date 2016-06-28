package com.software.bank.controller;

public class ActionFactory {

	public static ActionCommand defineCommand(String userChoice) {
		String command = createCommand(userChoice);
		CreditCommandEnum currentCommand = CreditCommandEnum.valueOf(command);
		ActionCommand currentAction = currentCommand.getCurrentCommand();
		return currentAction;
	}
	
	/**
	 *  Convert users input to command  
	 */
	private static String createCommand(String userChoice) {
		switch (userChoice) {
		case "1":
			return "ADD_CREDIT";
		case "2":
			return "ADD_DEBIT";
		default:
			return "EXIT";
		}
	}
}