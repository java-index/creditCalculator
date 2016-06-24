package com.software.bank.view;

import java.util.ResourceBundle;

public abstract class VisualAbstract implements IVisual {
	
	ResourceBundle resourceBundle;
	
	protected String getProperty(String key) {
		return resourceBundle.getString(key);
	}

	@Override
	public void messageContractNumber() {
		print(getProperty("msg.contract.number"));
	}
	
	@Override
	public void messageWelcome() {
		print(getProperty("msg.welcome"));
	}
	
	@Override
	public void messageBye() {
		print(getProperty("msg.bye"));
	}
	
	@Override
	public void showPaymentGrid(String[] list) {
		if (list != null && list.length > 0) {
			for (String item : list) {
				print(item);
			}
		} else {
			print("no payment date");
		}
	}

	@Override
	public void messageError() {
		print(getProperty("msg.error"));
	}
	
	@Override
	public void messageSuccess() {
		print(getProperty("msg.success"));
	}

	private void print(String value) {
		System.out.println(value);
	}
}