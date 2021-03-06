package com.chirram.springbootjpademo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.chirram.springbootjpademo.entity.Employee;

@RepositoryRestResource(path="employees")
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findAllByOrderByLastNameAsc();
}
