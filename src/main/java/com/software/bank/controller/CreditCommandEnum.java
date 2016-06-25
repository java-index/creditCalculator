package com.software.bank.controller;

import com.software.bank.controller.operation.AddCredit;
import com.software.bank.controller.operation.AddPayment;
import com.software.bank.controller.operation.Exit;
import com.software.bank.controller.operation.MinPayment;
import com.software.bank.controller.operation.PaymentGrid;

public enum CreditCommandEnum {

	ADD_CREDIT {
		{
			this.command = new AddCredit();
		}
	},

	ADD_PAYMENT {
		{
			this.command = new AddPayment();
		}
	},
	
	MIN_PAYMENT {
		{
			this.command = new MinPayment();
		}
	},
	
	PAYMENT_GRID {
		{
			this.command = new PaymentGrid();
		}
	},

	EXIT {
		{
			this.command = new Exit();
		}
	};

	ActionCommand command;

	public ActionCommand getCurrentCommand() {
		return command;
	}
}