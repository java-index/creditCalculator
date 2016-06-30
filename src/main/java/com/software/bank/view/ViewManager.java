package com.software.bank.view;

public class ViewManager {
	
	IVisual en;
	
	IVisual ua;
	
	IVisual ru;
	
	IVisual def;
	
	public IVisual getView(String lang){
		switch (lang) {
		case "EN":
			return en;
		case "UA":
			return ua;
		case "RU":
			return ru;
		default:
			return def;
		}		
	}
	
	public IVisual defaultView(){
		return def;
	}
	
	public IVisual getEn() {
		return en;
	}
	
	public void setEn(IVisual en) {
		this.en = en;
	}
	
	public IVisual getUa() {
		return ua;
	}
	
	public void setUa(IVisual ua) {
		this.ua = ua;
	}
	
	public IVisual getRu() {
		return ru;
	}
	
	public void setRu(IVisual ru) {
		this.ru = ru;
	}

	public IVisual getDef() {
		return def;
	}

	public void setDef(IVisual def) {
		this.def = def;
	}
}
