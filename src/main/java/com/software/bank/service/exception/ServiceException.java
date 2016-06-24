package com.software.bank.service.exception;

public class ServiceException extends Exception {
	
	public ServiceException(String message, Throwable e){
		super(message, e);
	}
	
	public  ServiceException(Throwable e){
		super(e);
	}
}