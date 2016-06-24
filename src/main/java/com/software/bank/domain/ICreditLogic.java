package com.software.bank.domain;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.h2.CreditDataBaseDao;
import com.software.bank.input.IDataInput;
import com.software.bank.input.ReadConsole;
import com.software.bank.view.IVisual;
import com.software.bank.view.VisualEng;

public interface ICreditLogic {
	
	IDataBase dataBase = new CreditDataBaseDao();
	
	IVisual visual = new VisualEng();
	
	IDataInput input = new ReadConsole();
	
	void addCredit(String contractNumber, long summa_credit, int term, double rate);
	
	void addPayment(String contractNumber, long summa_debet);
	
	long getMinimalPayment(String contractNumber);
	
	String [] getPaymentGrid(String contractNumber);
}
