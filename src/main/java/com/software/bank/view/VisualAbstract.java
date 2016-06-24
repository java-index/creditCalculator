package com.software.bank.view;

import java.util.ResourceBundle;

public abstract class VisualAbstract implements IVisual {
	
	static ResourceBundle resourceBundle;
	
	protected String getProperty(String key) {
		return resourceBundle.getString(key);
	}

	@Override
	public void mesasageContractNumber() {
	}
	
	@Override
	public void messageWelcome() {
		
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
		print("Error");
	}

	private void print(String value) {
		System.out.println(value);
	}
	

}