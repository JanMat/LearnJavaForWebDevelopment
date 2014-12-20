package com.apress.aop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {

	
	    public static void main(String...args){
	        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	 
	        BookService bookService = (BookService)context.getBean("bookService");
	        bookService.getAllBooks();
	        
	     // doda�em poni�sz� lini� kodu aby wyeliminowa� komunikat Resource leak:
			// 'context' is never closed
		((AbstractApplicationContext) context).close();
	        
	    }

}
