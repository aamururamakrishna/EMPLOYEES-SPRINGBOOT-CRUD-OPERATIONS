package com.company.employees.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.employees.models.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
