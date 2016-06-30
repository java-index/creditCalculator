package com.software.bank.service;

public class CreditLogicManager {
	
	ICreditLogic annuity;
	
	ICreditLogic declining;
	
	ICreditLogic def;
	
	public ICreditLogic getCreditLogic(Repayment type){
		switch (type) {
		case ANNUITY:
			return annuity;
		case DECLINING:
			return declining;
		default:
			return def;
		}		
	}
	
	public ICreditLogic getCreditLogicDefault(){
		return def;
	}

	public ICreditLogic getAnnuity() {
		return annuity;
	}

	public void setAnnuity(ICreditLogic annuity) {
		this.annuity = annuity;
	}

	public ICreditLogic getDeclining() {
		return declining;
	}

	public void setDeclining(ICreditLogic declining) {
		this.declining = declining;
	}

	public ICreditLogic getDef() {
		return def;
	}

	public void setDef(ICreditLogic def) {
		this.def = def;
	}
}