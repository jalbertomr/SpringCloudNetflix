package com.bext.services;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bext.model.Employee;

@FeignClient(name = "empleado-productor")
public interface RemoteCallService {
	@RequestMapping(method = RequestMethod.GET, value = "/empleado")
	public Employee getData();
}
