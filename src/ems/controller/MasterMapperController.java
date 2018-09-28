package ems.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import ems.entity.AccessUrl;
import ems.entity.Datatable;
import ems.entity.Employee;
import ems.entity.Ministry;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.service.EmployeeService;
@SessionAttributes({"empsession","ipAddress","navUrl"}) 
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
	@ResponseBody 
	public List<SubUrl> getUrlByURLId(@RequestParam("id")String id,Model model){
		List<SubUrl> url=new ArrayList<SubUrl>();
		try {
			url	=employeeService.getsubUrlByUrl(Integer.parseInt(id.trim()));
		}catch (Exception e) {
			e.printStackTrace();
		}
			return url;
		
	}
	
		@RequestMapping(value="getUrlByRole", method=RequestMethod.POST)
		@ResponseBody
		public List<AccessUrl> getUrlByRole(@RequestParam("id") String id,Model model ){
			List<AccessUrl> accList = new ArrayList<AccessUrl>();
		accList = employeeService.getUrl(Integer.parseInt(id.trim()));
		for (AccessUrl accessUrl : accList) {
			List<SubUrl> suburlList=new ArrayList<>();
			suburlList =employeeService.getsubUrl(accessUrl.getUrlId(),Integer.parseInt(id.trim()));
			
			accessUrl.setSubList(suburlList);
		}
		return accList;
	}
		
		@RequestMapping(value="submitIds", method=RequestMethod.POST)
		@ResponseBody
		public int submitUrl(@RequestParam("roleid") String roleid,
					@RequestParam("urlid") String urlid,@RequestParam("subUrlid") String subUrlid, Model model){
			List<SubUrl> accList = new ArrayList<SubUrl>();
			int i = employeeService.insertEmpUrl(roleid,urlid,subUrlid);
			System.out.println(roleid);
			return i;
		}
}
