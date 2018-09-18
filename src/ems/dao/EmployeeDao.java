package ems.dao;

import java.util.List;

import ems.entity.AccessUrl;
import ems.entity.District;
import ems.entity.Employee;
import ems.entity.Gender;
import ems.entity.State;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.entity.UserType;
import ems.entity.Employee;

public interface EmployeeDao {

	public Employee getUser(String name);

	public int createEmployee(Employee theEmployee);

	public List<State> getEmpStateList();

	public List<District> getEmpDistrictList(State stateCode);

	public List<AccessUrl> getUrl(int userRole);

	public List<UserType> getUserTypeList();

	public List<SubUrl> getsubUrl(int urlId, int userRole);

	public List<UserRole> getUserRoleList();

	public List<Gender> getGenderList();

	public List<Employee> getEmployees();

	public int updateEmployee(Employee thEmployee);

	public int deleteEmployee(String emailId);

	public List<AccessUrl> getUrl();

	public List<SubUrl> getsubUrlByUrl(int parseInt);

	public int createRole(UserRole role);
}
