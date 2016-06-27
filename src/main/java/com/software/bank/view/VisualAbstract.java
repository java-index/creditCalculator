package com.software.bank.view;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import com.software.bank.controller.CreditController;
import com.software.bank.service.RepaymentTypeEnum;
import com.software.bank.service.model.Credit;

public abstract class VisualAbstract implements IVisual {

	protected ResourceBundle resourceBundle;

	@Override
	public void printMessage(KeyMessage key) {
		print(extractMessage(key));
	}
	
	@Override
	public void printMessage(String message) {
		print(message);
	}

	@Override
	public String languageChoiceMenuView() {
		String idMenu = "_lang";
		CreditController.view.printMessage(KeyMessage.SELECT_LANGUAGE);
		String choice = CreditController.input.read();
		return choice + idMenu;
	}
	
	@Override
	public String operationChoiceMenuView() {
		String idMenu = "_oper";
		CreditController.view.printMessage(KeyMessage.SELECT_OPERATION);
		String choice = CreditController.input.read();
		return choice + idMenu;
	}
	
	@Override
	public Credit addCreditMenuView() {
		Credit credit = new Credit();
		
		CreditController.view.printMessage(KeyMessage.ENTER_CONTRACT_NUMBER);
		credit.setContractNumber(CreditController.input.read());
		
		CreditController.view.printMessage(KeyMessage.ENTER_CREDIT);
		double summaCredit = readDouble();
		credit.setTotalCredit(BigDecimal.valueOf(summaCredit));
		
		CreditController.view.printMessage(KeyMessage.ENTER_RATE);
		double rate = readDouble();
		credit.setRate(BigDecimal.valueOf(rate));
		
		CreditController.view.printMessage(KeyMessage.ENTER_TERM);
		credit.setTerm(readInt());
		
		CreditController.view.printMessage(KeyMessage.SELECT_REPAYMENT);
		int repayment = readInt(1, 2);
		credit.setRepayment(RepaymentTypeEnum.values()[repayment-1]);
		
		return credit;
	}
	
	@Override
	public void showPaymentSchedule(String[] paymentSchedule) {
		CreditController.view.printMessage(KeyMessage.PAYMENT_SCHEDULE);
		for(String s : paymentSchedule){
			print(s);
		}
	}

	@Override
	public String addPaymentContractView() {
		CreditController.view.printMessage(KeyMessage.ENTER_CONTRACT_NUMBER);
		return CreditController.input.read();
	}
	
	@Override
	public BigDecimal addPaymentSummaView(String minDebit){
		CreditController.view.printMessage(KeyMessage.MIN_PAYMENT);
		CreditController.view.printMessage(minDebit);
		CreditController.view.printMessage(KeyMessage.ENTER_PAYMENT);
		double summaDebit = readDouble();
		return BigDecimal.valueOf(summaDebit);
	}
	
	@Override
	public void showContractNotFound() {
		CreditController.view.printMessage(KeyMessage.CONTRACT_NOT_FOUND);
	}
	
	@Override
	public void showInternalError() {
		CreditController.view.printMessage(KeyMessage.INTERNAL_ERROR);
	}
	
	@Override
	public void showSuccess() {
		CreditController.view.printMessage(KeyMessage.SUCCESS);
		print("--------------------\n");
	}
	
	@Override
	public void bye() {
		CreditController.view.printMessage(KeyMessage.BYE);
	}
	
	private String extractMessage(KeyMessage key) {
		String message = resourceBundle.getString(key.getKey());
		try {
			return new String(message.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return message;
		}
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	private double readDouble(){
		double value = 0;
		while (true){
			try{
				value = CreditController.input.readDouble();
				break;
			} catch (NoSuchElementException e) {
				CreditController.view.printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
		return value;
	}
	
	private int readInt(){
		int value = 0;
		while (true){
			try{
				value = CreditController.input.readInt();
				break;
			} catch (NoSuchElementException e) {
				CreditController.view.printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
		return value;
	}
	
	private int readInt(int min, int max){
		while (true){
			try{
				int value = CreditController.input.readInt();
				if(value >= min && value <= max){
					return value;
				} else {
					throw new NoSuchElementException();
				}
			} catch (NoSuchElementException e) {
				CreditController.view.printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
	}
}