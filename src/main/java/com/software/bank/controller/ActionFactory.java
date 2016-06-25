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
		// select language, menu id = 0
		case "10":
			return "SET_LANGUAGE_EN";
		case "20":
			return "SET_LANGUAGE_UA";
		case "30":
			return "SET_LANGUAGE_RU";
		// select credit operation, menu id = 1	
		case "11":
			return "ADD_CREDIT";
		case "21":
			return "ADD_PAYMENT";
		case "31":
			return "MIN_PAYMENT";
		case "41":
			return "PAYMENT_GRID";
		default:
			return "EXIT";
		}
	}
}
