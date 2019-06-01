package com.apspdcl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apspdcl.model.Employee;
import com.apspdcl.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	public List<Employee> getEmployees() {
		return employeeRepository.findAll();
	}

	public Optional<Employee> getEmployeeById(int empid) {
		return employeeRepository.findById(empid);
	}

	public Employee addNewEmployee(Employee emp) {
		return employeeRepository.save(emp);
	}

	public Employee updateEmployee(Employee emp) {

		return employeeRepository.save(emp);
	}

	public void deleteEmployeeById(int empid) {

		employeeRepository.deleteById(empid);

	}

	public void deleteAllEmployees() {
		employeeRepository.deleteAll();

	}

}
