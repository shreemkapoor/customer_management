package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.AccessUrl;

public class AccessUrlMapper implements RowMapper<AccessUrl> {

	@Override
	public AccessUrl mapRow(ResultSet resultset, int rowNum) throws SQLException {
		AccessUrl mapUrl = new AccessUrl();
		mapUrl.setUrlDesc(resultset.getString("url_desc"));
		mapUrl.setUrl(resultset.getString("url"));
		mapUrl.setUrlId(resultset.getInt("url_id"));
		return mapUrl;
	}

	
}
