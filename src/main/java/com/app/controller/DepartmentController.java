package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Department;
import com.app.service.DepartmentService;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    
	@Autowired
	private DepartmentService deptService;
	
	@GetMapping
	public List<Department> allDepsrtments(){
		return deptService.getAll();
	}
	
	@GetMapping("/{Deptid}")
	public Department getDeptDetails(@PathVariable Long Deptid) {
		return deptService.getDeptDetailsById(Deptid);
	}
	
	@PostMapping
	public Department addDepartment(@RequestBody Department newDept) {
		return deptService.addDept(newDept);
	}
	
	@DeleteMapping("/{id}")
	public String deletDept(@PathVariable Long id) {
		return deptService.deleteDept(id);
	}
	
	@PutMapping
	public Department updateDept(@RequestBody Department UpdDept) {
		return deptService.update(UpdDept);
	}
}
