package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.Gender;
import ems.entity.ProjectType;

public class ProjectTypeMapper implements RowMapper<ProjectType> {

	@Override
	public ProjectType mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProjectType mapGender = new ProjectType();
		mapGender.setProjectTypeId(rs.getInt("type_id"));
		mapGender.setProjectTypeDesc(rs.getString("type_desc"));
		mapGender.setEnteredOn(rs.getDate("entered_on"));
		mapGender.setEnteredBy(rs.getString("entered_by"));
		mapGender.setClientIp(rs.getString("client_ip"));
		return mapGender;
	}
}
