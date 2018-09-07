package ems.entity;

import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public class Employee {

	private String userName;
	/*@NotEmpty(message = "Password should not be blank")
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,}", message = "Minimum eight characters, at least one uppercase letter, one lowercase letter, one number and one special character")
*/
	private String userPassword;
	private String userId;
	private Date activatedOn;

	
	private String emailId;

	@NotEmpty
	@Size(min = 4, max = 50, message = "Should be atleast 4 characters")
	public String firstName;

	@NotEmpty
	@Size(min = 1, max = 50, message = "Should be atleast 4 characters")
	public String lastName;

	/*
	 * @Pattern(regexp=
	 * "^(?:0[1-9]|[12]\\d|3[01])([\\/.-])(?:0[1-9]|1[12])\\1(?:19|20)\\d\\d$")
	 */
	/* @DateTimeFormat(pattern = "dd/mm/yyyy") */
	public Date dDOB;
	public String DOB;
	/*
	 * @Length( max = 15,message="Contact number should be less than 15 digits")
	 * 
	 * @Pattern(regexp="^[0-9]*$",message="Contact number not valid")
	 */
	public String mobileNumber;
	/*
	 * @NotNull(message="Please select gender")
	 */
	public String gender;

	/*
	 * @Pattern(regexp="^[/0-9a-zA-Z-.&@',:\\\\()\\s\\/]*$",
	 * message="Address not valid")
	 * 
	 * @Length( max = 200,message="Address should be less than 200 character")
	 */
	public String address;

	/*
	 * @Pattern(regexp="^[/0-9a-zA-Z-.&@',:\\\\()\\s\\/]*$",
	 * message="Address not valid")
	 * 
	 * @Length( max = 50,message="Address should be less than 200 character")
	 */
	public String city;

	@NotNull(message = "please select state")
	@Digits(integer = 6, fraction = 0, message = "Please select valid state")
	public int postalCode;
	/* @NotNull(message = "please select district") */
	public String stateCodedesc;
	public Integer stateCode;
	/* @NotNull(message = "please select district") */
	public String districtCodeDesc;
	public Integer districtCode;

	/*
	 * @NotEmpty
	 * 
	 * @Size(min=4,max=50,message="Should be atleast 4 characters")
	 */
	public String designation;

	private Integer userType;
	private String userTypeDesc;
	private MultipartFile file;
	private byte[] file1;
	public Date enteredOn;
	public String enteredBy;
	public String activatedBy;
	public String activatedClientIp;
	public String activeStatus;
	public Date deactivatedOn;
	public String deactivatedBy;
	public String deactivatedClientIp;

	public Integer userRole;
	public String userRoledesc;
	public Date passwordUpdatedOn;

	public Date getdDOB() {
		return dDOB;
	}

	public void setdDOB(Date dDOB) {
		this.dDOB = dDOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getDOB() {
		return this.DOB;
	}

	public byte[] getFile1() {
		return file1;
	}

	public void setFile1(byte[] file1) {
		this.file1 = file1;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Date getActivatedOn() {
		return activatedOn;
	}

	public void setActivatedOn(Date activatedOn) {
		this.activatedOn = activatedOn;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDeactivatedOn() {
		return deactivatedOn;
	}

	public void setDeactivatedOn(Date deactivatedOn) {
		this.deactivatedOn = deactivatedOn;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public Date getPasswordUpdatedOn() {
		return passwordUpdatedOn;
	}

	public void setPasswordUpdatedOn(Date passwordUpdatedOn) {
		this.passwordUpdatedOn = passwordUpdatedOn;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public String getStateCodedesc() {
		return stateCodedesc;
	}

	public void setStateCodedesc(String stateCodedesc) {
		this.stateCodedesc = stateCodedesc;
	}

	public Integer getStateCode() {
		return stateCode;
	}

	public void setStateCode(Integer stateCode) {
		this.stateCode = stateCode;
	}

	public String getUserTypeDesc() {
		return userTypeDesc;
	}

	public void setUserTypeDesc(String userTypeDesc) {
		this.userTypeDesc = userTypeDesc;
	}

	public String getUserRoledesc() {
		return userRoledesc;
	}

	public void setUserRoledesc(String userRoledesc) {
		this.userRoledesc = userRoledesc;
	}

	public String getDistrictCodeDesc() {
		return districtCodeDesc;
	}

	public void setDistrictCodeDesc(String districtCodeDesc) {
		this.districtCodeDesc = districtCodeDesc;
	}

	public Integer getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(Integer districtCode) {
		this.districtCode = districtCode;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Integer getUserType() {
		return userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public String getActivatedBy() {
		return activatedBy;
	}

	public void setActivatedBy(String activatedBy) {
		this.activatedBy = activatedBy;
	}

	public String getActivatedClientIp() {
		return activatedClientIp;
	}

	public void setActivatedClientIp(String activatedClientIp) {
		this.activatedClientIp = activatedClientIp;
	}

	public String getDeactivatedBy() {
		return deactivatedBy;
	}

	public void setDeactivatedBy(String deactivatedBy) {
		this.deactivatedBy = deactivatedBy;
	}

	public String getDeactivatedClientIp() {
		return deactivatedClientIp;
	}

	public void setDeactivatedClientIp(String deactivatedClientIp) {
		this.deactivatedClientIp = deactivatedClientIp;
	}

	public Integer getUserRole() {
		return userRole;
	}

	public void setUserRole(Integer userRole) {
		this.userRole = userRole;
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

}
