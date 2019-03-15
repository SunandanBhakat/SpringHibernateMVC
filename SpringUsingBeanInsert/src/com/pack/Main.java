package com.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context=new ClassPathXmlApplicationContext("hello.xml");
		TextEditor textEditor =(TextEditor)context.getBean("text");
		textEditor.test();
		

	}

}
