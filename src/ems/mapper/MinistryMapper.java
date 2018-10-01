package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import ems.entity.Employee;
import ems.entity.Ministry;


public class MinistryMapper implements RowMapper<Ministry> {

	@Override
	public Ministry mapRow(ResultSet rs, int rowNum) throws SQLException {
		Ministry m=new  Ministry();
		m.setActiveStatus(rs.getString("active_status"));
		m.setClientIp(rs.getString("client_ip"));
		m.setEnteredBy(rs.getString("entered_by"));
		m.setEnteredOn(rs.getDate("entered_on"));
		
		m.setMinistryDesc(rs.getString("ministry_desc"));
		m.setMinistryId(rs.getInt("ministry_id"));
		return m;
		// TODO Auto-generated method stub

	}

}
