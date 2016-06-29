package com.software.bank.view;

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
		double summaCredit = readDouble(0);
		credit.setTotalCredit(BigDecimal.valueOf(summaCredit));
		
		printMessage(KeyMessage.ENTER_RATE);
		double rate = readDouble(0);
		credit.setRate(BigDecimal.valueOf(rate));
		
		printMessage(KeyMessage.ENTER_TERM);
		credit.setTerm(readInt());
		
		return credit;
	}
	
	@Override
	public void showPaymentSchedule(String[] paymentSchedule) {
		printMessage(KeyMessage.PAYMENT_SCHEDULE);
		print("--------------------");
		for(int i = 0; i < paymentSchedule.length; i++){
			print(String.format("%-2s:%12s", i+1, paymentSchedule[i]));
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
		double summaDebit = readDouble(Double.parseDouble(minDebit));
		return BigDecimal.valueOf(summaDebit);
	}
	
	@Override
	public void showContractNotFound() {
		printMessage(KeyMessage.CONTRACT_NOT_FOUND);
	}
	
	@Override
	public void showContractClosed() {
		printMessage(KeyMessage.CONTRACT_CLOSED);
	}
	
	@Override
	public void showInternalError() {
		printMessage(KeyMessage.INTERNAL_ERROR);
	}
	
	@Override
	public void showContractIsExist() {
		printMessage(KeyMessage.CONTRACT_EXIST);
	}
	
	@Override
	public void showSuccess() {
		print("------------------");
		printMessage(KeyMessage.SUCCESS);
		print("------------------");
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
	
	private void printMessage(KeyMessage key) {
		print(extractMessage(key));
	}
	
	private void printMessage(String message) {
		print(message);
	}
	
	private void print(String message) {
		System.out.println(message);
	}
	
	private double readDouble(double setMinValue){
		double value = 0;
		while (true){
			try{
				value = input.readDouble();
				if (value < setMinValue){
					throw new IllegalArgumentException();
				}
				break;
			} catch (NoSuchElementException e) {
				printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			} catch (IllegalArgumentException e) {
				printMessage(KeyMessage.INPUT_LESS_THAN_VALUE);
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
				if (value < 0){
					throw new IllegalArgumentException();
				}
				break;
			} catch (IllegalArgumentException | NoSuchElementException e) {
				printMessage(KeyMessage.INPUT_PARAMETR_ERROR);
				continue;
			}
		}
		return value;
	}
}