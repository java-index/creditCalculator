package com.software.bank.controller;

import com.software.bank.controller.input.IDataInput;
import com.software.bank.controller.input.ReadConsole;
import com.software.bank.service.ICreditLogic;
import com.software.bank.view.IVisual;
import com.software.bank.view.KeyMessage;
import com.software.bank.view.VisualEng;
import com.software.bank.view.VisualRus;
import com.software.bank.view.VisualUkr;

public class CreditController {

	private IVisual view = new VisualEng();
	private IDataInput input = new ReadConsole();
	private ICreditLogic creditLogic;

	public void start() {
		selectLanguage();
		selectOperation();
	}

	// 1-EN 2-UA 3-RU
	private void selectLanguage() {
		print(KeyMessage.SELECT_LANGUAGE);
		while (true) {
			String choice = input.read();
			if ("1".equals(choice)) {
				break;
			} else if ("2".equals(choice)) {
				view = new VisualUkr();
				break;
			} else if ("3".equals(choice)) {
				view = new VisualRus();
				break;
			} else {
				print(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
	}

	private void selectOperation() {
		print(KeyMessage.SELECT_OPERATION);
		String choice = input.read();
		if ("1".equals(choice)) {
			
		} else if ("2".equals(choice)) {

		} else if ("3".equals(choice)) {

		} else if ("4".equals(choice)) {

		} else {
			exit();
		}
	}

	private void selectTypeCredit() {
		print(KeyMessage.SELECT_LANGUAGE);
		String choice = input.read();
		if ("1".equals(choice)) {
		
		} else if ("2".equals(choice)) {
		
		} else {
			exit();
		}
	}

	private void print(KeyMessage key) {
		view.printMessage(key);
	}

	private void exit(){
		print(KeyMessage.BYE);
		System.exit(0);
	}
	}