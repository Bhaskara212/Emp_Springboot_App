package com.example.Springboot_application;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	EmployeeController empController;
	@Test
	void contextLoads() {
	}
	
	@Test
	void testSayHellomethod() {
		assertEquals("Hello world from sayhello() method",empController.sayHello());
	}
	
	@Test
	void testCreateEmployeemethod() {
		Employee emp = new Employee(103,"teja",10000);
		assertEquals(emp.getEmpId(), empController.createEmployee(emp).getEmpId());
	}
	

}
