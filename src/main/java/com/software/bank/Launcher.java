package com.software.bank;

import com.software.bank.domain.Annuity;
import com.software.bank.domain.ICreditLogic;

public class Launcher {

	public static void main(String[] args) {
		ICreditLogic creditLogic = new Annuity();
		ICreditLogic.visual.messageWelcome();
		String menuItem = ICreditLogic.input.read();
		if (menuItem.equals("1")) {
			System.err.println("add credit");
		} else if (menuItem.equals("2")) {
			System.out.println("add payment");
		} else if (menuItem.equals("3")) {
			System.out.println("minimal payment");
		} else if (menuItem.equals("4")) {
			System.out.println("grid payment");
		} else {
			ICreditLogic.visual.messageBye();
		}
	}
}