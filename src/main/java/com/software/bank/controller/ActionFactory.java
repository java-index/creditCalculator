package com.software.bank.controller;

public class ActionFactory {

	public static ActionCommand defineCommand(String userChoice) {
		String command = createCommand(userChoice);
		CreditCommandEnum currentCommand = CreditCommandEnum.valueOf(command);
		ActionCommand currentAction = currentCommand.getCurrentCommand();
		return currentAction;
	}

	private static String createCommand(String userChoice) {
		switch (userChoice) {
		case "1":
			return "ADD_CREDIT";
		case "2":
			return "ADD_PAYMENT";
		case "3":
			return "MIN_PAYMENT";
		case "4":
			return "PAYMENT_GRID";
		default:
			return "EXIT";
		}
	}
}
