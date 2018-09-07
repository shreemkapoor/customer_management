package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.UserType;

public class UserTypeMapper implements RowMapper<UserType>{

	@Override
	public UserType mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserType mapType = new UserType();
		mapType.setRoleId(rs.getInt("role_id"));
		mapType.setTypeDesc(rs.getString("type_desc"));
		return mapType;
	}

}
