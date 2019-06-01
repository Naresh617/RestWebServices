package com.apspdcl.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apspdcl.exception.EmployeeException;
import com.apspdcl.model.Employee;
import com.apspdcl.service.EmployeeService;

@RestController
@CrossOrigin
public class EmployeeController {
	@Autowired
	EmployeeService service;

	// getting all employees from database
	@GetMapping(value = "/employee/all")
	public List<Employee> getEmployees() {
		return service.getEmployees();
	}

	@GetMapping(value = "/employee/{id}")
	public Employee getEmployeeById(@PathVariable int id) throws EmployeeException {
		Optional<Employee> emp = service.getEmployeeById(id);
		if (!emp.isPresent()) {
			throw new EmployeeException("Could not find employee with id" + id);
		}

		return emp.get();
	}

	@PostMapping(value = "/employee/add")
	public Employee createEmployee(@RequestBody Employee employee) {
		return service.addNewEmployee(employee);
	}

	@PutMapping(value = "/employee/update/{id}")
	public Employee employeeloyee(@RequestBody Employee employee, @PathVariable int id) throws EmployeeException {
		Optional<Employee> emp1 = service.getEmployeeById(id);
		if (!emp1.isPresent()) {
			throw new EmployeeException("Could not find employee with id" + id);
		}
		if (employee.getName() == null || employee.getName().isEmpty()) {
			employee.setName(emp1.get().getName());
		}
		if (employee.getDepartment() == null || employee.getDepartment().isEmpty()) {
			employee.setDepartment(emp1.get().getDepartment());
		}
		if (employee.getSalary() == 0) {
			employee.setSalary(emp1.get().getSalary());
		}

		employee.setId(id);

		return service.updateEmployee(employee);

	}
	
	@DeleteMapping(value="/employee/delete/{id}")
	public  void deleteEmployeeById(@PathVariable int id) throws EmployeeException
	{
		Optional<Employee> emp=service.getEmployeeById(id);
		if(!emp.isPresent())
		{
			throw new EmployeeException("Could not find employee with id"+id);
		}
		service.deleteEmployeeById(id);
		
	}
	@DeleteMapping(value="/employee/deleteall/")
	public void deleteAll()
	{
		service.deleteAllEmployees();
	}

}
