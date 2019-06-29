package com.bext.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bext.model.Employee;
import com.bext.model.Info;

@RestController
public class TestController {

	@RequestMapping(value = "/empleado", method = RequestMethod.GET)
	public Employee firstPage() {

		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		return emp;
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String infoPage() {
		return "<h3>Página de información employee-producer  corriendo en puerto: "+Info.getPort()+"</h3></br>";
	}
}