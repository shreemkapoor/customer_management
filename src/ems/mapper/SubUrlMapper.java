package ems.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import ems.entity.AccessUrl;
import ems.entity.SubUrl;

public class SubUrlMapper implements RowMapper<SubUrl> {

	@Override
	public SubUrl mapRow(ResultSet resultset, int rowNum) throws SQLException {
		SubUrl mapUrl = new SubUrl();
		mapUrl.setSubUrlDesc(resultset.getString("sub_url_desc"));
		mapUrl.setSubUrl(resultset.getString("sub_url"));
		mapUrl.setUrlId(resultset.getInt("url_id"));
		mapUrl.setSubUrlId(resultset.getInt("sub_url_id"));
		return mapUrl;
	}

	
}
