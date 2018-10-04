package ems.entity;

import java.util.Date;

public class ProjectType {

	private Integer projectTypeId;
	private String projectTypeDesc;
	private Date enteredOn;
	private String enteredBy;
	private String clientIp;

	
	public Integer getProjectTypeId() {
		return projectTypeId;
	}
	public void setProjectTypeId(Integer projectTypeId) {
		this.projectTypeId = projectTypeId;
	}
	public String getProjectTypeDesc() {
		return projectTypeDesc;
	}
	public void setProjectTypeDesc(String projectTypeDesc) {
		this.projectTypeDesc = projectTypeDesc;
	}
	public Date getEnteredOn() {
		return enteredOn;
	}
	public void setEnteredOn(Date enteredOn) {
		this.enteredOn = enteredOn;
	}
	public String getEnteredBy() {
		return enteredBy;
	}
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	
	
	
}
