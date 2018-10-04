package ems.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ems.entity.Employee;
import ems.service.CaptchaImgService;
import ems.service.CaptchaImgServiceImpl;
import ems.service.EmployeeService;
import ems.utils.PassEncryption;
import ems.utils.RandomSaltGenerator;

@Controller
@SessionAttributes({"empsession","ipAddress","randSalt","capStr"}) 
public class LoginController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private CaptchaImgServiceImpl captchaimageobj;
	
	@RequestMapping(value = { "/", "login" })
	public String login(Model model) {
		String randSalt="";
		try {
			randSalt = RandomSaltGenerator.generateRandomSalt();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("randSalt", randSalt); 
		model.addAttribute("formUser", new Employee());

		return "login";
	}
	
	@RequestMapping(value="/captchaimg")
	public ResponseEntity<byte[]> testCaptcha(Model model, HttpSession session)throws IOException {
	 	captchaimageobj=new CaptchaImgServiceImpl();
	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_JPEG);
	    byte[] imgbytes=captchaimageobj.createBytes(); // returns image bytes for captcha generated in service class.
	    String capStr=captchaimageobj.getCaptchastring();
	    model.addAttribute("capStr",capStr); // Sets captcha string to session.
	    session.setAttribute("captcha",capStr);
	    System.out.println(capStr);
	    return new ResponseEntity<byte[]>(imgbytes, headers, HttpStatus.CREATED);
		
	}
		
	@RequestMapping(value = "checkUser", method = RequestMethod.POST)
	public String home(@ModelAttribute("formUser") Employee formuser, BindingResult bindingresult,@ModelAttribute("randSalt") String salt, HttpSession session,
			HttpServletRequest request) {
		System.out.println(bindingresult);
		if (bindingresult.hasErrors()) {
			return "login";
		}

		

		Employee databaseUser = employeeService.getUser(formuser.getEmailId());
		System.out.println(databaseUser.getUserPassword());
		System.out.println(formuser.getUserPassword());
		if(formuser.getCaptcha().equals(session.getAttribute("captcha"))){
		if (databaseUser != null
				&& PassEncryption.encrypt(databaseUser.getUserPassword()+salt).equals(formuser.getUserPassword())) {

			session.removeAttribute("ipAddress");
			session.removeAttribute("empsession");
			session.setAttribute("ipAddress", request.getRemoteAddr());
			session.setAttribute("empsession", databaseUser);
			return "redirect:/home";
		}
		return "login";
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
