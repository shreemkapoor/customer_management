package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.UserRole;
import ems.entity.UserType;

public class UserRoleMapper implements RowMapper<UserRole>{

	@Override
	public UserRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserRole mapType = new UserRole();
		mapType.setRoleId(rs.getInt("role_id"));
		mapType.setRoleDesc(rs.getString("role_desc"));
		return mapType;
	}

}
