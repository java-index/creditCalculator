package com.software.bank.controller.command;

import com.software.bank.controller.ActionCommand;
import com.software.bank.controller.CreditController;
import com.software.bank.service.ICreditLogic;
import com.software.bank.service.RepaymentTypeEnum;
import com.software.bank.service.exception.ServiceException;
import com.software.bank.service.model.Credit;
import com.software.bank.service.model.Debit;

public class AddPaymentCommand implements ActionCommand {

	@Override
	public void execute() throws ServiceException {
		Debit debit = CreditController.view.getDebitMenuView();
		
		ICreditLogic creditLogic = RepaymentTypeEnum.ANNUITY.getRepaymentMethod(); // at this point may be any
		Credit currentCredit = creditLogic.getCredit(debit.getContractNumber());
		if (currentCredit == null){
			CreditController.view.showContractNotFound();
			return;
		}
		creditLogic = currentCredit.getRepayment().getRepaymentMethod(); // change to really repayment method 
	}
}