package com.software.bank.service;

public enum RepaymentTypeEnum {
	
	ANNUITY{
		{
			this.creditLogic = new Annuity();
		}
	}, 
	
	DECLINING_BALANCE{
		{
			this.creditLogic = new DecliningBalance();
		}
	};
	
	ICreditLogic creditLogic;
	
	public ICreditLogic getRepaymentMethod(){
		return creditLogic;
	}
}

