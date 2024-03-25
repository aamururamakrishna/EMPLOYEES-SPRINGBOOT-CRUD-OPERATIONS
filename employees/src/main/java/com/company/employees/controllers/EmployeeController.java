package com.company.employees.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.employees.models.Employee;
import com.company.employees.models.EmployeeDto;
import com.company.employees.services.EmployeeRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/employees") //DataBase Table Name
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository repo; //Import From Service Package

	@GetMapping({"","/"}) //To Display Data in to localhost
	public String showEmployeeList(Model model) {
		List<Employee> employees=repo.findAll(); //Employee import from Model Class and employee is Data Base Table Name
		model.addAttribute("employees", employees);
		return "employee/index";
	}
	
	@GetMapping("/create")
	public String showCreateEmployee(Model model) {
		EmployeeDto employeeDto = new EmployeeDto();
		model.addAttribute("employeeDto", employeeDto);
		return "employee/employeecreate";
	}
	
	@PostMapping("/create")
	public String CreateEmployee(@Valid @ModelAttribute EmployeeDto employeeDto,BindingResult result) {
		
		if(result.hasErrors()) {
			return "employee/employeecreate";
		}
		
		Employee employee = new Employee();
		employee.setEmailid(employeeDto.getEmailid());
		employee.setEmployeeid(employeeDto.getEmployeeid());
		employee.setLocation(employeeDto.getLocation());
		employee.setMobileno(employeeDto.getMobileno());
		employee.setName(employeeDto.getName());
		employee.setTechnology(employeeDto.getTechnology());
		
		repo.save(employee);

		return "redirect:/employees/";
	}
	
	// To display Edit Page
	
	@GetMapping("/edit")
	public String ShowEditEmployee(Model model, @RequestParam int id) {
		

		try {
			Employee employee=repo.findById(id).get();
			model.addAttribute("employee",employee);
			
			EmployeeDto employeeDto = new EmployeeDto();
				employeeDto.setEmailid(employee.getEmailid());
				employeeDto.setEmployeeid(employee.getEmployeeid());
				employeeDto.setLocation(employee.getLocation());
				employeeDto.setMobileno(employee.getMobileno());
				employeeDto.setName(employee.getName());
				employeeDto.setTechnology(employee.getTechnology());
				
				model.addAttribute("employeeDto", employeeDto);
				
				}catch(Exception e) {
					System.out.println(e);
				}
		return "/employee/editemployee";
		}
	
	// To edit the Employee Details
	
	@PostMapping("/edit")
	public String UpdateEmployee(@Valid @ModelAttribute @RequestParam int id, Model model, EmployeeDto employeeDto ) {
		
		Employee employee = repo.findById(id).get();
		model.addAttribute("employee",employee);
		
		employee.setEmailid(employeeDto.getEmailid());
		employee.setEmployeeid(employeeDto.getEmployeeid());
		employee.setLocation(employeeDto.getLocation());
		employee.setMobileno(employeeDto.getMobileno());
		employee.setName(employeeDto.getName());
		employee.setTechnology(employeeDto.getTechnology());
		
		repo.save(employee);
		
		return "redirect:/employees/";
	}
	
	// To Delete Employee
	
	@GetMapping("/delete")
	public String DeleteNavbar(@RequestParam int id ) {
		
		try {	
			Employee employee=repo.findById(id).get();	
			repo.delete(employee);
		}catch(Exception e) {
			System.out.println(e);
		}
		return "redirect:/employees/";
	}
		
}
