package com.software.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.software.bank.controller.CreditController;
import com.software.bank.service.exception.ServiceException;

public class Launcher {

	public static void main(String[] args) throws ServiceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] {"spring/spring.xml"});
        CreditController controller = ctx.getBean("creditDecliningBalance", CreditController.class);
        //CreditController controller = ctx.getBean("creditAnnuity", CreditController.class);
        
		while(true){
			controller.choiceOperation();
		}
	}
}