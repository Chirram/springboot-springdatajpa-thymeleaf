package com.chirram.springbootjpademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chirram.springbootjpademo.dao.EmployeeRepository;
import com.chirram.springbootjpademo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	@Override
	public List<Employee> findAll(){
		return employeeRepository.findAllByOrderByLastNameAsc();
	}

	@Override
	public Employee findById(int id) {
		Optional<Employee> result = employeeRepository.findById(id);
		
		Employee employee = null;
		if(result.isPresent()) {
			employee = result.get();
		}else {
			throw new RuntimeException("Couldn't find the given employee by id=" + id);
		}
		
		return employee;
	}
	
	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}
}
