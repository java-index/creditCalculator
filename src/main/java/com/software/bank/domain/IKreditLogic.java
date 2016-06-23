package com.software.bank.domain;

import com.software.bank.dao.IDataBase;
import com.software.bank.view.IVisual;

public interface IKreditLogic {
	IDataBase dataBase = null;
	IVisual visual = null;
	void addCredit(int time, String contactNumber);
	void getDebet(String contactNumber);
}
