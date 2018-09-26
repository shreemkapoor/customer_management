package ems.mapper;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Employee mapUser = new Employee();
		mapUser.setUserId(resultSet.getString("emp_id"));
		mapUser.setUserName(resultSet.getString("emp_username"));
		mapUser.setUserPassword(resultSet.getString("emp_pwd"));
		mapUser.setEmailId(resultSet.getString("emp_email_id"));
		mapUser.setActivatedOn(resultSet.getDate("activated_on"));
		mapUser.setFirstName(resultSet.getString("firstname"));
		mapUser.setLastName(resultSet.getString("lastname"));
		mapUser.setdDOB(resultSet.getDate("dob"));
		mapUser.setDOB(resultSet.getString("dob"));
		mapUser.setMobileNumber(resultSet.getString("emp_mobile_no"));
		if(resultSet.getString("emp_gender").equals("M")) {
		mapUser.setGender("Male");}
		else if(resultSet.getString("emp_gender").equals("F")) {
			mapUser.setGender("Female");
		}
		else{
			mapUser.setGender("Neutral");
		}
		mapUser.setAddress(resultSet.getString("address"));
		mapUser.setCity(resultSet.getString("city"));
		mapUser.setPostalCode(resultSet.getInt("postal_code"));
		mapUser.setStateCodedesc(resultSet.getString("state_code"));
		mapUser.setDistrictCodeDesc(resultSet.getString("district_code"));
		mapUser.setDesignation(resultSet.getString("emp_designation"));
		mapUser.setUserType(resultSet.getInt("emp_type"));
		mapUser.setFile1(resultSet.getBytes("profile_photo"));
		mapUser.setActivatedBy(resultSet.getString("activated_by"));
		mapUser.setActivatedClientIp(resultSet.getString("activated_client_ip"));
		mapUser.setActiveStatus(resultSet.getString("active_status"));
		mapUser.setDeactivatedOn(resultSet.getDate("deactivated_on"));
		mapUser.setDeactivatedBy(resultSet.getString("deactivated_by"));
		mapUser.setDeactivatedClientIp(resultSet.getString("deactivated_client_ip"));
		mapUser.setUserRole(resultSet.getInt("emp_role"));
		mapUser.setEnteredOn(resultSet.getDate("entered_on"));
		mapUser.setEnteredBy(resultSet.getString("entered_by"));
		mapUser.setPasswordUpdatedOn(resultSet.getDate("password_updated_on"));
		return mapUser;
	}
}
