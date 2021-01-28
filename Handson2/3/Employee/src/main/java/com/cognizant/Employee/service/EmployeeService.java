package com.cognizant.Employee.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.Employee.model.Employee;
import com.cognizant.Employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Transactional
	public Employee get(int id)
	{
		return employeeRepository.findById(id);	
		
	}
	
	@Transactional
	public void save(Employee employee)
	{
		employeeRepository.save(employee);	
		
	}

}
