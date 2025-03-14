package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Servic.EmpServic;
import com.entity.Employee;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmpController {
	
	@Autowired
	private EmpServic service;

	@GetMapping("/")
	public String home(Model m)
	{
		 List<Employee> emp=service.getAllEmp();
		 m.addAttribute("emp",emp);
		return"index";
	}
	@GetMapping("/EmpAdd")
	public String Add()
	{
		return "EmpAdd";
	}
	//URL Mapping
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e)
	{
		//session.setAttribute("msg", "Employee Added Sucessfully");
		System.out.print(e);
		
		service.addEmp(e);
		return "EmpAdd";
		
	}
	
	  @GetMapping("/edit/{id}") 
	  public String edit(@PathVariable int id ,Model m)
	  {
		  Employee e=service.getEMpById(id); 
		  m.addAttribute("emp",e);
		  return "edit";
	  
	  }
	  @PostMapping("/update")
	  public String UpdateEmp(@ModelAttribute Employee e)
	  {
		  service.addEmp(e);
		return "redirect:/";
		  
	  }
	  @GetMapping("/delete/{id}")
	  public String Delete(@PathVariable int id)
	  {
		  service.DeleteEmp(id);
		  return"redirect:/";
	  }
	  
	 

}
