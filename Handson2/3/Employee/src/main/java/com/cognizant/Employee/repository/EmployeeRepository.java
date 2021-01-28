package com.cognizant.Employee.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.Employee.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Integer>{

	public Employee findById(int id);

}
