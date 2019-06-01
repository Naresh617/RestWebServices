package com.apspdcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apspdcl.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
