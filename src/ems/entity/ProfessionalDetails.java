package ems.entity;

import java.util.Date;

public class ProfessionalDetails {

	private String emailId;
	private String companyName;
	private String designation;
	private Date startDate;
	private String STARTDATE;
	private Date endDate;
	private String ENDDATE;
	private String experienceSummary;
	private String experienceRange;
	private String domainsWorkedOn;
	private String skills;
	private Date entered_on;
	private String entered_by;
	private Education education;
	
	
	public Education getEducation() {
		return education;
	}
	public void setEducation(Education education) {
		this.education = education;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getSTARTDATE() {
		return STARTDATE;
	}
	public void setSTARTDATE(String sTARTDATE) {
		STARTDATE = sTARTDATE;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getENDDATE() {
		return ENDDATE;
	}
	public void setENDDATE(String eNDDATE) {
		ENDDATE = eNDDATE;
	}
	public String getExperienceSummary() {
		return experienceSummary;
	}
	public void setExperienceSummary(String experienceSummary) {
		this.experienceSummary = experienceSummary;
	}
	public String getExperienceRange() {
		return experienceRange;
	}
	public void setExperienceRange(String experienceRange) {
		this.experienceRange = experienceRange;
	}
	public String getDomainsWorkedOn() {
		return domainsWorkedOn;
	}
	public void setDomainsWorkedOn(String domainsWorkedOn) {
		this.domainsWorkedOn = domainsWorkedOn;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public Date getEntered_on() {
		return entered_on;
	}
	public void setEntered_on(Date entered_on) {
		this.entered_on = entered_on;
	}
	public String getEntered_by() {
		return entered_by;
	}
	public void setEntered_by(String entered_by) {
		this.entered_by = entered_by;
	}
	
	
	
}
