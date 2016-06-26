package com.software.bank.controller;

import com.software.bank.service.ICreditLogic;
import com.software.bank.service.exception.ServiceException;

public interface ActionCommand {
	
	void execute(ICreditLogic creditLogic) throws ServiceException;
	
}