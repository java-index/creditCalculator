package com.software.bank;

import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.dao.h2.CreditDataBaseDao;

public class Launcher {
	
	public static void main(String[] args)  {
	
		IDataBase dataBase = new CreditDataBaseDao();
		try {
			dataBase.addCredit("1", 100, 12, 2.5);
			long debet = dataBase.getDebet("1");
			long credit = dataBase.getCredit("1");
			System.out.println("Credit = " + credit);
			System.out.println("Debet = " + debet);
			dataBase.addPayment("1", 55);
			dataBase.addPayment("1", 55);
			debet = dataBase.getDebet("1");
			System.out.println("Debet = " + debet);
			double rate = dataBase.getRate("1");
			System.err.println(rate);
			System.out.println(dataBase.getTerm("1"));
		} catch (DaoException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
