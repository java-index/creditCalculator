package com.software.bank.view.input;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadConsole {
	
	public String read() {
		Scanner scan = new Scanner(System.in);
		String value = scan.nextLine();
		return value;
	}
	
	public double readDouble() throws NoSuchElementException {
		Scanner scan = new Scanner(System.in);
		double value = scan.nextDouble();
		return value;
	}
	
	public int readInt() throws NoSuchElementException {
		Scanner scan = new Scanner(System.in);
		int value = scan.nextInt();
		return value;
	}
}