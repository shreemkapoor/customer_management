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
	@ResponseBody
	public String professionalDetails(@RequestParam("company") String company,
			@RequestParam("designation") String designation, @RequestParam("sd1") String startDate,
			@RequestParam("ed1") String endDate, @RequestParam("exp") String experienceSummary,
			@RequestParam("edu") String education, @RequestParam("uni") String university,
			@RequestParam("cur") String course, @RequestParam("ed2") String ENDDATE,
			@RequestParam("per") String percentage, @RequestParam("sd2") String sdate2, HttpSession session,
			HttpServletRequest hsr, Model model) {

		String comp[] = null;
		String des[] = null;
		String sd1[] = null;
		String sd2[] = null;
		String ed1[] = null;
		String ed2[] = null;
		String exp[] = null;
		String uni[] = null;
		String per[] = null;
		String cur[] = null;
		String[] edu = null;
		System.out.println(company);
		try {
			comp = company.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			des = designation.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			uni = university.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			per = percentage.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			edu = education.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			exp = experienceSummary.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			sd2 = sdate2.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			sd1 = startDate.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			ed2 = ENDDATE.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			ed1 = endDate.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}
		try {
			cur = course.split(",");
		} catch (Exception e) {
			// TODO: handle exception
		}

		Employee profdet = new Employee();
		List<Education> elist=new ArrayList<>();
		List<ProfessionalDetails> plist=new ArrayList<>();
		for (int i = 0; i < cur.length; i++) {
			Education educ = new Education();
			educ.setCourse(cur[i]);
			educ.setEducation(edu[i]);
			educ.setENDDATE(ed2[i]);
			educ.setPercentage(per[i]);
			educ.setSTARTDATE(sd2[i]);
			educ.setUniversity(uni[i]);
			elist.add(educ);
		}
		
		for (int i = 0; i < comp.length; i++) {
			ProfessionalDetails pro=new  ProfessionalDetails();
			pro.setCompanyName(comp[i]);
			pro.setDesignation(des[i]);
			pro.setSTARTDATE(sd1[i]);;
			pro.setExperienceSummary(exp[i]);
			pro.setENDDATE(ed1[i]);
			plist.add(pro);
		}
		profdet.setEduList(elist);
		profdet.setProList(plist);
		System.out.println(">>>>>>>>>>>>>");
		Employee empsession = (Employee) session.getAttribute("empsession");
		profdet.setEnteredBy(empsession.getEmailId());
		profdet.setEmailId(empsession.getEmailId());
		int i = employeeService.professionalDetails(profdet);
		if (i > 0) {
			
			return "success";
		}
		return "success";
	}
}
