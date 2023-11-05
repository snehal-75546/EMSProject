package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.EmployeeDao;
import com.app.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao empDao;

	@Override
	public List<Employee> getAll() {
		
		return empDao.findAll();
	}

	@Override
	public Employee getEmpDetailsById(Long empid) {
		return null;
	}

	@Override
	public Employee addEmp(Employee newEmp) {
		return empDao.save(newEmp);
	}

	@Override
	public String deleteEmp(Long id) {
	Employee PersistentEmp=empDao.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Invalid Emp Id"));
			empDao.deleteById(id);			
		return "Employee Deleted successfully";
	}

	@Override
	public Employee update(Employee updEmp) {
		Employee PersistentEmp=empDao.findById(updEmp.getId())
				.orElseThrow(()->new ResourceNotFoundException("Invalid Emp Id"));
		return empDao.save(PersistentEmp);
	}

}
