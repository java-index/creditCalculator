package com.software.bank.view;

public abstract class VisualAbstract implements IVisual {
	
	public void mesasageContractNumber() {

	}

	public void messageWelcome() {

	}

	public void showPaymentGrid(String[] list) {
		if (list != null && list.length > 0) {
			for (String item : list) {
				print(item);
			}
		} else {
			print("empty");
		}
	}
	
	private void print(String value){
		System.out.println(value);
	}
}
