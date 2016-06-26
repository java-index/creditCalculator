package com.software.bank.view;

public enum LanguageEnum {
	
	EN {
		{
			this.view = new VisualEng();
		}
	}, 
	
	UA {
		{
			this.view = new VisualUkr();
		}
	},
	
	RU {
		{
			this.view = new VisualRus();
		}
	};
	
	IVisual view;
	
	public IVisual getView(){
		return view;
	}
}
