package com.bext.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bext.model.Employee;
import com.bext.model.Info;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class TestController {

	@RequestMapping(value = "/empleado", method = RequestMethod.GET)
	//@HystrixCommand(fallbackMethod = "getDataFallBack")
	public Employee firstPage() {

		System.out.println("Dentro de la primer pagina");
		
		Employee emp = new Employee();
		emp.setName("emp1");
		emp.setDesignation("manager");
		emp.setEmpId("1");
		emp.setSalary(3000);

		//Obligamos un error en el flujo de respuesta para probar hystrix
		//if (emp.getName().equalsIgnoreCase("emp1")) 
		//	throw new RuntimeException();
		
		return emp;
	}
	
	public Employee getDataFallBack() {
		
		System.out.println("IN fallback");
		
		Employee emp = new Employee();
		emp.setName("fallback-emp1");
		emp.setDesignation("fallback-manager");
		emp.setEmpId("fallback-1");
		emp.setSalary(3000);

		return emp;
	}

	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String infoPage() {
		return "<h3>Página de información employee-producer  corriendo en puerto: "+Info.getPort()+"</h3></br>";
	}
}