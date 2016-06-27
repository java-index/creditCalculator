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
		// select language, menu id = _lang
		case "1_lang":
			return "SET_LANGUAGE_EN";
		case "2_lang":
			return "SET_LANGUAGE_UA";
		case "3_lang":
			return "SET_LANGUAGE_RU";
		// select credit operation, menu id = _oper	
		case "1_oper":
			return "ADD_CREDIT";
		case "2_oper":
			return "ADD_PAYMENT";
		default:
			return "EXIT";
		}
	}
}