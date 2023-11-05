package com.app.service;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import com.app.entities.Department;

public interface DepartmentService {

	public List<Department> getAll();

	
	public Department addDept(Department newDept);

	public String deleteDept(Long id);


	public Department update(Department updDept);


	public Department getDeptDetailsById(Long deptid);
}
