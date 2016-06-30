package com.software.bank.view;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

import com.software.bank.service.Repayment;
import com.software.bank.service.model.Credit;
import com.software.bank.view.input.ReadConsole;

public abstract class VisualAbstract implements IVisual {

	private ResourceBundle resourceBundle;
	
	private ReadConsole input;

	public ReadConsole getInput() {
		return input;
	}

	public void setInput(ReadConsole input) {
		this.input = input;
	}
	
	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	@Override
	public void setView(IVisual newView) {
	}
	
	@Override
	public String operationChoiceMenu() {
		printMessage(KeyMessage.SELECT_OPERATION);
		String choice = input.read();
		switch (choice) {
		case "1":
			return "CREDIT";
		case "2":
			return "DEBIT";
		default:
			return "EXIT";
		}
	}
	
	@Override
	public String languageChoiceMenu() {
		printMessage(KeyMessage.SELECT_LANGUAGE);
		String choice = input.read();
		switch (choice) {
		case "1":
			return "EN";
		case "2":
			return "UA";
		case "3":
			return "RU";
		default:
			return "CONTINUE";
		}
	}
	
	@Override
	public Credit addCreditMenu() {
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
		
		printMessage(KeyMessage.ENTER_REPAYMENT);
		int input = readInt(1, 2);
		
		switch (input) {
		case 1:
			credit.setRepayment(Repayment.ANNUITY);
			break;
		case 2:
			credit.setRepayment(Repayment.DECLINING);
			break;
		}
		
		return credit;
	}
	
	@Override
	public void paymentSchedule(String[] paymentSchedule) {
		printMessage(KeyMessage.PAYMENT_SCHEDULE);
		print("--------------------");
		for(int i = 0; i < paymentSchedule.length; i++){
			print(String.format("%-2s:%12s", i+1, paymentSchedule[i]));
		}
	}

	@Override
	public String enterContractNumber() {
		printMessage(KeyMessage.ENTER_CONTRACT_NUMBER);
		return input.read();
	}
	
	@Override
	public BigDecimal enterDebit(String minDebit){
		printMessage(KeyMessage.MIN_PAYMENT);
		printMessage(minDebit);
		printMessage(KeyMessage.ENTER_PAYMENT);
		double summaDebit = readDouble(Double.parseDouble(minDebit));
		return BigDecimal.valueOf(summaDebit);
	}
	
	@Override
	public void contractNotFound() {
		printMessage(KeyMessage.CONTRACT_NOT_FOUND);
	}
	
	@Override
	public void contractClosed() {
		printMessage(KeyMessage.CONTRACT_CLOSED);
	}
	
	@Override
	public void internalError() {
		printMessage(KeyMessage.INTERNAL_ERROR);
	}
	
	@Override
	public void contractIsExist() {
		printMessage(KeyMessage.CONTRACT_EXIST);
	}
	
	@Override
	public void success() {
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
	
	private int readInt(int min, int max){
		int value = 0;
		while (true){
			try{
				value = input.readInt();
				if (value < min || value > max){
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