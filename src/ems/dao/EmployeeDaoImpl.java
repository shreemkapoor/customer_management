package ems.dao;

import java.sql.PreparedStatement;
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
import ems.entity.Designation;
import ems.entity.District;
import ems.entity.Education;
import ems.entity.Employee;
import ems.entity.Gender;
import ems.entity.Ministry;
import ems.entity.ProfessionalDetails;
import ems.entity.State;
import ems.entity.SubUrl;
import ems.entity.UserRole;
import ems.entity.UserType;
import ems.mapper.AccessUrlMapper;
import ems.mapper.DesignationMapper;
import ems.mapper.DistrictMapper;
import ems.mapper.EmployeeMapper;
import ems.mapper.GenderMapper;
import ems.mapper.MinistryMapper;
import ems.mapper.StateMapper;
import ems.mapper.SubUrlMapper;
import ems.mapper.UserRoleMapper;
import ems.mapper.UserTypeMapper;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
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
		try {
		stateList= jdbcTemplate.query("select role_id,type_desc from mst_type", new UserTypeMapper());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return stateList;
	}

	@Override
	public List<SubUrl> getsubUrl(int urlId, int userRole) {
		List<SubUrl> url = new ArrayList<SubUrl>();
		try {
		url= jdbcTemplate.query("select * from mst_sub_url where url_id=? and  ?  = ANY(role_id)",new Object[] {urlId,userRole}, new SubUrlMapper());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return url;
	}
	
	@Override
	public List<SubUrl> getsubUrlByUrl(int parseInt) {
		List<SubUrl> subUrlList= new ArrayList<>();
		subUrlList= jdbcTemplate.query("select * from mst_sub_url where url_id=?",new Object[] {parseInt},new SubUrlMapper());
		return subUrlList;
	}


	@Override
	public List<UserRole> getUserRoleList() {
		List<UserRole> stateList = new ArrayList<UserRole>();
		try {
		stateList= jdbcTemplate.query("select role_id,role_desc from mst_role order by role_id", new UserRoleMapper());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return stateList;
		
	}

	@Override
	public List<Gender> getGenderList() {
		List<Gender> genderList = new ArrayList<Gender>();
		try {
		genderList= jdbcTemplate.query("select gender_id,gender_desc from mst_gender", new GenderMapper());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
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

	@Override
	public int updateEmployee(Employee thEmployee) {
		int i=0;
		try {
		i=jdbcTemplate.update("update mst_emp set firstname=?, lastname=?,emp_designation=?,"
								 + "emp_mobile_no=?,emp_gender=?,state_code=?,district_code=?,"
								 + "emp_role=?,emp_type=?,dob=?,address=?,city=?,postal_code=?,profile_photo=? "
								 + "where emp_email_id=?"
									, new Object[] {thEmployee.getFirstName(),thEmployee.getLastName(),
									thEmployee.getDesignation(),thEmployee.getMobileNumber(),
									thEmployee.getGender(),thEmployee.getStateCode(),thEmployee.getDistrictCode(),
									thEmployee.getUserRole(),thEmployee.getUserType(),thEmployee.getdDOB(),
									thEmployee.getAddress(),thEmployee.getCity(),thEmployee.getPostalCode(),
									thEmployee.getFile1(),thEmployee.getEmailId()});
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(">>>>>>>"+i);
		return i;
	}

	@Override
	public int deleteEmployee(String emailId) {
		int i=0;
		try {
			i=jdbcTemplate.update("delete from mst_emp where emp_email_id=?", new Object[] {emailId});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<AccessUrl> getUrl() {
		List<AccessUrl> accessUrl = new ArrayList<>();
		try {
		accessUrl=jdbcTemplate.query("select * from mst_url_access ",new AccessUrlMapper());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return accessUrl;
	}

	@Override
	public int createRole(UserRole role) {
		try {
		int i = jdbcTemplate.update("insert into mst_role(role_desc,active_status,entered_by,entered_on,client_ip)"
				+ "values (?,?,?,now(),?)" , new Object[] {role.getRoleDesc(),role.getActiveStatus(),role.getEnteredBy(),
						role.getClientIp()});
		return i;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateRole(UserRole role) {
		int i = jdbcTemplate.update("update mst_role set role_desc=? where role_id=?" , new Object[] 
				{role.getRoleDesc(), role.getRoleId()} );
		return i;
	}

	@Override
	public int deleteRole(String roleId) {
		int i=0;
		try {
			i=jdbcTemplate.update("delete from mst_role where role_id=?", new Object[] {Integer.parseInt(roleId)});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Designation> getDesignationList() {
		List<Designation> designationList = new ArrayList<Designation>();
		try {
			designationList= jdbcTemplate.query("select designation_id,designation_desc from mst_designation", new DesignationMapper());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return designationList;
	}

	@Override
	public int createDesignation(Designation designation) {
		try {
			int i = jdbcTemplate.update("insert into mst_designation(designation_desc,active_status,entered_by,entered_on,client_ip)"
					+ "values (?,?,?,now(),?)" , new Object[] {designation.getDesignationDesc(),designation.getActiveStatus(),designation.getEnteredBy(),
							designation.getClientIp()});
			return i;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public int updateDesignation(Designation designation) {
		int i = jdbcTemplate.update("update mst_designation set designation_desc=? where designation_id=?" , new Object[] 
				{designation.getDesignationDesc(), designation.getDesignationId()} );
		return i;
	}

	@Override
	public int deleteDesignation(String designationId) {
		int i=0;
		try {
			i=jdbcTemplate.update("delete from mst_designation where designation_id=?", new Object[] {Integer.parseInt(designationId)});
		}catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int professionalDetails(Employee profdet) {
		int i[]= {0};
	
		try {
			i=jdbcTemplate.batchUpdate("insert into mst_education (education,course,university,start_year,end_year,"
					+ "percent_scored,emp_email_id,entered_by,entered_on)values(?,?,?,?,?,?,?,?,now())",new BatchPreparedStatementSetter() {
			   public void setValues(PreparedStatement ps, int i)
			     throws SQLException {
				   Education edu = profdet.getEduList().get(i);
			    ps.setString(1, edu.getEducation());
			    ps.setString(2, edu.getCourse());
			    ps.setString(3, edu.getUniversity());
			    ps.setString(4, edu.getSTARTDATE());
			    ps.setString(5, edu.getENDDATE());
			    ps.setString(6, edu.getPercentage());
			    ps.setString(7, profdet.getEmailId());
			    ps.setString(8, profdet.getEnteredBy());
			   }

			   public int getBatchSize() {
			    return profdet.getEduList().size();
			   }
			  });
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			i=jdbcTemplate.batchUpdate("insert into mst_professional (company_name,designation,start_date,end_date,experience_summary,"
					+ "emp_email_id,entered_by,entered_on)values(?,?,?,?,?,?,?,now())",new BatchPreparedStatementSetter() {
			   public void setValues(PreparedStatement ps, int i)
			     throws SQLException {
				   ProfessionalDetails edu = profdet.getProList().get(i);
			    ps.setString(1, edu.getCompanyName());
			    ps.setString(2, edu.getDesignation());
			    ps.setString(3, edu.getSTARTDATE());
			    ps.setString(4, edu.getENDDATE());
			    ps.setString(5, edu.getExperienceSummary());
			    ps.setString(6, profdet.getEmailId());
			    ps.setString(7, profdet.getEnteredBy());
			   }

			   public int getBatchSize() {
			    return profdet.getProList().size();
			   }
			  });
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	if(i[0]>0) {
		return 1;
	}
	return 0;
	}
	@Override
	public int saveMinistry(Ministry mini) {
		try {
			int i = jdbcTemplate.update("insert into mst_ministry(ministry_dsc,active_status,entered_by,entered_on,client_ip)"
					+ "values (?,?,?,now(),?)" , new Object[] {mini.getMinistryName(),mini.getActiveStatus(),mini.getEnteredBy(),mini.getClientIp()});
			return i;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return 0;
	}

	@Override
	public List<Ministry> getMinistry() {
		List<Ministry> accessUrl = new ArrayList<>();
		try {
		accessUrl=jdbcTemplate.query("select * from mst_ministry ",new MinistryMapper());
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return accessUrl;
	}

}
