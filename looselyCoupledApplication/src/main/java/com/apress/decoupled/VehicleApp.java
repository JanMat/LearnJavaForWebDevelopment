package com.apress.decoupled;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// Stand-Alone App
public class VehicleApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		VehicleService contestService = (VehicleService) context
				.getBean("vehicleService");
		contestService.driver();

		// doda�em poni�sz� lini� kodu aby wyeliminowa� komunikat Resource leak:
		// 'context' is never closed
		((AbstractApplicationContext) context).close();
	}
}
