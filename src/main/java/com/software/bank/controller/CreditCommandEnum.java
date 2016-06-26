package com.software.bank.controller;

import com.software.bank.controller.command.AddCreditCommand;
import com.software.bank.controller.command.AddPaymentCommand;
import com.software.bank.controller.command.ExitCommand;
import com.software.bank.controller.command.language.ViewEnCommand;
import com.software.bank.controller.command.language.ViewRuCommand;
import com.software.bank.controller.command.language.ViewUaCommand;

public enum CreditCommandEnum {

	SET_LANGUAGE_EN {
		{
			this.command = new ViewEnCommand();
		}
	},
	
	SET_LANGUAGE_UA {
		{
			this.command = new ViewUaCommand();
		}
	},
	
	SET_LANGUAGE_RU {
		{
			this.command = new ViewRuCommand();
		}
	},
	
	ADD_CREDIT {
		{
			this.command = new AddCreditCommand();
		}
	},

	ADD_PAYMENT {
		{
			this.command = new AddPaymentCommand();
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