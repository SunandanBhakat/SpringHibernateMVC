package com.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext f=new ClassPathXmlApplicationContext("hello.xml");
		Profile p=(Profile)f.getBean("profile");
		p.showAge();
		p.showName();
		

	}

}
