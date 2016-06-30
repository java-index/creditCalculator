package com.software.bank;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.software.bank.service.CreditLogicManager;
import com.software.bank.view.ViewManager;

public class Demo {

	public static void main(String[] args) {
		Application app = new Application();
		ApplicationContext ctx = new ClassPathXmlApplicationContext(new String[] { "spring/spring.xml" });
		CreditLogicManager logicManager = ctx.getBean("logicManager", CreditLogicManager.class);
		ViewManager viewManager = ctx.getBean("viewManager", ViewManager.class);
		app.setDefaultView(viewManager);
		while (true){
			app.languageSetProcess(viewManager);
			app.operationProcess(logicManager);
		}
	}
}