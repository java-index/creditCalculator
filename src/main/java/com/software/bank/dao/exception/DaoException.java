package com.software.bank.dao.exception;

public class DaoException extends Exception {
	
	public  DaoException(String message, Throwable e){
		super(message, e);
	}
	
	public  DaoException(Throwable e){
		super(e);
	}
}
