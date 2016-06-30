package com.software.bank.view;

import java.math.BigDecimal;

import com.software.bank.service.model.Credit;

public class VisualGeneral implements IVisual {

	private IVisual view;
	
	public void setView(IVisual newView) {
		this.view = newView;
	}
	
	@Override
	public String languageChoiceMenu() {
		return view.languageChoiceMenu();
	}
	
	@Override
	public String operationChoiceMenu() {
		return view.operationChoiceMenu();
	}

	@Override
	public Credit addCreditMenu() {
		return view.addCreditMenu();
	}

	@Override
	public String enterContractNumber() {
		return view.enterContractNumber();
	}

	@Override
	public void paymentSchedule(String[] paymentSchedule) {
		view.paymentSchedule(paymentSchedule);
	}

	@Override
	public BigDecimal enterDebit(String minDebit) {
		return view.enterDebit(minDebit);
	}

	@Override
	public void contractClosed() {
		view.contractClosed();
	}

	@Override
	public void contractNotFound() {
		view.contractNotFound();
	}

	@Override
	public void contractIsExist() {
		view.contractIsExist();
	}

	@Override
	public void internalError() {
		view.internalError();
	}

	@Override
	public void success() {
		view.success();
	}

	@Override
	public void bye() {
		view.bye();
	}
}