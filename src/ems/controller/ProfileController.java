package ems.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import ems.entity.Education;
import ems.entity.Employee;
import ems.entity.ProfessionalDetails;
import ems.service.EmployeeService;

@Controller
@SessionAttributes({ "empsession", "ipAddress", "navUrl" })
public class ProfileController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/personalDetails", method = RequestMethod.GET)
	public String personalDetails(HttpSession session, Model model) {
		Employee empsession = (Employee) session.getAttribute("empsession");
		Employee emplist = employeeService.getUser(empsession.getEmailId());
		model.addAttribute("employee", emplist);

		return "personalDetails";
	}

	@RequestMapping(value = "professionalDetails", method = RequestMethod.GET)
	public String professionalDetailsGET(HttpSession session, Model model) {
		model.addAttribute("profDetails", new Employee());
		return "professionalDetails";
	}

	@RequestMapping(value = "professionalDetails1", method = RequestMethod.POST)
	
	public String professionalDetails(@ModelAttribute("profDetails")Employee profdet , HttpSession session,
			HttpServletRequest hsr, Model model) {
		
			System.out.println(">>>>>>>>>>>>>"+profdet.getProList().size());
		
		Employee empsession = (Employee) session.getAttribute("empsession");
		profdet.setEnteredBy(empsession.getEmailId());
		profdet.setEmailId(empsession.getEmailId());
		int i = employeeService.professionalDetails(profdet);
		if (i > 0) {
			
			return "redirect:/home";
		}
		return ":redirect:/error";
	}
	
}
