package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.State;

public class StateMapper implements RowMapper<State>{

	@Override
	public State mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		State mapState = new State();
		
		mapState.setStateCode(resultSet.getString("State_code"));
		mapState.setStateDesc(resultSet.getString("State_desc"));
		
		return mapState;
	}

}
