package com.Repository;

import java.util.List;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Modifying;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

//import com.dto.EmpDto;
import com.rahul.entity.Emp;


@Repository
public interface EmployeeRepository extends JpaRepository<Emp, Integer> {


	
	/*
	
    public int saveEmp(Emp emp);
	
	public Emp getEmpbyId(int id);
	
	public List<Emp> getAllEmp();
	
	public void update(Emp emp);
	
	public void deleteEmp(int id);
*/
	
	
}
