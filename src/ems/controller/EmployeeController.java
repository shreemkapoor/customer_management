package ems.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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
import org.springframework.web.multipart.MultipartFile;

import ems.entity.AccessUrl;
import ems.entity.District;
import ems.entity.Employee;
import ems.entity.Gender;
import ems.entity.State;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.entity.UserType;
import ems.service.EmployeeService;
import ems.service.PassEncryption;

@Controller
@SessionAttributes({"empsession","ipAddress","navUrl"}) 
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping("/homepage11")
	public String showDashboard() {
		return "dashboard";
	}
	@RequestMapping("/home")
	public String showHome(Model model,HttpSession session,HttpServletRequest request) {
		String clientcookiesvalu="";
		Cookie[] cookies = request.getCookies();
        if (cookies != null)
        {
            for (Cookie cook : cookies)
            {
                if ("JSESSIONID".equalsIgnoreCase(cook.getName()))
                {
               	 System.out.println("JSESSIONID  " +cook.getName());
               	 clientcookiesvalu = cook.getValue();
               	 System.out.println("clientcookiesvalu  " +clientcookiesvalu);
                    break;
                }
            }
        }
        System.out.println("session.getId  " +session.getId()); 
if(!(clientcookiesvalu.equalsIgnoreCase(session.getId())))
{
	return "redirect:/login";
}
	
		Employee emp=(Employee)session.getAttribute("empsession");
		List<AccessUrl>accList=employeeService.getUrl(emp.getUserRole());
		for (AccessUrl accessUrl : accList) {
			List<SubUrl> suburlList=new ArrayList<>();
			suburlList =employeeService.getsubUrl(accessUrl.getUrlId(),emp.getUserRole());
			accessUrl.setSubList(suburlList);
		}
		session.removeAttribute("navUrl");
		session.setAttribute("navUrl",accList);
	/*	model.addAttribute("navUrl",accList );*/
		return "homepage";
	}
	
	@RequestMapping("/registerNewForm")
	public String registerForm(Model model) {
		Employee theEmployee = new Employee();
		model.addAttribute("employee", theEmployee);
		/*Get all states in drop down*/
		List<State> statelist=employeeService.getEmpStateList();
		model.addAttribute("allstate", statelist);
		List<UserType> typeList=employeeService.getUserTypeList();
		model.addAttribute("alltypes", typeList);
		List<UserRole> roleList=employeeService.getUserRoleList();
		model.addAttribute("allroles", roleList);
		List<Gender> genderList=employeeService.getGenderList();
		model.addAttribute("allgender", genderList);
		return "register";
	}
	
	@RequestMapping("/updateEmployee")
	public String updateEmployee(@RequestParam("emailId") String emailId,Model model,HttpSession session,HttpServletRequest request) {
		Employee theEmployee = employeeService.getUser(emailId);
		model.addAttribute("employee", theEmployee);
		List<State> statelist=employeeService.getEmpStateList();
		model.addAttribute("allstate", statelist);
		List<UserType> typeList=employeeService.getUserTypeList();
		model.addAttribute("alltypes", typeList);
		List<UserRole> roleList=employeeService.getUserRoleList();
		model.addAttribute("allroles", roleList);
		List<Gender> genderList=employeeService.getGenderList();
		model.addAttribute("allgender", genderList);
		return "updateUser";
	}
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public String createNewUser(@Valid @ModelAttribute("employee") Employee theEmployee, BindingResult bindingResult,@RequestParam(value="file", required=false) MultipartFile mfile, Model model,HttpSession session) throws IOException {
		if(bindingResult.hasErrors()) {
			System.out.println("gzbhc   "+bindingResult.getFieldErrors());
			model.addAttribute("errors", bindingResult.getFieldErrors());
			return "register";
		}
		
		Employee empsession=(Employee) session.getAttribute("empsession");
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    Date date=new Date();
	    System.out.println(theEmployee.getDOB());
        try {
             date = formatter.parse(theEmployee.getDOB());
            System.out.println(date);
            System.out.println(formatter.format(date));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	//	System.out.println("bfdj"+mfile.getBytes());
        try{theEmployee.setDistrictCode(Integer.parseInt(theEmployee.getDistrictCodeDesc().trim()));
		
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
        theEmployee.setFile1(mfile.getBytes());
		theEmployee.setActivatedBy(empsession.getUserId());
		theEmployee.setActivatedClientIp(session.getAttribute("ipAddress").toString());
		theEmployee.setActiveStatus("Y");
		theEmployee.setdDOB(date);
		theEmployee.setUserPassword(new PassEncryption().encrypt("Pass@12345"));
		theEmployee.setUserName(theEmployee.getFirstName()+"  "+theEmployee.getLastName());
		int i=employeeService.createEmployee(theEmployee);
		theEmployee.setEnteredBy(empsession.getUserId());
		System.out.println(theEmployee.getUserName());
		if(i>0) {
		return "redirect:/home";
		}else {
			return "redirect:/login";
		}
	}

	@RequestMapping(value="/alldistrict",method=RequestMethod.POST)
	@ResponseBody
	public List<District> showAllDistrict(@RequestParam("id") String stateCode ,Model model) {
		State state=new State();
		state.setStateCode(stateCode);
		return employeeService.getEmpDistrictList(state);				
}
	
	@RequestMapping("/listEmployees")
	public String listEmployees(Model model, HttpSession session) {
	//	Employee emp=(Employee)session.getAttribute("empsession");
		List<Employee> emplist = employeeService.getEmployees();
		System.out.println(emplist.size());
		model.addAttribute("employees", emplist);
		return "employeeList";
	}
}

