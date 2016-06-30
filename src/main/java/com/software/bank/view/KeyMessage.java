package com.software.bank.view;

public enum KeyMessage {
	
	SELECT_REPAYMENT("msg.select.repayment"), 
	
	SELECT_LANGUAGE("msg.select.language"), 
	
	SELECT_OPERATION("msg.select.operation"), 

	ENTER_CONTRACT_NUMBER("msg.contract.number"),
	
	ENTER_PAYMENT("msg.add.payment"),
	
	ENTER_CREDIT("msg.add.credit"),
	
	ENTER_RATE("msg.add.rate"),
	
	ENTER_TERM("msg.add.term"),
	
	ENTER_REPAYMENT("msg.select.repayment"),
	
	MIN_PAYMENT("msg.min.payment"),
	
	SUCCESS("msg.success"),
	
	BYE("msg.bye"),
	
	INPUT_PARAMETR_ERROR("msg.input.error"),
	
	INTERNAL_ERROR("msg.internal.error"),
	
	CONTRACT_NOT_FOUND("msg.contract.notfound"),
	
	PAYMENT_SCHEDULE("msg.payment.schedule"),
	
	CONTRACT_CLOSED("msg.contract.closed"),
	
	CONTRACT_EXIST("msg.contract.exist"),
	
	INPUT_LESS_THAN_VALUE("msg.input.error.less");
	
	private String key;

	KeyMessage(String key) {
		this.key = key;
	}

	String getKey() {
		return key;
	}
}