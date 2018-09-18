package ems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ems.entity.AccessUrl;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.service.EmployeeService;

@Controller
public class MasterMapperController {
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/mapUrl", method=RequestMethod.GET)
	public String mapUrl(Model model,HttpSession session) throws IOException {
		List<UserRole> roleList=new  ArrayList<UserRole>();
		roleList=employeeService.getUserRoleList();
		
		List<AccessUrl>accList=employeeService.getUrl();
		model.addAttribute("allroles", roleList);
		model.addAttribute("allurl", accList);
			return "mapUrl";
		}
	
	@RequestMapping(value="getUrlById",method=RequestMethod.POST)
	@ResponseBody public List<SubUrl> getUrlByURLId(@RequestParam("id")String id,Model model){
		List<SubUrl> url=new ArrayList<SubUrl>();
		try {
			url	=employeeService.getsubUrlByUrl(Integer.parseInt(id.trim()));
		}catch (Exception e) {
			e.printStackTrace();
		}
			return url;
		
	}
	
	
}
