package com.software.bank.view;

import java.util.Locale;
import java.util.ResourceBundle;

public class VisualRus extends VisualAbstract {
	
	public VisualRus() {
		resourceBundle = ResourceBundle.getBundle("messages_RU", Locale.US);	
	}
}