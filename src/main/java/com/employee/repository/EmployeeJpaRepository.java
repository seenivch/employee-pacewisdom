package com.employee.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.employee.model.Employee;


/**
 * @author Seenivasan Chandrasekaran
 */
@Repository
public interface EmployeeJpaRepository extends CrudRepository<Employee, String> {
	
	
}