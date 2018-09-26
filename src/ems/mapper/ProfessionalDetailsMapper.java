
package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.ProfessionalDetails;

public class ProfessionalDetailsMapper implements RowMapper<ProfessionalDetails> {

	@Override
	public ProfessionalDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProfessionalDetails mapdetails = new ProfessionalDetails();
		mapdetails.setCompanyName(rs.getString("company_name"));
		mapdetails.setDesignation(rs.getString("designation"));
		mapdetails.setStartDate(rs.getDate("start_date"));
		mapdetails.setSTARTDATE(rs.getString("start_date"));
		mapdetails.setEndDate(rs.getDate("end_date"));
		mapdetails.setENDDATE(rs.getString("end_date"));
		mapdetails.setExperienceSummary(rs.getString("experience_summary"));
		mapdetails.setExperienceRange(rs.getString("experience_range"));
		mapdetails.setDomainsWorkedOn(rs.getString("domains_worked_on"));
		mapdetails.setEntered_by(rs.getString("entered_by"));
		mapdetails.setEntered_on(rs.getDate("entered_on"));
		mapdetails.setEmailId(rs.getString("emp_email_id"));
		return mapdetails;
	}

}
