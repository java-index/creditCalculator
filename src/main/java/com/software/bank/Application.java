package com.software.bank;

import java.math.BigDecimal;

import com.software.bank.service.CreditLogicManager;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;
import com.software.bank.view.IVisual;
import com.software.bank.view.ViewManager;

public class Application {

	public void operationProcess(CreditLogicManager logicManager) {
		String operation = ICreditLogic.view.operationChoiceMenu();
		try {
			if ("CREDIT".equals(operation)) {
				addCreditProcess(logicManager);
			} else if ("DEBIT".equals(operation)) {
				addDebitProcess(logicManager);
			} else {
				exit();
			}
		} catch (ServiceException e) {
			ICreditLogic.view.internalError();
		}
	}

	private void addCreditProcess(CreditLogicManager logicManager) throws ServiceException {
		Credit credit = ICreditLogic.view.addCreditMenu(); // get credit data
															// from user
		ICreditLogic creditLogic = getCreditLogic(credit, logicManager);
		boolean contractExist = isContractExist(credit.getContractNumber(), creditLogic);
		if (contractExist) {
			ICreditLogic.view.contractIsExist();
			return;
		}
		String[] paymentSchedule = creditLogic.addCredit(credit);
		ICreditLogic.view.paymentSchedule(paymentSchedule);
		messageSucces();
	}

	public void addDebitProcess(CreditLogicManager logicManager) throws ServiceException {
		String contractNumber = ICreditLogic.view.enterContractNumber(); // get contract number from user
		Credit credit = logicManager.getCreditLogicDefault().getCredit(contractNumber);
		if (isContractNotFound(credit) || isContractClosed(credit)) {
			return;
		}
		BigDecimal minRequiredDebit = ICreditLogic.view.enterDebit(credit.getMinRequiredDebit().toString());
		credit.setMinRequiredDebit(minRequiredDebit);
		ICreditLogic logic = getCreditLogic(credit, logicManager);
		logic.addDebit(credit);
		messageSucces();
	}

	public void languageSetProcess(ViewManager viewSwitch) {
		String language = ICreditLogic.view.languageChoiceMenu();
		if ("EXIT".equals(language)) {
			exit();
		}
		IVisual view = viewSwitch.getView(language);
		setView(view);
	}

	public void setDefaultView(ViewManager viewSwitch) {
		setView(viewSwitch.defaultView());
	}

	private void setView(IVisual view) {
		ICreditLogic.view.setView(view);
	}

	private ICreditLogic getCreditLogic(Credit credit, CreditLogicManager logicManager) {
		return logicManager.getCreditLogic(credit.getRepayment());
	}

	private boolean isContractExist(String contractNumber, ICreditLogic logic) throws ServiceException {
		if (logic.getCredit(contractNumber) != null) {
			return true;
		}
		return false;
	}

	private boolean isContractNotFound(Credit credit) {
		if (credit == null) {
			ICreditLogic.view.contractNotFound();
			return true;
		}
		return false;
	}

	private boolean isContractClosed(Credit credit) {
		if (credit.getTerm() == credit.getQtyPayments()) {
			ICreditLogic.view.contractClosed();
			return true;
		}
		return false;
	}

	private void messageSucces() {
		ICreditLogic.view.success();
	}

	private void exit() {
		ICreditLogic.view.bye();
		System.exit(0);
	}
}