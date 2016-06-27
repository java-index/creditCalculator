package com.software.bank.controller.command;

import java.math.BigDecimal;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.RepaymentTypeEnum;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;

public class AddPaymentCommand implements ActionCommand {

	@Override
	public void execute() throws ServiceException {
		String contractNumber = CreditController.view.addPaymentContractView();
		
		ICreditLogic creditLogic = RepaymentTypeEnum.ANNUITY.getRepaymentMethod(); // at this point may be any
		Credit currentCredit = creditLogic.getCredit(contractNumber);
		if (currentCredit == null){
			CreditController.view.showContractNotFound();
			return;
		}
		creditLogic = currentCredit.getRepayment().getRepaymentMethod(); // change to really repayment method
		String minDebit = creditLogic.getMinPayment(currentCredit);
		
		BigDecimal summaDebit = CreditController.view.addDebitPaymentview(minDebit);
		summaDebit = summaDebit.add(currentCredit.getSummaDebit());
		creditLogic.addPayment(contractNumber, summaDebit);
	}
}