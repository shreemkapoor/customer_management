package ems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.dao.EmployeeDao;
import ems.entity.AccessUrl;
import ems.entity.District;
import ems.entity.Employee;
import ems.entity.Gender;
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
}