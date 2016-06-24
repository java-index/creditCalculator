package com.software.bank.view;

import java.io.UnsupportedEncodingException;
import java.util.ResourceBundle;

import org.h2.util.New;

public abstract class VisualAbstract implements IVisual {
	
	protected ResourceBundle resourceBundle;
	
	@Override
	public void printMessage(String message) {
		toConsole(message);
	}
	
	@Override
	public void printMessage(KeyMessage key) {
		toConsole(extractMessage(key));
	}
	
	private String extractMessage(KeyMessage key){
		String message = resourceBundle.getString(key.getKey());
		try {
			return new String(message.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return message;
		}
	}
	
	private void toConsole(String message){
		System.out.println(message);
	}
}