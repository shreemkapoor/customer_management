
package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.ProfessionalDetails;
import ems.entity.ProjectDetails;

public class ProjectDetailsMapper implements RowMapper<ProjectDetails> {

	@Override
	public ProjectDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectDetails mapdetails = new ProjectDetails();
		mapdetails.setProjectName(rs.getString("project"));
		mapdetails.setProjectBrief(rs.getString("project_brief"));
		mapdetails.setTechUsed(rs.getString("tech_used"));
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
