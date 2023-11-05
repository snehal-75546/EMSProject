package com.app.service;

import java.util.List;

import com.app.entities.Department;
import com.app.entities.Employee;

public interface EmployeeService {

	List<Employee> getAll();

	Employee getEmpDetailsById(Long empid);

	Employee addEmp(Employee newEmp);

	String deleteEmp(Long id);

	Employee update(Employee updEmp);

}
