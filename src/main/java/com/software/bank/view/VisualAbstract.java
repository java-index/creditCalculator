package com.software.bank.view;

import java.awt.RenderingHints.Key;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import com.software.bank.service.model.Credit;
import com.software.bank.view.input.ReadConsole;

public abstract class VisualAbstract implements IVisual {

	protected ResourceBundle resourceBundle;
	
	private ReadConsole input;

	public ReadConsole getInput() {
		return input;
	}

	public void setInput(ReadConsole input) {
		this.input = input;
	}

	@Override
	public void printMessage(KeyMessage key) {
		print(extractMessage(key));
	}
	
	@Override
	public void printMessage(String message) {
		print(message);
	}

	@Override
	public String operationChoiceMenuView() {
		printMessage(KeyMessage.SELECT_OPERATION);
		String choice = input.read();
		return choice;
	}
	
	@Override
	public Credit addCreditMenuView() {
		Credit credit = new Credit();
		
		printMessage(KeyMessage.ENTER_CONTRACT_NUMBER);
		credit.setContractNumber(input.read());
		
		printMessage(KeyMessage.ENTER_CREDIT);
		double summaCredit = readDouble();
		credit.setTotalCredit(BigDecimal.valueOf(summaCredit));
		
		printMessage(KeyMessage.ENTER_RATE);
		double rate = readDouble();
		credit.setRate(BigDecimal.valueOf(rate));
		
		printMessage(KeyMessage.ENTER_TERM);
		credit.setTerm(readInt());
		
		return credit;
	}
	
	@Override
	public void showPaymentSchedule(String[] paymentSchedule) {
		printMessage(KeyMessage.PAYMENT_SCHEDULE);
		for(String s : paymentSchedule){
			print(s);
		}
	}

	@Override
	public String addPaymentContractView() {
		printMessage(KeyMessage.ENTER_CONTRACT_NUMBER);
		return input.read();
	}
	
	@Override
	public BigDecimal addPaymentSummaView(String minDebit){
		printMessage(KeyMessage.MIN_PAYMENT);
		printMessage(minDebit);
		printMessage(KeyMessage.ENTER_PAYMENT);
		double summaDebit = readDouble();
		return BigDecimal.valueOf(summaDebit);
	}
	
	@Override
	public void showContractNotFound() {
		printMessage(KeyMessage.CONTRACT_NOT_FOUND);
	}
	
	@Override
	public void showInternalError() {
		printMessage(KeyMessage.INTERNAL_ERROR);
	}
	
	@Override
	public void showSuccess() {
		printMessage(KeyMessage.SUCCESS);
		printMessage("--------------------\n");
	}
	
	@Override
	public void bye() {
		printMessage(KeyMessage.BYE);
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
				value = input.readDouble();
				break;
			} catch (NoSuchElementException e) {
				printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
		return value;
	}
	
	private int readInt(){
		int value = 0;
		while (true){
			try{
				value = input.readInt();
				break;
			} catch (NoSuchElementException e) {
				printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
		return value;
	}
}