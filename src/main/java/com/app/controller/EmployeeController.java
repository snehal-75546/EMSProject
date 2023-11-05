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
import com.app.entities.Employee;
import com.app.service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	@Autowired
	private EmployeeService empService;
	
	@GetMapping
	public List<Employee> allEmployees(){
		return empService.getAll();
	}
	
	@GetMapping("/{Empid}")
	public Employee getDeptDetails(@PathVariable Long Empid) {
		return empService.getEmpDetailsById(Empid);
	}
	
	@PostMapping
	public Employee addDepartment(@RequestBody Employee newEmp) {
		return empService.addEmp(newEmp);
	}
	
	@DeleteMapping("/{id}")
	public String deletEmp(@PathVariable Long id) {
		return empService.deleteEmp(id);
	}
	
	@PutMapping
	public Employee updateDept(@RequestBody Employee UpdEmp) {
		return empService.update(UpdEmp);
	}

}
