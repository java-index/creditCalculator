package com.software.bank.input;

import java.util.Scanner;

public class ReadConsole implements IInput {
	
	@Override
	public String read() {
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		scan.close();
		return value;
	}
}