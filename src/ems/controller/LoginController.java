package ems.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ems.entity.Employee;
import ems.service.EmployeeService;
import ems.service.PassEncryption;

@Controller
@SessionAttributes({"empsession","ipAddress"}) 
public class LoginController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = { "/", "login" })
	public String login(Model model) {
		model.addAttribute("formUser", new Employee());

		return "login";
	}

	
	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	public String home(@ModelAttribute("formUser") Employee formuser, BindingResult bindingresult, HttpSession session,
			HttpServletRequest request) {
		System.out.println(bindingresult);
		if (bindingresult.hasErrors()) {

			return "login";
		}

		System.out.println("hello");

		Employee databaseUser = employeeService.getUser(formuser.getEmailId());
		if (databaseUser != null
				&& databaseUser.getUserPassword().equals(PassEncryption.encrypt(formuser.getUserPassword()))) {

			session.removeAttribute("ipAddress");
			session.removeAttribute("empsession");
			session.setAttribute("ipAddress", request.getRemoteAddr());
			session.setAttribute("empsession", databaseUser);
			return "redirect:/home";
		}
		else
			return "login";
	}
	
	
	 @RequestMapping(value = "/logout", method = RequestMethod.GET)
		public String logout(Model model, @ModelAttribute("user") Employee user, @ModelAttribute("ipAddress") String ipAddress,
				HttpSession session) {

			
				
				model.asMap().clear();
				session.invalidate();
			

			return "redirect:/login";
		}
	
}
