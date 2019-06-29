package com.bext.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bext.model.Info;

@RestController
public class TestController {
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String infoPage() {
		return "<h3>Página de información employee-consumer corriendo en puerto: "+Info.getPort()+"</h3></br>" + 
	    "<h3>Asignado al Productor: " + Info.getServiceInstance_Uri() + "</h3></br>";
	}
}
