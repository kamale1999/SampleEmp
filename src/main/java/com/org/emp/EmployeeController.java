package com.org.emp;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class EmployeeController {
	private EmployeeService employeeService;
	

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	// handler method to handle list Employees and return mode and view
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		System.out.println("in");
		model.addAttribute("employees", employeeService.getAllEmployees());
		return "employees";
	}
	
	@RequestMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		
		// create Employee object to hold Employee form data
		Employee Employee = new Employee();
		model.addAttribute("employee", Employee);
		return "create_employee";
		
	}
	
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee Employee) {
		employeeService.saveEmployee(Employee);
		return "redirect:/emp/employees";
	}
	
	@RequestMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Integer id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@RequestMapping(value = "/employees/{id}" , method = RequestMethod.POST)
	public String updateEmployee(@PathVariable Integer id,
			@ModelAttribute("employee") Employee Employee,
			Model model) {
		
		// get Employee from database by id
		Employee existingEmployee = employeeService.getEmployeeById(id);
		existingEmployee.setId(id);
		existingEmployee.setEname(Employee.getEname());
		existingEmployee.setDepartment(Employee.getDepartment());
		existingEmployee.setDoj(Employee.getDoj());
		existingEmployee.setAddress(Employee.getAddress());
		existingEmployee.setStateAndCity(Employee.getStateAndCity());
		
		// save updated Employee object
		employeeService.updateEmployee(existingEmployee);
		return "redirect:/Employees";		
	}
	
	// handler method to handle delete Employee request
	
	@RequestMapping("/Employees/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/Employees";
	}
	
}


