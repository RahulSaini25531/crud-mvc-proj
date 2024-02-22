package com.rahul.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dto.EmpDto;
import com.rahul.entity.Emp;
import com.rahul.service.EmployeeService;

@Controller
public class HomeController {
	
	@Autowired
    EmployeeService service;
	
	
	@RequestMapping(path="/home")
	public String home(Model m)
	{
		List<Emp> list = service.getAllEmp(); 
		m.addAttribute("empList", list);
		return "home";
		
	}
	
	
	@RequestMapping(path="/addEmp")
	public String addEmp()
	{
		
		return "add_emp";
		
	}
	@RequestMapping(path="/createEmp",method = RequestMethod.POST)
//	@ResponseBody
	public String createEmp(HttpServletRequest request,HttpSession session)
	{
		
		String name = request.getParameter("fullName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		String salary = request.getParameter("salary");
		
		EmpDto emp = new EmpDto(name, address, email, password, designation, salary);
		
		String message= service.createemp(emp);
		//model.addAttribute("result", message);
		session.setAttribute("msg", message);
		
		return "redirect:/addEmp ";
	}
	
	@GetMapping("/editEmp/{id}")
	public String editEmp(@PathVariable int id,Model m)
	{
		Emp emp=service.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit_emp";
	}
	
	
	//@PostMapping("/updateEmp")
	@RequestMapping(path="/updateEmp/{id}",method = RequestMethod.POST)
	public String updateEmp(HttpServletRequest request,HttpSession session, @PathVariable int id)
	{
		String name = request.getParameter("fullName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String designation = request.getParameter("designation");
		String salary = request.getParameter("salary");
		
		EmpDto emp = new EmpDto(name, address, email, password, designation, salary);
		
		String info = service.UpdateInfo(emp,id);
		
        session.setAttribute("msg", info);
		
		return "redirect:/home ";
	}/*
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		//String deleteInfo = service.deleteByEmpId(id);
		
		session.setAttribute("msg", deleteInfo);
		
		return "redirect:/home ";
	}
	*/
	
	@GetMapping("/deleteEmp/{id}")
	public String deleteEmp(@PathVariable int id,HttpSession session)
	{
		service.deleteByEmpId(id);
		
		session.setAttribute("msg", "Employee Deleted Successfully...");
		
		return "redirect:/home ";
	}

}
