package com.software.bank.controller.command;

import java.math.BigDecimal;
import java.math.RoundingMode;

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
		String contractNumber = CreditController.view.addPaymentContractView();
		
		ICreditLogic creditLogic = RepaymentTypeEnum.ANNUITY.getRepaymentMethod(); // at this point may be any
		Credit currentCredit = creditLogic.getCredit(contractNumber);
		if (currentCredit == null){
			CreditController.view.showContractNotFound();
			return;
		}
		
		// change to really repayment method
		creditLogic = currentCredit.getRepayment().getRepaymentMethod(); 
		
		// get min debit
		Debit minDebit = creditLogic.getMinPayment(currentCredit);
		
		// get user enter
		BigDecimal currentDebit = CreditController.view.addPaymentSummaView(minDebit.getMinDebit().setScale(2, RoundingMode.HALF_UP).toString());
		minDebit.setCurrentDebit(currentDebit);
		
		// save
		creditLogic.addPayment(minDebit);
		
		CreditController.view.showSuccess();
	}
}