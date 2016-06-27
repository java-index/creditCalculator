package com.software.bank;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.software.bank.controller.CreditController;
import com.software.bank.service.exception.ServiceException;

public class Launcher {

	public static void main(String[] args) throws ServiceException {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring/spring.xml"});
        CreditController controller = ctx.getBean("creditController", CreditController.class);
        
        controller.selectLanguage();
		while(true){
			controller.selectOperation();
		}
	}
}