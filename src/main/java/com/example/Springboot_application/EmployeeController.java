package com.example.Springboot_application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository empRepository;
	
	@GetMapping("/sayHello")
	public String sayHello() {
		return "Hello world from sayhello() method";
		
	}
	@GetMapping("/regEmp")
	public Employee registerEmployee() {
		Employee emp = new Employee(101,"bhaskar",10000);
		Employee savedEmp = empRepository.save(emp);
		//return " Employee " + savedEmp.getEmpName() + " stored in the database ";
		return savedEmp;
	}
	@GetMapping("/getEmp")
	public String getEmployee() {
		Employee emp = empRepository.findById(101).get();
		return emp.getEmpName() + "|" + emp.getSalary();
	}

	@PostMapping("/createEmp")
	public Employee createEmployee(@RequestBody Employee emp) {
	return empRepository.save(emp);
	}
	
	@GetMapping("/getEmp/{empId}")
	public Employee getEmployeeDetails(@PathVariable(value="empId")int empId) {
	return empRepository.findById(empId).get();
	}
	
	
	
	
	
	
	
}
