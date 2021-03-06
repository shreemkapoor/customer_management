package ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.dao.EmployeeDao;
import ems.entity.AccessUrl;
import ems.entity.Designation;
import ems.entity.District;
import ems.entity.Employee;
import ems.entity.Gender;
import ems.entity.Ministry;
import ems.entity.ProfessionalDetails;
import ems.entity.State;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.entity.UserType;
import ems.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public Employee getUser(String name) {
		return employeeDao.getUser(name);
	}

	@Override
	public int createEmployee(Employee theEmployee) {
		return employeeDao.createEmployee(theEmployee);
	}

	@Override
	public List<State> getEmpStateList() {
		return employeeDao.getEmpStateList();
	}

	@Override
	public List<District> getEmpDistrictList(State stateCode) {
		return employeeDao.getEmpDistrictList(stateCode);		
		}

	@Override
	public List<AccessUrl> getUrl(int userRole) {
		return employeeDao.getUrl(userRole);
	}

	@Override
	public List<UserType> getUserTypeList() {
		return employeeDao.getUserTypeList();
	}

	@Override
	public List<SubUrl> getsubUrl(int urlId, int userRole) {
		// TODO Auto-generated method stub
		return employeeDao.getsubUrl(urlId,userRole);
	}

	@Override
	public List<UserRole> getUserRoleList() {
		// TODO Auto-generated method stub
		return employeeDao.getUserRoleList();
	}

	@Override
	public List<Gender> getGenderList() {
		// TODO Auto-generated method stub
		return employeeDao.getGenderList();
	}

	@Override
	public List<Employee> getEmployees() {
		return employeeDao.getEmployees();
	}

	@Override
	public int updateEmployee(Employee thEmployee) {
		return employeeDao.updateEmployee(thEmployee);
	}

	@Override
	public int deleteEmployee(String emailId) {
		return employeeDao.deleteEmployee(emailId);
	}

	@Override
	public List<AccessUrl> getUrl() {
		// TODO Auto-generated method stub
		return employeeDao.getUrl();
	}

	@Override
	public List<SubUrl> getsubUrlByUrl(int parseInt) {
		// TODO Auto-generated method stub
		return employeeDao.getsubUrlByUrl(parseInt);
	}

	@Override
	public int createRole(UserRole role) {
		return employeeDao.createRole(role);
	}

	@Override
	public int updateRole(UserRole role) {
		return employeeDao.updateRole(role);
	}

	@Override
	public int deleteRole(String roleId) {
		return employeeDao.deleteRole(roleId);
	}

	@Override
	public List<Designation> getDesignationList() {
		return employeeDao.getDesignationList();
	}

	@Override
	public int createDesignation(Designation designation) {
		// TODO Auto-generated method stub
		return employeeDao.createDesignation(designation);
	}

	@Override
	public int updateDesignation(Designation designation) {
		return employeeDao.updateDesignation(designation);
	}

	@Override
	public int deleteDesignation(String designationId) {
		return employeeDao.deleteDesignation(designationId);
	}

	@Override
	public int professionalDetails(Employee profdet) {
		return employeeDao.professionalDetails(profdet);
	}

	@Override
	public List<Ministry> getMinistryList() {
		return employeeDao.getMinistryList();
	}

	@Override
	public int createMinistry(Ministry ministry) {
		// TODO Auto-generated method stub
		return employeeDao.createMinistry(ministry);
	}

	@Override
	public int updateMinistry(Ministry ministry) {
		return employeeDao.updateMinistry(ministry);
	}

	@Override
	public int deleteMinistry(String ministryId) {
		return employeeDao.deleteMinistry(ministryId);
	}

	@Override
	public int insertEmpUrl(String roleid, String urlid, String subUrlid) {
		return employeeDao.insertEmpUrl(roleid,urlid,subUrlid);
	}

	
	
}