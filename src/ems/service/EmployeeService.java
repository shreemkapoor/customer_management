package ems.service;

import java.util.List;

import ems.entity.AccessUrl;
import ems.entity.District;
import ems.entity.Employee;
import ems.entity.Gender;
import ems.entity.State;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.entity.UserType;

public interface EmployeeService {

	public Employee getUser(String name);

	public int createEmployee(Employee theEmployee);

	public List<State> getEmpStateList();
	
	public List<District> getEmpDistrictList(State stateCode);

	public List<AccessUrl> getUrl(int userRole);

	public List<UserType> getUserTypeList();

	public List<SubUrl> getsubUrl(int urlId,int userRole);

	public List<UserRole> getUserRoleList();

	public List<Gender> getGenderList();
	
}
