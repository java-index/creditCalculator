package com.software.bank.controller.input;

import java.util.Scanner;

public class ReadConsole implements IDataInput {
	
	@Override
	public String read() {
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		return value;
	}
}