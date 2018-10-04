package ems.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import ems.entity.Project;
import ems.service.ProjectService;

@Controller
@SessionAttributes({"empsession","ipAddress","navUrl"}) 
public class ProjectController {
 
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value="createProject", method=RequestMethod.GET)
	public String createProject(@ModelAttribute("project") Project project,BindingResult bindingResult,Model model,HttpSession session) {
		return "createProject";
	}
}
