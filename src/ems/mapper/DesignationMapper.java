package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.Designation;


public class DesignationMapper implements RowMapper<Designation> {

	@Override
	public Designation mapRow(ResultSet rs, int rowNum) throws SQLException {
		Designation mapDesignation = new Designation();
		mapDesignation.setDesignationId(rs.getInt("designation_id"));
		mapDesignation.setDesignationDesc(rs.getString("designation_desc"));
		return mapDesignation;
	}
}
