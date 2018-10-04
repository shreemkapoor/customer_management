package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.Gender;
import ems.entity.Priority;

public class PriorityMapper implements RowMapper<Priority> {

	@Override
	public Priority mapRow(ResultSet rs, int rowNum) throws SQLException {
		Priority mapPriority = new Priority();
		mapPriority.setPriorityId(rs.getString("priority_id"));
		mapPriority.setPriorityDesc(rs.getString("priority_desc"));
		return mapPriority;
	}
}
