package com.software.bank.domain.model;

public class Contract {
	
	private String contartNumber;
	
	private int term;
	
	private long credit;
	
	private long debet;

	public String getContartNumber() {
		return contartNumber;
	}

	public void setContartNumber(String contartNumber) {
		this.contartNumber = contartNumber;
	}

	public int getTerm() {
		return term;
	}

	public void setTerm(int term) {
		this.term = term;
	}

	public long getCredit() {
		return credit;
	}

	public void setCredit(long credit) {
		this.credit = credit;
	}

	public long getDebet() {
		return debet;
	}

	public void setDebet(long debet) {
		this.debet = debet;
	}
}