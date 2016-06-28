package com.software.bank.view;

import java.math.BigDecimal;

import com.software.bank.service.model.Credit;

public class VisualManager implements IVisual {
	
	private IVisual view;
		
	public IVisual getView() {
		return view;
	}

	public void setView(IVisual view) {
		this.view = view;
	}

	@Override
	public void printMessage(KeyMessage key) {
		view.printMessage(key);
	}

	@Override
	public void printMessage(String mesage) {
		view.printMessage(mesage);
	}

	@Override
	public String operationChoiceMenuView() {
		return view.operationChoiceMenuView();
	}

	@Override
	public Credit addCreditMenuView() {
		return view.addCreditMenuView();
	}

	@Override
	public String addPaymentContractView() {
		return view.addPaymentContractView();
	}

	@Override
	public void showPaymentSchedule(String[] paymentSchedule) {
		view.showPaymentSchedule(paymentSchedule);
	}

	@Override
	public BigDecimal addPaymentSummaView(String minDebit) {
		return view.addPaymentSummaView(minDebit);
	}

	@Override
	public void showContractNotFound() {
		view.showContractNotFound();
	}

	@Override
	public void showInternalError() {
		view.showInternalError();		
	}

	@Override
	public void showSuccess() {
		view.showSuccess();
	}

	@Override
	public void bye() {
		view.bye();
	}
}
