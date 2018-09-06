package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.Gender;

public class GenderMapper implements RowMapper<Gender> {

	@Override
	public Gender mapRow(ResultSet rs, int rowNum) throws SQLException {
		Gender mapGender = new Gender();
		mapGender.setGenderId(rs.getString("gender_id"));
		mapGender.setGenderDesc(rs.getString("gender_desc"));
		return mapGender;
	}
}
