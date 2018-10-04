package ems.entity;

import java.util.Date;

public class ProjectDetails {

	private String emailId;
	private String projectName;
	private String projectBrief;
	private String techUsed;
	private Date startDate;
	private String STARTDATE;
	private Date endDate;
	private String ENDDATE;
	private Date entered_on;
	private String entered_by;
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectBrief() {
		return projectBrief;
	}
	public void setProjectBrief(String projectBrief) {
		this.projectBrief = projectBrief;
	}
	public String getTechUsed() {
		return techUsed;
	}
	public void setTechUsed(String techUsed) {
		this.techUsed = techUsed;
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
