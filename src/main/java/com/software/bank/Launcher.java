package com.software.bank;

import com.software.bank.controller.CreditController;
import com.software.bank.service.exception.ServiceException;

public class Launcher {

	public static void main(String[] args) throws ServiceException {

		CreditController controller = new CreditController();
		controller.launch();
	}
}