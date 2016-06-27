package com.software.bank.service;

import java.math.BigDecimal;

import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public class DecliningBalance extends CreditAbstract {

	@Override
	public void addPayment(String contractNumber, BigDecimal summaDedit) throws ServiceException {
	}

	@Override
	public String getMinPayment(Credit credit) {
		
		return "kukuku";
	}
}