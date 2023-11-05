package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.custom_Exceptions.ResourceNotFoundException;
import com.app.dao.DepartmentDao;
import com.app.entities.Department;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentDao deptDao;

	@Override
	public List<Department> getAll() {
		
		return deptDao.findAll();
	}

	@Override
	public Department addDept(Department newDept) {
		//Department persistentDept=deptDao.save(newDept);
		return deptDao.save(newDept);
		
	}
	
	@Override
	public String deleteDept(Long id) {
		Department persistentDept=deptDao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!!!"));
		deptDao.deleteById(id);
		return "Department Deleted successfully";
	}

	@Override
	public Department update(Department updDept) {
		Department persistentDept=deptDao.findById(updDept.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!!!"));
				return deptDao.save(updDept);
	}

	@Override
	public Department getDeptDetailsById(Long deptid) {
		
		return deptDao.findById(deptid)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid Emp ID !!!!!"));
	}
	
	

}
