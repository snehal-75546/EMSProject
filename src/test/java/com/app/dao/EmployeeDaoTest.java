package com.app.dao;



import java.sql.Timestamp;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.app.entities.Department;
import com.app.entities.Employee;

@DataJpaTest //spring boot test annotation to enable ONLY DAO layer n entities
@AutoConfigureTestDatabase(replace = Replace.NONE) // DO NOT replace 
//main db by test db
@Rollback(false) //after completion of test cases DO NOT rollback tx.
class EmployeeDaoTest {
	@Autowired
	private EmployeeDao empDao;

	@Test
	void testAddEmps() {
		List<Employee> list = List.of(
				new Employee("a1", "b1", "a1@gmail.com" , Timestamp.valueOf("2023-11-11T00:00:01+00:00"),
						Timestamp.valueOf("2023-11-11T00:00:01+00:00"),new Department("Accounts"))
				          );
	
		empDao.saveAll(list);
		Assertions.assertTrue(empDao.count()==1);
	
	}

}
