package com.software.bank;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import com.software.bank.controller.CreditController;
import com.software.bank.dao.IDataBase;
import com.software.bank.dao.exception.DaoException;
import com.software.bank.dao.h2.CreditDataBaseDao;
import com.software.bank.service.Annuity;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.RepaymentTypeEnum;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public class Launcher {

	public static void main(String[] args) throws ServiceException, DaoException {
		
		CreditController controller = new CreditController();
		controller.start();
	}
}