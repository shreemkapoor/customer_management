package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.District;

public class DistrictMapper implements RowMapper<District>{

	@Override
	public District mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		District mapDistrict = new District();
		mapDistrict.setDistrictCode(resultSet.getString("district_code"));
		mapDistrict.setDistrictDesc(resultSet.getString("district_desc"));
		return mapDistrict;
	}

}
