package com.rahul.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Repository.EmployeeRepository;
import com.dto.EmpDto;
import com.rahul.entity.Emp;


@Service
public class EmployeeService {

	@Autowired
    EmployeeRepository repo;
	
	
	public String createemp(EmpDto emp) {
		
		System.out.println(emp);
		Emp employee = new Emp();
		employee.setFullName(emp.getFullName());
		employee.setEmail(emp.getEmail());
		employee.setPassword(emp.getPassword());
		employee.setSalary(emp.getSalary());
		employee.setAddress(emp.getAddress());
		employee.setDesignation(emp.getDesignation());
		
		repo.save(employee);
		
		
		
		return "Registerd successfully....";
	}


	public List<Emp> getAllEmp() {
		List<Emp> list= repo.findAll();
		return list;
	}


	public Emp getEmpById(int id) {
		
		 Optional<Emp> emp = repo.findById(id);
	        return emp.orElse(null);
		
	}


	public String UpdateInfo(EmpDto emp, int id) {
		
		Emp employee = new Emp();
		employee.setId(id);
		employee.setFullName(emp.getFullName());
		employee.setEmail(emp.getEmail());
		employee.setPassword(emp.getPassword());
		employee.setSalary(emp.getSalary());
		employee.setAddress(emp.getAddress());
		employee.setDesignation(emp.getDesignation());
		
		repo.save(employee);
		
		
		
		return "Update successfully....";
		
	}
/*

	public String deleteByEmpId(int empid) {
		// TODO Auto-generated method stub
		
		Emp emp = repo.findById(empid).get();
		repo.delete(emp);
		
		return "Employee Deleted Successfully...";
	}

*/


	
	public void deleteByEmpId(int empid) {
		// TODO Auto-generated method stub
		
		
		
		repo.deleteById(empid);
	}


	
	
   
}
