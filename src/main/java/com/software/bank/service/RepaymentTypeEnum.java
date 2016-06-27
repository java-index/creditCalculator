package com.software.bank.service;

public enum RepaymentTypeEnum {

	// don't change position of the ENUM, it's impotent!!!
    //  1 - ANNUITY, 2 - DECLINING_BALANCE
	
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