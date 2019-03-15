package com.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext f=new ClassPathXmlApplicationContext("hello.xml");
		JavaCollection jc=(JavaCollection)f.getBean("collection");
		
		System.out.println(jc.getAddressList());
		System.out.println(jc.getAddressMap());
		System.out.println(jc.getAddressSet());
		System.out.println(jc.getAddressProp());

	}

}
