package com.software.bank;

import com.software.bank.controller.CreditController;

public class Launcher {

	public static void main(String[] args) {
		CreditController controller = new CreditController();
		controller.start();
	}
}