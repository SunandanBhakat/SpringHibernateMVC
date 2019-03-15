package com.pack;

//import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String args[])
	{
		/*Resource res=new ClassPathResource("hello.xml");
		BeanFactory f=new XmlBeanFactory(res);*/
		ApplicationContext f=new ClassPathXmlApplicationContext("hello.xml");
		 Student s=(Student)f.getBean("studentbean");//initiate setter injection
		 s.display();
	}
}
