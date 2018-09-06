package ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import ems.entity.AccessUrl;
import ems.entity.District;
import ems.entity.Employee;
import ems.entity.Gender;
import ems.entity.State;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.entity.UserType;
import ems.mapper.AccessUrlMapper;
import ems.mapper.DistrictMapper;
import ems.mapper.EmployeeMapper;
import ems.mapper.GenderMapper;
import ems.mapper.StateMapper;
import ems.mapper.SubUrlMapper;
import ems.mapper.UserRoleMapper;
import ems.mapper.UserTypeMapper;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{

	@Autowired
	private DataSource myDataSource;
	private JdbcTemplate jdbcTemplate; // implementing datasource and jdbctemplate

	@Autowired
	public void setDataSource(DataSource myDataSource) {
		this.myDataSource = myDataSource;
		this.jdbcTemplate = new JdbcTemplate(myDataSource);
	}
	
	@Override
	public Employee getUser(String name) {
		
		
		Employee databaseUser=new Employee();
		try {
			databaseUser= jdbcTemplate.queryForObject("select * from mst_emp where emp_email_id=?",
						new Object[] {name},new EmployeeMapper());
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("user " +  databaseUser.getUserName());
			 return databaseUser;
			
	}

	@Override
	public int createEmployee(Employee theEmployee) {
		try {
		int i= jdbcTemplate.update("insert into mst_emp(emp_id,firstname, lastname, emp_email_id,emp_designation,"
									+ "emp_mobile_no,emp_gender,active_status,activated_on,activated_by,activated_client_ip,"
									+ "state_code,district_code,"
									+ "emp_role,emp_type,dob,address,city,postal_code,profile_photo,"
									+ "emp_username,emp_pwd,entered_on,entered_by)"
									+ " values((select ('EMP' || COALESCE( Lpad(((select (max(substring(emp_id from 4 for 7)::numeric))+1)::text),4,'0'), '0001' ))  from mst_emp),"
									+ "	?,?,?,?,?,?,?,now(),?,?,?,?,?,?,?,?,?,?,?,?,?,now(),?)",
							new Object[] {theEmployee.getFirstName(),theEmployee.getLastName(),theEmployee.getEmailId(),
									theEmployee.getDesignation(),theEmployee.getMobileNumber(),theEmployee.getGender(),
									theEmployee.getActiveStatus(),theEmployee.getActivatedBy(),
									theEmployee.getActivatedClientIp(),theEmployee.getStateCode(),theEmployee.getDistrictCode(),
									theEmployee.getUserRole(),theEmployee.getUserType(),theEmployee.getdDOB(),
									theEmployee.getAddress(),theEmployee.getCity(),theEmployee.getPostalCode(),theEmployee.getFile1(),
									theEmployee.getUserName(),theEmployee.getUserPassword(),
									theEmployee.getActivatedBy()});
		return i;
	}catch(Exception e) {
		e.printStackTrace();
		return 0;
	}
		
		}

	@Override
	public List<State> getEmpStateList() {
		List<State> stateList = new ArrayList<State>();

		try {
		stateList=jdbcTemplate.query("select state_desc,state_code from mst_state", new StateMapper() );
		}catch(Exception e) {
			e.printStackTrace();
		}
		return stateList;
		}

	@Override
	public List<District> getEmpDistrictList(State stateCode) {
		List<District> districtList = new ArrayList();
		try {
			districtList = jdbcTemplate.query
						("select district_desc,district_code from mst_district where state_code=? ",  new Object[] {Integer.parseInt(stateCode.getStateCode().trim())}, new DistrictMapper() );
		
		
		System.out.println(districtList.size());}catch(Exception e) {
			e.printStackTrace();
		}
		return districtList;
	}

	@Override
	public List<AccessUrl> getUrl(int userRole) {
		List<AccessUrl> accessUrl = new ArrayList<>();
		try {
		accessUrl=jdbcTemplate.query("select * from mst_url_access where ?  = ANY(role_id)",new Object[] {userRole},new AccessUrlMapper());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return accessUrl;
	}

	@Override
	public List<UserType> getUserTypeList() {
		List<UserType> stateList = new ArrayList<UserType>();
		stateList= jdbcTemplate.query("select role_id,type_desc from mst_type", new UserTypeMapper());
		return stateList;
	}

	@Override
	public List<SubUrl> getsubUrl(int urlId, int userRole) {
		List<SubUrl> url = new ArrayList<SubUrl>();
		url= jdbcTemplate.query("select * from mst_sub_url where url_id=? and role_id=?",new Object[] {urlId,userRole}, new SubUrlMapper());
		return url;
	}

	@Override
	public List<UserRole> getUserRoleList() {
		List<UserRole> stateList = new ArrayList<UserRole>();
		stateList= jdbcTemplate.query("select role_id,role_desc from mst_role", new UserRoleMapper());
		return stateList;
		
	}

	@Override
	public List<Gender> getGenderList() {
		List<Gender> genderList = new ArrayList<Gender>();
		genderList= jdbcTemplate.query("select gender_id,gender_desc from mst_gender", new GenderMapper());
		return genderList;
	}

	@Override
	public List<Employee> getEmployees() {
		return jdbcTemplate.query("select * from mst_emp",new EmployeeMapper()/*new ResultSetExtractor<List<Employee>>(){  
  			@Override
	public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {
		 List<Employee> list=new ArrayList<Employee>();  
	        while(rs.next()){  
	        	Employee theEmployee=new Employee();  
	        	theEmployee.setFirstName(rs.getString("firstname")); 
	        	theEmployee.setLastName(rs.getString("lastname"));  
	        	theEmployee.setDesignation(rs.getString("emp_designation"));
	        	theEmployee.setEmailId(rs.getString("emp_email_id"));
	        list.add(theEmployee);  
	        }  
	        return list; 
	}
  			}*/);	}  
	}
