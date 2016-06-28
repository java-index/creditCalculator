package com.software.bank.controller;

import com.software.bank.controller.command.AddCreditCommand;
import com.software.bank.controller.command.AddDebitCommand;
import com.software.bank.controller.command.ExitCommand;

public enum CreditCommandEnum {

	ADD_CREDIT {
		{
			this.command = new AddCreditCommand();
		}
	},

	ADD_DEBIT {
		{
			this.command = new AddDebitCommand();
		}
	},
	

	EXIT {
		{
			this.command = new ExitCommand();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}