package com.software.bank.controller.input;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadConsole implements IDataInput {
	
	@Override
	public String read() {
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		return value;
	}
	
	@Override
	public double readDouble() throws NoSuchElementException {
		Scanner scan = new Scanner(System.in);
		double value = scan.nextDouble();
		return value;
	}
	
	@Override
	public int readInt() throws NoSuchElementException {
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		return value;
	}
}