package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.EmployeeServiceImp;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class HomeController {

	@Autowired
	EmployeeServiceImp employeeServiceImp;

	@GetMapping("/")
	public String getHomePage() {
		System.out.println("---HomeController.getHomePage()---");
		return "home";
	}

	@GetMapping("/reportOne")
	public String showReport(Map<String, Object> map) {

		List<Employee> list = (List<Employee>) employeeServiceImp.showAllEmployeesByPagination();

		for (Employee employee : list) {
			System.out.println("-----------------");
			System.out.println(employee.getDept());
			System.out.println(employee.getEmployeeName());
			System.out.println(employee.getJob());
			System.out.println(employee.getSalary());
			System.out.println("-----------------");

		}
		map.put("employees", list);
		System.out.print("list from contoller class " + employeeServiceImp.showAllEmployeesByPagination());

		return "showReport";
	}


}
