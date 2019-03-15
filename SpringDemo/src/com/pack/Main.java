package com.pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext f=new ClassPathXmlApplicationContext("hello.xml");
		HelloWorld hw=(HelloWorld)f.getBean("hello");
		System.out.println(hw.getMsg1()+" "+ hw.getMsg2());
		
		HelloIndia hi=(HelloIndia)f.getBean("hello1");
		System.out.println(hi.getMsg1()+" "+hi.getMsg2()+" "+hi.getMsg3());

	}

}
