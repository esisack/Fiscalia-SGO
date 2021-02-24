package com.srx.fiscalia.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.srx.fiscalia.app.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


}
