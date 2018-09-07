package ems.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MasterMapperController {
	@RequestMapping(value="/mapUrl", method=RequestMethod.GET)
	public String mapUrl() throws IOException {
			return "mapUrl";
		}
	
	
	
	
}
