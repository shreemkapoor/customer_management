
package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.Project;
import ems.entity.ProjectDetails;

public class ProjectMapper implements RowMapper<Project> {

	@Override
	public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
		Project mapdetails = new Project();
		mapdetails.setProjectName(rs.getString("project_name"));
		mapdetails.setId(rs.getInt("project_id"));
		mapdetails.setProjectDesc(rs.getString("project_description"));
		mapdetails.setProjectType(rs.getString("project_type"));
		mapdetails.setPriority(rs.getString("priority"));
		mapdetails.setStartDate(rs.getDate("start_date"));
		mapdetails.setSTARTDATE(rs.getString("start_date"));
		mapdetails.setEndDate(rs.getDate("end_date"));
		mapdetails.setENDDATE(rs.getString("end_date"));
		mapdetails.setEntered_by(rs.getString("entered_by"));
		mapdetails.setEntered_on(rs.getDate("entered_on"));
		mapdetails.setEmailId(rs.getString("emp_email_id"));
		return mapdetails;
	}
}
