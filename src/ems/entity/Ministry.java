package ems.entity;

import java.util.Date;

public class Ministry {

	private String ministryDesc;
	private Integer ministryId;
	private Date enteredOn;
	private String clientIp;
	private String enteredBy;
	private String activeStatus;
	
	public Date getEnteredOn() {
		return enteredOn;
	}
	public void setEnteredOn(Date enteredOn) {
		this.enteredOn = enteredOn;
	}
	public String getClientIp() {
		return clientIp;
	}
	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}
	public String getEnteredBy() {
		return enteredBy;
	}
	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	
	public Integer getMinistryId() {
		return ministryId;
	}
	public void setMinistryId(Integer ministryId) {
		this.ministryId = ministryId;
	}
	public String getMinistryDesc() {
		return ministryDesc;
	}
	public void setMinistryDesc(String ministryDesc) {
		this.ministryDesc = ministryDesc;
	}
	
	
}
